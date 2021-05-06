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
import java.util.Locale;

public class ViewFormulaireAddActeur {

    private Group root;
    private Label labelActeur;
    private Label labelActeurPrenom;
    private TextField inputActeur;
    private TextField inputActeurPrenom;
    private Button btnValide;
    private Text titre;
    private BDDManager bddManager;
    private ComboBox<String> comboActeur;
    private Text sousTitre;
    private Button btnDelete;

    public ViewFormulaireAddActeur(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
        initComboBox();
    }
    public void initTitre(){
        titre = new Text(20,50,"Insérer un nouveau Acteur");
        titre.setFont(new Font(30));
        sousTitre = new Text(20,220,"Liste des Acteurs existant : ");
        sousTitre.setFont(new Font(20));
    }
    public void initLabel(){

        labelActeur = new Label("Nom :");
        labelActeur.setTranslateX(50);
        labelActeur.setTranslateY(100);
        labelActeur.setStyle("-fx-font-size: 20px;");

        labelActeurPrenom = new Label("Prénom :");
        labelActeurPrenom.setTranslateX(25);
        labelActeurPrenom.setTranslateY(150);
        labelActeurPrenom.setStyle("-fx-font-size: 20px;");


    }
    public void initInput(){

        inputActeur = new TextField();
        inputActeur.setTranslateX(150);
        inputActeur.setTranslateY(100);
        inputActeurPrenom = new TextField();
        inputActeurPrenom.setTranslateX(150);
        inputActeurPrenom.setTranslateY(150);


    }
    public void initComboBox(){

        comboActeur = new ComboBox<>();
        comboActeur.setTranslateX(260);
        comboActeur.setTranslateY(200);
        bddManager = new BDDManager();
        bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
        String requete = "SELECT * FROM Acteur";
        ArrayList <ArrayList<String>> listResult = bddManager.select(requete);

        for (int i = 0; i < listResult.size(); i++) {

            System.out.println(listResult.get(i));

            comboActeur.getItems().add(String.valueOf(listResult.get(i).get(0))+" "+String.valueOf(listResult.get(i).get(1))+" "+ String.valueOf(listResult.get(i).get(2)));
        }
        System.out.println(bddManager.select(requete));

    }
    public void initBoutton(){

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(280);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;" );
        btnValide.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String valueInput = getInputActeur().getText().toLowerCase();
                String valueInputPrenom = getInputActeurPrenom().getText();
                System.out.println(valueInput);
                System.out.println(valueInputPrenom);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque","root","");
                String requeteSelect = "SELECT * FROM `Acteur` WHERE Nom_Acteur = '" + valueInput + "'OR Prenom_Acteur ='"+valueInputPrenom+"'";
                ArrayList<ArrayList<String>> listResult = bddManager.select(requeteSelect);
                if (listResult.isEmpty()) {
                    String requete = "INSERT INTO `Acteur`(`Nom_Acteur`,`Prenom_Acteur`) VALUES ('" + valueInput + "','"+valueInputPrenom+"')";
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

                String valueComboBox = getComboActeur().getValue();
                System.out.println(valueComboBox);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
                String[] chaineCoupe = comboActeur.getValue().split(" ");
                String requete = "DELETE FROM `genre` WHERE `Id_Genre` ='"+chaineCoupe[0]+"'";
                bddManager.delete(requete);
                bddManager.stop();
            }
        });

    }
    public void afficherFormulaireAddActeur(){

        root.getChildren().clear();
        root.getChildren().add(labelActeur);
        root.getChildren().add(labelActeurPrenom);
        root.getChildren().add(inputActeurPrenom);
        root.getChildren().add(inputActeur);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);
        root.getChildren().add(comboActeur);
        root.getChildren().add(sousTitre);
        root.getChildren().add(btnDelete);

    }

    public TextField getInputActeur() {
        return inputActeur;
    }

    public TextField getInputActeurPrenom() {
        return inputActeurPrenom;
    }

    public ComboBox<String> getComboActeur() {
        return comboActeur;
    }
}
