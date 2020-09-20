package ru.bati4eli.pids.exchange.client.examples

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class FxGroovyExample extends Application {

    @Override
    void start(Stage stage) {
        String javaVersion = System.getProperty("java.version")
        String javafxVersion = System.getProperty("javafx.version")

        Scene scene = new Scene(new StackPane(
                new Label("THIS WINDOW CREATED IN GROOVY!!\n" +
                        "Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        ), 640, 480)
        stage.setScene(scene)
        stage.show()
    }

    static void main(String[] args) {
        launch(FxGroovyExample.class,args)
    }
}
