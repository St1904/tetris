package tetris.elements;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import tetris.config.Context;

public class MainCanvas {

    private final Context context;
    private int rectX = 100;
    private int rectY = 100;
    private int rectSize = 20;

    public MainCanvas(Context context) {
        this.context = context;
    }

    public Canvas create() {
        int maxWidth = context.getWindowWidth();
        int maxHeight = context.getWindowHeight();

        Canvas canvas = new Canvas(maxWidth, maxHeight);
//        canvas.setFocusTraversable(true);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(context.getBgColor());
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setLineWidth(2);
        double lineXPosition = maxWidth * 2 / 3 + 1;
        gc.strokeLine(lineXPosition, 0, lineXPosition, maxHeight);

        gc.setFill(context.getLinesColor());
        gc.fillRect(rectX, rectY, rectSize, rectSize);

        return canvas;
    }

    public void move(GraphicsContext gc, KeyCode direction) {
        gc.setFill(context.getBgColor());
        gc.fillRect(rectX, rectY, rectSize, rectSize);
        switch (direction) {
            case UP:
                rectY -= rectSize;
                break;
            case DOWN:
                rectY += rectSize;
                break;
            case LEFT:
                rectX -= rectSize;
                break;
            case RIGHT:
                rectX += rectSize;
                break;
        }
        gc.setFill(context.getLinesColor());
        gc.fillRect(rectX, rectY, rectSize, rectSize);
    }
}
