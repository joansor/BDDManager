package View;

import Controller.ControllerMenu;
import javafx.scene.Group;


public class ViewMenu {
    private Group root;
    private ViewHandler vh;
    private ControllerMenu controllerMenu;
    public ViewMenu(Group root, ViewHandler vh) {
        this.root = root;
        this.controllerMenu = new ControllerMenu(this,vh);

    }


}
