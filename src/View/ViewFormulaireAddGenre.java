package View;


import Tools.BDDManager;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class ViewFormulaireAddGenre {

    private Group root;
    private Label labelGenre;
    private TextField inputGenre;
    private Button btnValide;
    private Text titre;
    private Text sousTitre;
    private BDDManager bddManager;
    private ComboBox<String> comboGenres;


    public ViewFormulaireAddGenre(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
        initComboBox();
    }

    public void initTitre() {
        titre = new Text(20, 50, "Insérer un nouveau genre");
        titre.setFont(new Font(30));
        sousTitre = new Text(20,170,"Liste des Genres existant : ");
        sousTitre.setFont(new Font(20));
    }

    public void initLabel() {

        labelGenre = new Label("Genre :");
        labelGenre.setTranslateX(50);
        labelGenre.setTranslateY(100);
        labelGenre.setStyle("-fx-font-size: 20px;");

    }

    public void initInput() {

        inputGenre = new TextField();
        inputGenre.setTranslateX(150);
        inputGenre.setTranslateY(100);
    }

    public void initComboBox(){

        comboGenres = new ComboBox<>();
        comboGenres.setTranslateX(260);
        comboGenres.setTranslateY(150);
        bddManager = new BDDManager();
        bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
        String requete = "SELECT Libelle_Genre FROM genre";
        ArrayList <ArrayList<String>> listResult = bddManager.select(requete);

        for (int i = 0; i < listResult.size(); i++) {

            System.out.println(listResult.get(i));
            for (String libelle: listResult.get(i)) {

                comboGenres.getItems().add(libelle);
            }
        }
        System.out.println(bddManager.select(requete));

    }

    public void initBoutton() {

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(280);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;");
        btnValide.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String valueInput = getInputGenre().getText();
                System.out.println(valueInput);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
                String requete = "INSERT INTO `genre`(`Libelle_Genre`) VALUES ('" + valueInput + "')";
                System.out.println(requete);
                bddManager.insert(requete);
                bddManager.stop();

            }
        });


    }

    public void afficherFormulaireAddGenre() {
        root.getChildren().clear();
        root.getChildren().add(labelGenre);
        root.getChildren().add(inputGenre);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);
        root.getChildren().add(sousTitre);
        root.getChildren().add(comboGenres);

    }

    public TextField getInputGenre() {
        return inputGenre;
    }
}
