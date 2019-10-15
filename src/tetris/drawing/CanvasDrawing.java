package tetris.drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import tetris.figures.Figure;

import static tetris.config.Config.*;

public final class CanvasDrawing {

    private final Canvas canvas;
    private final GraphicsContext gc;

    public CanvasDrawing() {
        this.canvas = new Canvas(windowWidth, windowHeight);
        gc = canvas.getGraphicsContext2D();
    }

    public void drawWindow() {
        gc.setFill(bgColor);
        gc.fillRect(0, 0, windowWidth, windowHeight);

        gc.setLineWidth(LINE_WIDTH);
        gc.setStroke(figuresColor);
        gc.strokeLine(linePosition, 0, linePosition, windowHeight);
    }

    private void clearField() {
        gc.setFill(bgColor);
        gc.fillRect(0, 0, fieldWidth, windowHeight);
    }

    public void drawField(byte[][] field) {
        clearField();
        for (int y = 2; y < field.length - 2; y++) {
            for (int x = 2; x < field[0].length - 2; x++) {
                if (field[y][x] == 1) {
                    drawBlock(x - 2, y - 2);
                }
            }
        }
    }

    private void drawBlock(int x, int y) {
        gc.setStroke(figuresColor);
        gc.strokeRect(x * blockSize, y * blockSize, blockSize, blockSize);
        gc.setFill(figuresColor);
        gc.fillRect((x + 0.2) * blockSize, (y + 0.2) * blockSize, blockSize * 0.6, blockSize * 0.6);
    }

    public void drawNextFigure(Figure figure, int phase) {
        int[][] fig = figure.getPhase(phase);
        gc.setFill(bgColor);
        gc.fillRect(nextFigureX * blockSize - 1, nextFigureY * blockSize - 1, 4 * blockSize + 2, 4 * blockSize + 2);
        for (int y = 0; y < fig.length; y++) {
            for (int x = 0; x < fig[0].length; x++) {
                if (fig[y][x] == 1) {
                    drawBlock(nextFigureX + x, nextFigureY + y);
                }
            }
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
