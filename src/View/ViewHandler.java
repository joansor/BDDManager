package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewHandler extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);


       // ViewFormulaireAddGenre viewFormulaireAddGenre = new ViewFormulaireAddGenre(root);
        ViewFormulaireAddFilm viewFormulaireAddFilm = new ViewFormulaireAddFilm(root);
       //ViewFormulaireAddActeur viewFormulaireAddActeur = new ViewFormulaireAddActeur(root);
        //ViewFormulaireAddRealisateur viewFormulaireAddRealisateur = new ViewFormulaireAddRealisateur(root);
        //ViewFormulaireAddNationalite viewFormulaireAddNationalite = new ViewFormulaireAddNationalite(root);


        primaryStage.setWidth(600);
        primaryStage.setHeight(660);
        primaryStage.setX(500);
        primaryStage.setY(200);
        primaryStage.setTitle("Formulaire");
        primaryStage.setFullScreenExitHint("");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setFullScreen(false);


        viewFormulaireAddFilm.afficherFormulaireAddFilm();
        //viewFormulaireAddActeur.afficherFormulaireAddActeur();
        //viewFormulaireAddRealisateur.afficherFormulaireAddRealisateur();
        //viewFormulaireAddNationalite.afficherFormulaireAddNationalite();
        //viewFormulaireAddGenre.afficherFormulaireAddGenre();

        primaryStage.show();

    }
}
