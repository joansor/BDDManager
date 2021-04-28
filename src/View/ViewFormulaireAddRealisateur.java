package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;

public class ViewFormulaireAddRealisateur {

    private Group root;
    private Label labelRealisateur;
    private Label labelRealisateurPrenom;
    private TextField inputRealisateur;
    private TextField inputRealisateurPrenom;
    private Button btnValide;
    private Text titre;

    public ViewFormulaireAddRealisateur(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
    }
    public void initTitre(){
        titre = new Text(20,50,"Insérer un nouveau Réalisateur");
        titre.setFont(new Font(30));
    }
    public void initLabel(){

        labelRealisateur = new Label("Nom :");
        labelRealisateur.setTranslateX(50);
        labelRealisateur.setTranslateY(100);
        labelRealisateur.setStyle("-fx-font-size: 20px;");

        labelRealisateurPrenom = new Label("Prénom :");
        labelRealisateurPrenom.setTranslateX(25);
        labelRealisateurPrenom.setTranslateY(150);
        labelRealisateurPrenom.setStyle("-fx-font-size: 20px;");

    }
    public void initInput(){

        inputRealisateur = new TextField();
        inputRealisateur.setTranslateX(150);
        inputRealisateur.setTranslateY(100);
        inputRealisateurPrenom = new TextField();
        inputRealisateurPrenom.setTranslateX(150);
        inputRealisateurPrenom.setTranslateY(150);



    }
    public void initBoutton(){

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(280);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;" );


    }
    public void afficherFormulaireAddRealisateur(){
        root.getChildren().clear();
        root.getChildren().add(labelRealisateur);
        root.getChildren().add(labelRealisateurPrenom);
        root.getChildren().add(inputRealisateurPrenom);
        root.getChildren().add(inputRealisateur);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);

    }
}
