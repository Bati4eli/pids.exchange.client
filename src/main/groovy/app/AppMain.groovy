package app

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import log.mylog

class AppMain extends Application {
    @Override
    void start(Stage stage) {
        String javaVersion = System.getProperty("java.version")
        String javafxVersion = System.getProperty("javafx.version")
        String version = System.getProperty("version")


        mylog.debug("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        mylog.debug("System.getProperties():")
        mylog.debug(System.getProperties())
        mylog.debug("Params:")
        mylog.debug(getParameters()?.getUnnamed())

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"))
        Scene scene = new Scene(root)

        stage.with {
            //it.scene = new Scene(root, 640, 480)
            it.scene = scene
            it.width = 640
            it.height = 480
            it.scene.fill = Color.BLACK
            it.minWidth = it.scene.width
            it.minHeight = it.scene.height
            it.title = "PIDs Exchange"
            it.show()
        }
    }

    static void main(String[] args) {
        launch(AppMain.class, args)
    }
}