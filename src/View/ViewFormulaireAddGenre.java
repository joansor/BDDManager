package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ViewFormulaireAddGenre {

    private Group root;
    private Label labelGenre;
    private TextField inputGenre;
    private Button btnValide;
    private Text titre;
    public ViewFormulaireAddGenre(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
    }
    public void initTitre(){
        titre = new Text(20,50,"Insérer un nouveau genre");
        titre.setFont(new Font(30));
    }
    public void initLabel(){

        labelGenre = new Label("Genre :");
        labelGenre.setTranslateX(50);
        labelGenre.setTranslateY(100);
        labelGenre.setStyle("-fx-font-size: 20px;");


    }
    public void initInput(){

        inputGenre = new TextField();
        inputGenre.setTranslateX(150);
        inputGenre.setTranslateY(100);



    }
    public void initBoutton(){

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(280);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;" );




    }
    public void afficherFormulaireAddGenre(){
        root.getChildren().clear();
        root.getChildren().add(labelGenre);
        root.getChildren().add(inputGenre);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);

    }
}
