package Controller;

import View.ViewFormulaireAddFilm;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFormulaireAddFilm implements EventHandler<MouseEvent> {

    private ViewFormulaireAddFilm viewFormulaireAddFilm;
    private ViewHandler vh;

    public ControllerFormulaireAddFilm(ViewHandler vh, ViewFormulaireAddFilm viewFormulaireAddFilm) {
        this.vh = vh;
        this.viewFormulaireAddFilm = viewFormulaireAddFilm;
    }
    @Override
    public void handle(MouseEvent event) {


    }

}
