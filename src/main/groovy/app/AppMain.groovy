package app

import javafx.application.Application
import javafx.stage.Stage

class AppMain extends Application {
    @Override
    void start(Stage stage) {
        stage.show()
    }

    static void main(String[] args) {
        launch(AppMain.class, args)
    }
}
