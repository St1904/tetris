package tetris.drawing;

import tetris.figures.Figure;

public class Field {

    public static final byte[][] FIELD = new byte[20][10];
    private static int[][] activeFigure = Figure.pickRandom().getPoints()[0];
    private static byte activeFigureX = 4;
    private static byte activeFigureY = 0;
//    private static byte[][] activeFigureCoordinates = {{0, 5}, {0, 6}, {1, 5}, {1, 6}};

    public static void moveActiveFigure(int x, int y) {
        activeFigureX += x;
        activeFigureY += y;
    }

    public static void drawActiveFigureOnField() {
        for (int y = activeFigureY; y < activeFigureY + 4; y++) {
            for (int x = activeFigureX; x < activeFigureX + 4; x++) {
                FIELD[y][x] = (byte) activeFigure[y - activeFigureY][x - activeFigureX];
            }
        }
    }

    public static void drawActiveFigureOutOfField() {
        for (int y = activeFigureY; y < activeFigureY + 4; y++) {
            for (int x = activeFigureX; x < activeFigureX + 4; x++) {
                FIELD[y][x] = 0;
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
