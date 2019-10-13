package tetris;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tetris.config.Config;
import tetris.drawing.CanvasDrawing;

public class Tetris extends Application {

    public static void main(String[] args) throws Exception {
        Config.init(args[0]);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Old School Tetris");
        CanvasDrawing canvasDrawing = new CanvasDrawing();
        Group group = new Group(canvasDrawing.getCanvas());
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        canvasDrawing.drawWindow();

        canvasDrawing.drawField(testField());

        primaryStage.show();
    }

    private byte[][] testField() {
        return new byte[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        // it looks like:
        // ----------
        // ----------
        // --------**
        // --------**
        // --*-------
        // --**------
        // ---*--***-
        // -------*--
        // ----------
        // ----------
        // ----------
        // ----------
        // ----------
        // -****-----
        // ----------
        // ----------
        // ----------
        // ----------
        // ----------
        // ----------

    }
}
