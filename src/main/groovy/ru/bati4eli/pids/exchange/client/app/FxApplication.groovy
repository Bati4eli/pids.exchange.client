package ru.bati4eli.pids.exchange.client.app

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.stage.Stage
import ru.bati4eli.pids.exchange.client.services.SerialPortService
import static ru.bati4eli.pids.exchange.client.log.MyLog.log

class FxApplication extends Application {

    FxGuiController controller
    private SerialPortService serialPortService

    private final int MIN_SIZE_WIDTH = 1010
    private final int MIN_SIZE_HEIGHT = 660

    private final Color COLOR_MAIN = Color.valueOf('#143656')
    private final Color COLOR_YELOW = Color.valueOf('#ecf026')
    private final Color COLOR_MAIN2 = Color.valueOf('#1c3d5c')
    private String version = ""
    // find element: scene.lookup("#panelDebugPort")
    @Override
    void start(Stage stage) {
        showInitialiseLogs()
        Scene scene = loadSceneAndInitController()
        configureElementsOfController()

        serialPortService = new SerialPortService(this)

        stage.with {
            //it.scene = new Scene(root, 640, 480)
            it.scene = scene
            it.width = MIN_SIZE_WIDTH
            it.height = MIN_SIZE_HEIGHT
            it.scene.fill = COLOR_MAIN
            it.minWidth = it.scene.width
            it.minHeight = it.scene.height
            it.title = "PIDs Exchange"
            it.show()
        }
    }

    Scene loadSceneAndInitController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"))
        Parent root = loader.load()
        Scene scene = new Scene(root)
        controller = loader.<FxGuiController> getController()
        return scene
    }

    void configureElementsOfController() {
        controller.with {
            it.textAreaHistory.editable = false
            it.choiceBox.onAction = { ActionEvent event -> controller.actionChoiceBox(event) }
        }
    }

    void showInitialiseLogs() {
        String javaVersion = System.getProperty("java.version")
        String javafxVersion = System.getProperty("javafx.version")
        version = getClass().getPackage().getImplementationVersion()

        log.debug("VERSION: $version")
        log.debug("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        log.debug("System.getProperties():")
        log.debug(System.getProperties())
        log.debug("Params:")
        log.debug(getParameters()?.getUnnamed())
    }

    static void main(String[] args) {
        launch(FxApplication.class, args)
    }
}