package ru.bati4eli.pids.exchange.client.app


import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.stage.Stage
import static ru.bati4eli.pids.exchange.client.log.MyLog.log

class AppMain extends Application {
    private final int MIN_SIZE_WIDTH = 1010
    private final int MIN_SIZE_HEIGHT = 610

    private final Color COLOR_MAIN = Color.valueOf('#143656')
    private final Color COLOR_YELOW = Color.valueOf('#ecf026')
    private final Color COLOR_MAIN2 = Color.valueOf('#1c3d5c')

    private String version = ""

    @Override
    void start(Stage stage) {
        String javaVersion = System.getProperty("java.version")
        String javafxVersion = System.getProperty("javafx.version")
        version = getClass().getPackage().getImplementationVersion()

        log.debug("VERSION: $version")
        log.debug("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        log.debug("System.getProperties():")
        log.debug(System.getProperties())
        log.debug("Params:")
        log.debug(getParameters()?.getUnnamed())

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"))
        Scene scene = new Scene(root)

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

    static void main(String[] args) {
        launch(AppMain.class, args)
    }
}