package Controller;

import View.ViewFormulaireAddFilm;
import View.ViewHandler;
import View.ViewMenu;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

    private ViewMenu viewMenu;
    private ViewHandler vh;

    public ControllerMenu(ViewMenu viewMenu, ViewHandler vh) {
        this.viewMenu = viewMenu;
        this.vh = vh;
    }
    @Override
    public void handle(MouseEvent event) {


    }
}
