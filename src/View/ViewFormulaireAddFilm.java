package View;

import Tools.BDDManager;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewFormulaireAddFilm {

    private Group root;
    private Label labelTitreFilm;
    private Label labelAnneeFilm;
    private Label labelNoteFilm;
    private Label labelResumerFilm;
    private Label labelImageFilm;
    private TextField inputTitreFilm;
    private TextField inputAnneeFilm;
    private TextField inputNoteFilm;
    private TextArea inputResumerFilm;
    private Button btnValide;
    private Text titre;
    private FileChooser fileChooser;
    private Button btnselectFile;
    private Window mainStage;
    private BDDManager bddManager;
    private File selectedFile;
    private ComboBox<String> comboFilm;
    private Text sousTitre;
    private Button btnDelete;
    private HashMap<String, Integer> tableFilm;

    public ViewFormulaireAddFilm(Group root) {
        this.root = root;

        initLabel();
        initInput();
        initBoutton();
        initTitre();
        initFileChooser();
        initComboBox();
    }

    public void initTitre() {
        titre = new Text(20, 50, "Insérer un nouveau Film");
        titre.setFont(new Font(30));
        sousTitre = new Text(20,450,"Liste des Films existant : ");
        sousTitre.setFont(new Font(20));
    }

    public void initLabel() {

        labelTitreFilm = new Label("Titre Film :");
        labelTitreFilm.setTranslateX(50);
        labelTitreFilm.setTranslateY(100);
        labelTitreFilm.setStyle("-fx-font-size: 20px;");
        labelAnneeFilm = new Label("Année :");
        labelAnneeFilm.setTranslateX(75);
        labelAnneeFilm.setTranslateY(150);
        labelAnneeFilm.setStyle("-fx-font-size: 20px;");
        labelNoteFilm = new Label("Note :");
        labelNoteFilm.setTranslateX(85);
        labelNoteFilm.setTranslateY(200);
        labelNoteFilm.setStyle("-fx-font-size: 20px;");
        labelResumerFilm = new Label("Résumé :");
        labelResumerFilm.setTranslateX(60);
        labelResumerFilm.setTranslateY(250);
        labelResumerFilm.setStyle("-fx-font-size: 20px;");
        labelImageFilm = new Label("Image :");
        labelImageFilm.setTranslateX(75);
        labelImageFilm.setTranslateY(370);
        labelImageFilm.setStyle("-fx-font-size: 20px;");
    }

    public void initInput() {

        inputTitreFilm = new TextField();
        inputTitreFilm.setTranslateX(150);
        inputTitreFilm.setTranslateY(100);
        inputAnneeFilm = new TextField();
        inputAnneeFilm.setTranslateX(150);
        inputAnneeFilm.setTranslateY(150);
        inputNoteFilm = new TextField();
        inputNoteFilm.setTranslateX(150);
        inputNoteFilm.setTranslateY(200);
        inputResumerFilm = new TextArea();
        inputResumerFilm.setMaxWidth(300);
        inputResumerFilm.setMaxHeight(100);
        inputResumerFilm.setTranslateX(150);
        inputResumerFilm.setTranslateY(250);

    }
    public void initFileChooser() {

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        btnselectFile = new Button("Select File");
        btnselectFile.setTranslateX(150);
        btnselectFile.setTranslateY(370);

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));

        btnselectFile.setOnMouseClicked(e -> {
             selectedFile = fileChooser.showOpenDialog(mainStage);
            if (selectedFile != null) {
               // mainStage.display(selectedFile);
            }
        });
    }
    public void initBoutton() {

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(550);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;");
        btnValide.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String valueInput = getInputTitreFilm().getText();
                String valueInputAnnee = getInputAnneeFilm().getText();
                int valueIntAnnee = Integer.parseInt(valueInputAnnee);
                System.out.println(valueIntAnnee);
                String valueInputNote = getInputNoteFilm().getText();
                int valueIntNote = Integer.parseInt(valueInputNote);
                System.out.println(valueInputNote);
                System.out.println(valueIntNote);
                String valueInputResumer = getInputResumerFilm().getText();
                System.out.println(valueInputResumer);
                String valueFileChoose = selectedFile.getAbsolutePath();
                System.out.println(valueFileChoose);
                System.out.println(valueInput);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
                String requeteSelect = "SELECT * FROM `Film` WHERE Nom_Film = '" + valueInput + "'";
                ArrayList<ArrayList<String>> listResult = bddManager.select(requeteSelect);

                if (listResult.isEmpty()) {

                    String requete = "INSERT INTO `Film`(`Nom_Film`,Annee_Film,Note_Film,Resume_Film,Image_Film,Realisateur_id,Nationnalite_id) VALUES ('" + valueInput + "','" + valueIntAnnee + "','" + valueIntNote + "','" + valueInputResumer + "','" + valueFileChoose + "', NULL,NULL)";
                    System.out.println(requete);
                    bddManager.insert(requete);
                    bddManager.stop();

                }else{

                    System.out.println("Il est déjà présent !");
                }
            }
        });
        btnDelete = new Button("Delete");
        btnDelete.setTranslateX(250);
        btnDelete.setTranslateY(550);
        btnDelete.setStyle("-fx-background-color : RED;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;");
        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String valueComboBox = getComboFilm().getValue();
                System.out.println(valueComboBox);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
             //   String[] chaineCoupe = comboActeur.getValue().split(" ");
                String requete = "DELETE FROM `Film` WHERE `Nom_Film` ='"+valueComboBox+"'";
                bddManager.delete(requete);
                bddManager.stop();
            }
        });
    }
    public void initComboBox(){

        comboFilm = new ComboBox<>();
        comboFilm.setTranslateX(250);
        comboFilm.setTranslateY(430);
        bddManager = new BDDManager();
        bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
        String requete = "SELECT * FROM Film";
        ArrayList <ArrayList<String>> listResult = bddManager.select(requete);

        tableFilm = new HashMap<>();

      /*  for (int i = 0; i < listResult.size(); i++) {

            comboFilm.getItems().add((listResult.get(i).get(1)));
        }*/

        for (int i = 0; i < listResult.size(); i++) {

            tableFilm.put((listResult.get(i).get(1)), Integer.parseInt(listResult.get(i).get(0)));
            System.out.println(tableFilm);
        }
        comboFilm.getItems().addAll(tableFilm.keySet());
        //System.out.println(tableFilm);
        System.out.println(bddManager.select(requete));

    }
    public void afficherFormulaireAddFilm() {
        root.getChildren().clear();
        root.getChildren().add(labelTitreFilm);
        root.getChildren().add(labelAnneeFilm);
        root.getChildren().add(labelNoteFilm);
        root.getChildren().add(labelResumerFilm);
        root.getChildren().add(labelImageFilm);
        root.getChildren().add(inputTitreFilm);
        root.getChildren().add(inputAnneeFilm);
        root.getChildren().add(inputNoteFilm);
        root.getChildren().add(inputResumerFilm);
        root.getChildren().add(btnselectFile);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);
        root.getChildren().add(comboFilm);
        root.getChildren().add(sousTitre);
        root.getChildren().add(btnDelete);
    }

    public TextField getInputTitreFilm() {
        return inputTitreFilm;
    }

    public TextField getInputAnneeFilm() {
        return inputAnneeFilm;
    }

    public TextField getInputNoteFilm() {
        return inputNoteFilm;
    }

    public TextArea getInputResumerFilm() {
        return inputResumerFilm;
    }

    public ComboBox<String> getComboFilm() {
        return comboFilm;
    }

    public HashMap<String, Integer> getTableFilm() {
        return tableFilm;
    }
}
