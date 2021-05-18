package View;

import Controller.ControllerFormulaireAddNationalite;
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

public class ViewFormulaireAddNationalite {

    private Group root;
    private Label labelNationalite;
    private TextField inputNationalite;
    private Button btnValide;
    private Text titre;
    private BDDManager bddManager;
    private Text sousTitre;
    private ComboBox<String> comboNationalite;
    private Button btnDelete;
    private ViewHandler vh;
    private ControllerFormulaireAddNationalite controllerFormulaireAddNationalite;

    public ViewFormulaireAddNationalite(Group root,ViewHandler vh) {
        this.root = root;
        this.controllerFormulaireAddNationalite = new ControllerFormulaireAddNationalite(this,vh);
        initLabel();
        initInput();
        initBoutton();
        initTitre();
        initComboBox();
    }
    public void initTitre(){
        titre = new Text(20,50,"Insérer une nouvelle Nationalité");
        titre.setFont(new Font(30));
        sousTitre = new Text(20,170,"Liste des Nationalités existant : ");
        sousTitre.setFont(new Font(20));
    }
    public void initLabel(){

        labelNationalite = new Label("Nationalité :");
        labelNationalite.setTranslateX(50);
        labelNationalite.setTranslateY(100);
        labelNationalite.setStyle("-fx-font-size: 20px;");


    }
    public void initComboBox(){

        comboNationalite = new ComboBox<>();
        comboNationalite.setTranslateX(300);
        comboNationalite.setTranslateY(150);
        bddManager = new BDDManager();
        bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
        String requete = "SELECT Libelle_Nationnalite FROM Nationnalite";
        ArrayList <ArrayList<String>> listResult = bddManager.select(requete);

        for (int i = 0; i < listResult.size(); i++) {

            System.out.println(listResult.get(i));

                comboNationalite.getItems().add(String.valueOf(listResult.get(i).get(0))+" "+(String.valueOf(listResult.get(i).get(1))));

        }
        System.out.println(bddManager.select(requete));
    }

    public void initInput(){

        inputNationalite = new TextField();
        inputNationalite.setTranslateX(170);
        inputNationalite.setTranslateY(100);

    }
    public void initBoutton(){

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(280);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;" );
        btnValide.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String valueInput = getInputNationalite().getText();
                System.out.println(valueInput);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
                String requeteSelect = "SELECT * FROM `Nationnalite` WHERE Libelle_Nationnalite = '" + valueInput + "'";
                ArrayList<ArrayList<String>> listResult = bddManager.select(requeteSelect);

                if (listResult.isEmpty()) {
                    String requete = "INSERT INTO `Nationnalite`(`Libelle_Nationnalite`) VALUES ('" + valueInput + "')";
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
        btnDelete.setTranslateY(280);
        btnDelete.setStyle("-fx-background-color : RED;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;");
        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String valueComboBox = getComboNationalite().getValue();
                System.out.println(valueComboBox);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
                String[] chaineCoupe = comboNationalite.getValue().split(" ");
                String requete = "DELETE FROM `genre` WHERE `Id_Genre` ='"+chaineCoupe[0]+"'";
                bddManager.delete(requete);
                bddManager.stop();
            }
        });

    }
    public void afficherFormulaireAddNationalite(){
        root.getChildren().clear();
        root.getChildren().add(labelNationalite);
        root.getChildren().add(inputNationalite);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);
        root.getChildren().add(sousTitre);
        root.getChildren().add(comboNationalite);
        root.getChildren().add(btnDelete);

    }

    public TextField getInputNationalite() {
        return inputNationalite;
    }

    public ComboBox<String> getComboNationalite() {
        return comboNationalite;
    }
}
