package tetris.drawing;

import javafx.scene.canvas.GraphicsContext;
import tetris.config.Context;

public final class DrawingUtil {

    private static final int LINE_WIDTH = 2;

    private DrawingUtil() {
    }

    public static void drawWindow(CanvasHolder canvasHolder) {
        Context context = canvasHolder.getContext();
        GraphicsContext gc = canvasHolder.getGraphicsContext();

        gc.setFill(context.getBgColor());
        gc.fillRect(0, 0, context.getWindowWidth(), context.getWindowHeight());

        gc.setLineWidth(LINE_WIDTH);
        gc.setStroke(context.getLinesColor());
        gc.strokeLine(context.getLinePosition(), 0, context.getLinePosition(), context.getWindowHeight());
    }
}
