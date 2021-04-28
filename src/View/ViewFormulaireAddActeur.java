package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewFormulaireAddActeur {

    private Group root;
    private Label labelActeur;
    private Label labelActeurPrenom;
    private TextField inputActeur;
    private TextField inputActeurPrenom;
    private Button btnValide;
    private Text titre;


    public ViewFormulaireAddActeur(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
    }
    public void initTitre(){
        titre = new Text(20,50,"Insérer un nouveau Acteur");
        titre.setFont(new Font(30));
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
    public void initBoutton(){

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(280);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;" );


    }
    public void afficherFormulaireAddActeur(){

        root.getChildren().clear();
        root.getChildren().add(labelActeur);
        root.getChildren().add(labelActeurPrenom);
        root.getChildren().add(inputActeurPrenom);
        root.getChildren().add(inputActeur);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);

    }
}
