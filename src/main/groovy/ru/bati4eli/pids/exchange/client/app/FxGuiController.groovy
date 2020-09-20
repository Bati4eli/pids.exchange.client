package ru.bati4eli.pids.exchange.client.app

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ChoiceBox
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import ru.bati4eli.pids.exchange.client.services.SerialPortService

import static ru.bati4eli.pids.exchange.client.log.MyLog.log

class FxGuiController {

    SerialPortService serialPortService

    @FXML
    Button butDrones
    @FXML
    Button butSettings
    @FXML
    Button butAbout
    @FXML
    Button butSend
    @FXML
    ChoiceBox<String> choiceBox
    @FXML
    TextArea textAreaHistory
    @FXML
    TextField textFieldTx

    @FXML
    void clickSettings(ActionEvent event) {
        butSettings.setText("You've clicked!")
    }

    @FXML
    void clickDrones(ActionEvent event) {
        butDrones.setText("You've clicked!")
    }

    @FXML
    void clickAbout(ActionEvent event) {
        butAbout.setText("You've clicked!")
    }

    @FXML
    void clickSend(ActionEvent event) {
        def text = getTextTxAndClearField()
        if (!text.trim().isEmpty()) {
            serialPortService.sendData(text)
        }
    }

    @FXML
    void actionChoiceBox(ActionEvent event) {
        log.debug("[actionChoiceBox]: $choiceBox.value")
    }

    String getPort() {
        choiceBox.value
    }

    void clearHistory() {
        textAreaHistory.clear()
    }

    String getTextTxAndClearField() {
        def text = textFieldTx.text
        textFieldTx.clear()
        return text
    }

    void appendToHistory( String msg) {
        textAreaHistory.appendText(msg)
    }

    void appendToHistory(String from, String msg) {
        textAreaHistory.appendText("$from:\t$msg\n".toString())
    }

}
