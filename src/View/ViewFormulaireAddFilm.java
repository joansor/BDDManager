package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;


import java.io.File;

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
    private TextField inputResumerFilm;
    private Button btnValide;
    private Text titre;
    private FileChooser fileChooser;
    private Button btnselectFile;
    private Window mainStage;


    public ViewFormulaireAddFilm(Group root) {
        this.root = root;

        initLabel();
        initInput();
        initBoutton();
        initTitre();
        initFileChooser();
    }

    public void initTitre() {
        titre = new Text(20, 50, "Insérer un nouveau Film");
        titre.setFont(new Font(30));
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
        labelResumerFilm = new Label("Résumer :");
        labelResumerFilm.setTranslateX(53);
        labelResumerFilm.setTranslateY(250);
        labelResumerFilm.setStyle("-fx-font-size: 20px;");
        labelImageFilm = new Label("Image :");
        labelImageFilm.setTranslateX(75);
        labelImageFilm.setTranslateY(300);
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
        inputResumerFilm = new TextField();
        inputResumerFilm.setTranslateX(150);
        inputResumerFilm.setTranslateY(250);


    }

    public void initFileChooser() {

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        btnselectFile = new Button("Select File");
        btnselectFile.setTranslateX(150);
        btnselectFile.setTranslateY(300);

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));

        btnselectFile.setOnMouseClicked(e -> {
            File selectedFile = fileChooser.showOpenDialog(mainStage);
            if (selectedFile != null) {
              //  mainStage.display(selectedFile);


            }
        });
    }
    public void initBoutton() {

        btnValide = new Button("Valider");
        btnValide.setTranslateX(150);
        btnValide.setTranslateY(370);
        btnValide.setStyle("-fx-background-color : BLUE;" + "-fx-text-fill : WHITE;" + "-fx-font-size: 20px;");

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
    }
}
