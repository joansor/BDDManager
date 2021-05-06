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

import java.awt.*;
import java.util.ArrayList;

public class ViewFormulaireAddRealisateur {

    private Group root;
    private Label labelRealisateur;
    private Label labelRealisateurPrenom;
    private TextField inputRealisateur;
    private TextField inputRealisateurPrenom;
    private Button btnValide;
    private Button btnDelete;
    private Text titre;
    private BDDManager bddManager;
    private ComboBox<String> comboRealisateur;
    private Text sousTitre;

    public ViewFormulaireAddRealisateur(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
        initComboBox();

    }

    public void initTitre() {
        titre = new Text(20, 50, "Insérer un nouveau Réalisateur");
        titre.setFont(new Font(30));
        sousTitre = new Text(20, 220, "Liste des Réalisateurs existant : ");
        sousTitre.setFont(new Font(20));
    }

    public void initLabel() {

        labelRealisateur = new Label("Nom :");
        labelRealisateur.setTranslateX(50);
        labelRealisateur.setTranslateY(100);
        labelRealisateur.setStyle("-fx-font-size: 20px;");
        labelRealisateurPrenom = new Label("Prénom :");
        labelRealisateurPrenom.setTranslateX(25);
        labelRealisateurPrenom.setTranslateY(150);
        labelRealisateurPrenom.setStyle("-fx-font-size: 20px;");

    }

    public void initInput() {

        inputRealisateur = new TextField();
        inputRealisateur.setTranslateX(150);
        inputRealisateur.setTranslateY(100);
        inputRealisateurPrenom = new TextField();
        inputRealisateurPrenom.setTranslateX(150);
        inputRealisateurPrenom.setTranslateY(150);

    }

    public void initComboBox() {

        comboRealisateur = new ComboBox<>();
        comboRealisateur.setTranslateX(300);
        comboRealisateur.setTranslateY(200);
        bddManager = new BDDManager();
        bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
        String requete = "SELECT * FROM Realisateur";
        ArrayList<ArrayList<String>> listResult = bddManager.select(requete);


        for (int i = 0; i < listResult.size(); i++) {

            System.out.println(listResult.get(i));
            comboRealisateur.getItems().add(String.valueOf(listResult.get(i).get(0))+" "+String.valueOf(listResult.get(i).get(1))+" "+ String.valueOf(listResult.get(i).get(2)));

          //  comboRealisateur.getItems().add(String.valueOf(listResult.get(i)));
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

                String valueInput = getInputRealisateur().getText();
                String valueInputPrenom = getInputRealisateurPrenom().getText();
                System.out.println(valueInput);
                System.out.println(valueInputPrenom);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
                String requeteSelect = "SELECT * FROM `Realisateur` WHERE Nom_Realisateur = '" + valueInput + "'OR Prenom_Realisateur ='"+valueInputPrenom+"'";
                ArrayList<ArrayList<String>> listResult = bddManager.select(requeteSelect);
                if (listResult.isEmpty()) {
                    String requete = "INSERT INTO `Realisateur`(`Nom_Realisateur`,`Prenom_Realisateur`) VALUES ('" + valueInput + "','" + valueInputPrenom + "')";
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

                String valueComboBox = getComboRealisateur().getValue();
                System.out.println(valueComboBox);
                bddManager = new BDDManager();
                bddManager.start("jdbc:mysql://localhost:3306/dvdtheque", "root", "");
                String[] chaineCoupe = comboRealisateur.getValue().split(" ");
                String requete = "DELETE FROM `Realisateur` WHERE `Id_Realisateur` ='"+chaineCoupe[0]+"'";
                bddManager.delete(requete);
                bddManager.stop();
            }
        });
    }

    public void afficherFormulaireAddRealisateur() {
        root.getChildren().clear();
        root.getChildren().add(labelRealisateur);
        root.getChildren().add(labelRealisateurPrenom);
        root.getChildren().add(inputRealisateurPrenom);
        root.getChildren().add(inputRealisateur);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);
        root.getChildren().add(comboRealisateur);
        root.getChildren().add(sousTitre);
        root.getChildren().add(btnDelete);
    }

    public TextField getInputRealisateur() {
        return inputRealisateur;
    }

    public TextField getInputRealisateurPrenom() {
        return inputRealisateurPrenom;
    }

    public ComboBox<String> getComboRealisateur() {
        return comboRealisateur;
    }
}
