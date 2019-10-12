package tetris.drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import tetris.config.Context;

public class CanvasHolder {

    private final Context context;
    private final Canvas canvas;
    private final GraphicsContext graphicsContext;

    public CanvasHolder(Context context) {
        this.context = context;
        canvas = new Canvas(context.getWindowWidth(), context.getWindowHeight());
        graphicsContext = canvas.getGraphicsContext2D();
    }

    public Context getContext() {
        return context;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}
