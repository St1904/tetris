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

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws Exception {
        Config.init(args[0]);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("OldSchool Tetris");
        CanvasDrawing canvasDrawing = new CanvasDrawing();
        Group group = new Group(canvasDrawing.getCanvas());
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        canvasDrawing.drawWindow();

        pickAndDrawNewFigure(canvasDrawing);

        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    boolean moved = Field.moveAndCheck(0, 1);
                    if (moved) {
                        canvasDrawing.drawField(Field.FIELD);
                        Field.printFieldToConsole();
                    } else {
                        Field.removeRows();
                        pickAndDrawNewFigure(canvasDrawing);
                    }
                }
            }
        };
        timer.schedule(timerTask, 300, 300);

        scene.setOnKeyPressed(keyEvent -> {
            synchronized (LOCK) {
                KeyCode code = keyEvent.getCode();
                if (code != UP && code != DOWN && code != LEFT && code != RIGHT) {
                    return;
                }
                switch (code) {
                    case UP:
                        Field.rotateAndCheck();
                        break;
                    case DOWN:
                        Field.moveAndCheck(0, 1);
                        break;
                    case LEFT:
                        Field.moveAndCheck(-1, 0);
                        break;
                    case RIGHT:
                        Field.moveAndCheck(1, 0);
                        break;
                }
                canvasDrawing.drawField(Field.FIELD);
                Field.printFieldToConsole();
            }
        });
    }

    private void pickAndDrawNewFigure(CanvasDrawing canvasDrawing) {
        Field.pickNewFigure();
        Field.useCorrection();
        Field.drawActiveFigureOnField();
        canvasDrawing.drawField(Field.FIELD);
        Field.printFieldToConsole();
        canvasDrawing.drawNextFigure(Field.nextFigure, Field.nextFigurePhase);
    }
}
