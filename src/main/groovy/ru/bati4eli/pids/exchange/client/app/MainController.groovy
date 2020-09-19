package ru.bati4eli.pids.exchange.client.app

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ChoiceBox
import static ru.bati4eli.pids.exchange.client.log.MyLog.log

class MainController {

    @FXML
    private Button butDrones

    @FXML
    private Button butSettings

    @FXML
    private Button butAbout

    @FXML
    private ChoiceBox<String> choiceBox

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

    @FXML
    private void actionChoiceBox(ActionEvent event){
        log.debug(event)
    }
}
