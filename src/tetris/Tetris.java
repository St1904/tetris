package tetris;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tetris.config.Context;
import tetris.drawing.CanvasHolder;
import tetris.drawing.DrawingUtil;

public class Tetris extends Application {

    private static final Context context = new Context();

    public static void main(String[] args) throws Exception {
        context.init(args[0]);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Old School Tetris");
        CanvasHolder canvasHolder = new CanvasHolder(context);
        Group group = new Group(canvasHolder.getCanvas());
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        DrawingUtil.drawWindow(canvasHolder);

        primaryStage.show();
    }
}
