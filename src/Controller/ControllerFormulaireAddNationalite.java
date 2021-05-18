package Controller;


import View.ViewFormulaireAddNationalite;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFormulaireAddNationalite implements EventHandler<MouseEvent> {
    private ViewFormulaireAddNationalite viewFormulaireAddNationalite;
    private ViewHandler vh;

    public ControllerFormulaireAddNationalite(ViewFormulaireAddNationalite viewFormulaireAddNationalite, ViewHandler vh) {
        this.viewFormulaireAddNationalite = viewFormulaireAddNationalite;
        this.vh = vh;
    }
    @Override
    public void handle(MouseEvent event) {


    }
}
