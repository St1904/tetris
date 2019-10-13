package tetris.drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import tetris.config.Context;

public final class CanvasDrawing {

    private static final int LINE_WIDTH = 2;

    private final Context context;
    private final Canvas canvas;
    private final GraphicsContext gc;

    public CanvasDrawing(Context context) {
        this.context = context;
        this.canvas = new Canvas(context.getWindowWidth(), context.getWindowHeight());
        gc = canvas.getGraphicsContext2D();
    }

    public void drawWindow() {
        gc.setFill(context.getBgColor());
        gc.fillRect(0, 0, context.getWindowWidth(), context.getWindowHeight());

        gc.setLineWidth(LINE_WIDTH);
        gc.setStroke(context.getFiguresColor());
        gc.strokeLine(context.getLinePosition(), 0, context.getLinePosition(), context.getWindowHeight());
    }

    private void clearField() {
        gc.setFill(context.getBgColor());
        gc.fillRect(0, 0, context.getFieldWidth(), context.getWindowHeight());
    }

    public void drawField(byte[][] field) {
        clearField();
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[0].length; y++) {
                if (field[x][y] == 1) {
                    drawBlock(x, y);
                }
            }
        }
    }

    private void drawBlock(int x, int y) {
        int blockSize = context.getBlockSize();
        gc.setStroke(context.getFiguresColor());
        gc.strokeRect(x * blockSize, y * blockSize, blockSize, blockSize);
        gc.setFill(context.getFiguresColor());
        gc.fillRect((x + 0.2) * blockSize, (y + 0.2) * blockSize, blockSize * 3 / 5, blockSize * 3 / 5);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
