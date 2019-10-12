package tetris;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import tetris.config.Context;
import tetris.elements.MainCanvas;

public class Tetris extends Application {

    private static final Context context = new Context();

    public static void main(String[] args) {
        context.init(args[0]);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Old School Tetris");

        MainCanvas mainCanvas = new MainCanvas(context);
        Canvas canvas = mainCanvas.create();
        Group group = new Group(canvas);
        Scene scene = new Scene(group);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        scene.setOnKeyPressed(keyEvent -> mainCanvas.move(((Canvas) scene.getRoot().getChildrenUnmodifiable().get(0)).getGraphicsContext2D(), keyEvent.getCode()));
    }

}
