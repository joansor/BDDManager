package Controller;

import View.ViewFormulaireAddGenre;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFormulaireAddGenre implements EventHandler<MouseEvent> {
    private ViewFormulaireAddGenre viewFormulaireAddGenre;
    private ViewHandler vh;


    public ControllerFormulaireAddGenre(ViewHandler vh,ViewFormulaireAddGenre viewFormulaireAddGenre) {
        this.vh = vh;
        this.viewFormulaireAddGenre = viewFormulaireAddGenre;
    }
    @Override
    public void handle(MouseEvent event) {


    }
}
