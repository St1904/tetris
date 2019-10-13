package tetris;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import tetris.config.Config;
import tetris.drawing.CanvasDrawing;
import tetris.drawing.Field;

import java.util.TimerTask;

import static javafx.scene.input.KeyCode.*;

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
        primaryStage.show();

        canvasDrawing.drawWindow();

        java.util.Timer timer = new java.util.Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Field.drawActiveFigureOutOfField();
                Field.moveActiveFigure(0, 1);
                Field.drawActiveFigureOnField();
                canvasDrawing.drawField(Field.FIELD);
                Field.printFieldToConsole();
            }
        };

        timer.schedule(timerTask, 0, 1000);
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode code = keyEvent.getCode();
            if (code != UP && code != DOWN && code != LEFT && code != RIGHT) {
                return;
            }
            Field.drawActiveFigureOutOfField();
            switch (code) {
                case UP:
                    Field.moveActiveFigure(0, -1);
                    break;
                case DOWN:
                    Field.moveActiveFigure(0, 1);
                    break;
                case LEFT:
                    Field.moveActiveFigure(-1, 0);
                    break;
                case RIGHT:
                    Field.moveActiveFigure(1, 0);
                    break;
            }
            Field.drawActiveFigureOnField();
            canvasDrawing.drawField(Field.FIELD);
            Field.printFieldToConsole();
        });
    }
}
