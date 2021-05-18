package Controller;

import View.ViewFormulaireAddActeur;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFormulaireAddActeur implements EventHandler<MouseEvent> {
    private ViewHandler vh;
    private ViewFormulaireAddActeur viewFormulaireAddActeur;

    public ControllerFormulaireAddActeur(ViewHandler vh, ViewFormulaireAddActeur viewFormulaireAddActeur) {
        this.vh = vh;
        this.viewFormulaireAddActeur = viewFormulaireAddActeur;
    }

    @Override
    public void handle(MouseEvent event) {


    }
}
