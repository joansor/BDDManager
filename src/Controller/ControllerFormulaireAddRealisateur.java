package Controller;

import View.ViewFormulaireAddRealisateur;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFormulaireAddRealisateur implements EventHandler<MouseEvent> {
    private ViewHandler vh;
    private ViewFormulaireAddRealisateur viewFormulaireAddRealisateur;

    public ControllerFormulaireAddRealisateur(ViewHandler vh, ViewFormulaireAddRealisateur viewFormulaireAddRealisateur) {
        this.vh = vh;
        this.viewFormulaireAddRealisateur = viewFormulaireAddRealisateur;
    }
    @Override
    public void handle(MouseEvent event) {


    }
}
