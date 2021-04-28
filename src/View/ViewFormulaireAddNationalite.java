package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewFormulaireAddNationalite {

    private Group root;
    private Label labelNationalite;
    private TextField inputNationalite;
    private Button btnValide;
    private Text titre;
    public ViewFormulaireAddNationalite(Group root) {
        this.root = root;
        initLabel();
        initInput();
        initBoutton();
        initTitre();
    }
    public void initTitre(){
        titre = new Text(20,50,"Insérer une nouvelle Nationalité");
        titre.setFont(new Font(30));
    }
    public void initLabel(){

        labelNationalite = new Label("Nationalité :");
        labelNationalite.setTranslateX(50);
        labelNationalite.setTranslateY(100);
        labelNationalite.setStyle("-fx-font-size: 20px;");


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




    }
    public void afficherFormulaireAddNationalite(){
        root.getChildren().clear();
        root.getChildren().add(labelNationalite);
        root.getChildren().add(inputNationalite);
        root.getChildren().add(btnValide);
        root.getChildren().add(titre);

    }

}
