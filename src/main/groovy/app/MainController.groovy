package app

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button

class MainController {


    @FXML
    private Button butDrones

    @FXML
    private Button butSettings

    @FXML
    private Button butAbout

    @FXML
    private void clickSettings(ActionEvent event) {
        butSettings.setText("You've clicked!")
    }

    @FXML
    private void clickDrones(ActionEvent event) {
        butDrones.setText("You've clicked!")
    }

    @FXML
    private void clickAbout(ActionEvent event) {
        butAbout.setText("You've clicked!")
    }
}
