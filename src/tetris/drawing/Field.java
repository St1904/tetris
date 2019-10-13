package tetris.drawing;

import tetris.figures.Figure;

public class Field {

    public static final byte[][] FIELD = new byte[22][12];
    private static Figure activeFigure = Figure.pickRandomFigure();
    private static int[][] activePhase = activeFigure.pickRandomPhase();
    private static byte activeFigureX = 4;
    private static byte activeFigureY = 1;
//    private static byte[][] activeFigureCoordinates = {{0, 5}, {0, 6}, {1, 5}, {1, 6}};

    public static void useCorrection() {
        boolean firstRowIsClear = true;
        for (int i = 0; i < activePhase[0].length; i++) {
            if (activePhase[0][i] > 0) {
                firstRowIsClear = false;
                break;
            }
        }
        if (firstRowIsClear) {
            activeFigureY--;
        }
    }

    public static void moveActiveFigure(int x, int y) {
        activeFigureX += x;
        activeFigureY += y;
    }

    public static void drawActiveFigureOnField() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                int xx = activeFigureX + x;
                int yy = activeFigureY + y;
                FIELD[yy][xx] += activePhase[y][x];
            }
        }
    }

    public static void drawActiveFigureOutOfField() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                int xx = activeFigureX + x;
                int yy = activeFigureY + y;
                FIELD[yy][xx] -= activePhase[y][x];
            }
        }
    }

    /** @noinspection ForLoopReplaceableByForEach*/
    public static void printFieldToConsole() {
        System.out.println();
        for (int y = 0; y < FIELD.length; y++) {
            for (int x = 0; x < FIELD[0].length; x++) {
                System.out.print(FIELD[y][x]);
            }
            System.out.println();
        }
    }

    private static byte[][] testField() {
        return new byte[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }
}
