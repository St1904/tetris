package tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import tetris.config.Context;

import java.util.logging.Logger;

public class Tetris extends Application {

    private static final Logger LOG = Logger.getLogger(Tetris.class.getName());
    private static final Context context = new Context();

    public static void main(String[] args) {
        context.init(args[0]);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Old School Tetris");
        primaryStage.setWidth(context.getWindowWidth());
        primaryStage.setHeight(context.getWindowHeight());
        primaryStage.show();
    }

}
