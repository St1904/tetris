package tetris.drawing;

import tetris.figures.Figure;

import static tetris.config.Config.clockwise;

public class Field {

    public static final byte[][] FIELD = new byte[24][14];
    private static Figure activeFigure = Figure.pickRandomFigure();
    private static int activePhase = activeFigure.pickRandomPhase();
    private static int[][] activeForm = activeFigure.getPhase(activePhase);
    private static byte activeFigureX = 5;
    private static byte activeFigureY = 2;
//    private static byte[][] activeFigureCoordinates = {{0, 5}, {0, 6}, {1, 5}, {1, 6}};

    public static void useCorrection() {
        boolean firstRowIsClear = true;
        for (int i = 0; i < activeForm[0].length; i++) {
            if (activeForm[0][i] > 0) {
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
                FIELD[yy][xx] += activeForm[y][x];
            }
        }
    }

    public static void drawActiveFigureOutOfField() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                int xx = activeFigureX + x;
                int yy = activeFigureY + y;
                FIELD[yy][xx] -= activeForm[y][x];
            }
        }
    }

    public static boolean moveAndCheck(int x, int y) {
        if (canMove(x, y)) {
            drawActiveFigureOutOfField();
            moveActiveFigure(x, y);
            drawActiveFigureOnField();
            printFieldToConsole();
            boolean check = check();
            System.out.println(check);
            if (!check) {
                drawActiveFigureOutOfField();
                moveActiveFigure(-x, -y);
                drawActiveFigureOnField();
                printFieldToConsole();
            }
            return check;
        }
        return false;
    }

    public static void rotateAndCheck() {
        drawActiveFigureOutOfField();
        int change = clockwise ? 1 : -1;
        activeForm = activeFigure.nextForm(activePhase, change);
        activePhase = activeFigure.nextPhase(activePhase, change);
        drawActiveFigureOnField();
        boolean check = check();
        if (!check) {
            drawActiveFigureOutOfField();
            activeForm = activeFigure.nextForm(activePhase, -change);
            activePhase = activeFigure.nextPhase(activePhase, -change);
            drawActiveFigureOnField();
        }
    }

    private static boolean canMove(int x, int y) {
        return activeFigureX + x >= 0 && activeFigureX + x <= 9 && activeFigureY + y >= 0 && activeFigureY + y <= 20;
    }

    private static boolean check() {
        for (int y = 0; y < FIELD.length; y++) {
            for (int x = 0; x < FIELD[0].length; x++) {
                if ((y == 0 || y == 1 || y == 22 || y == 23) && FIELD[y][x] == 1          // figure on upper or lower border
                        || (x == 0 || x == 1 || x == 12 || x == 13) && FIELD[y][x] == 1   // figure on left or right border
                        || FIELD[y][x] == 2) {                                            // figure collapsed on another figure
                    return false;
                }
            }
        }
        return true;
    }

    public static void pickNewFigure() {
        activeFigure = Figure.pickRandomFigure();
        activePhase = activeFigure.pickRandomPhase();
        activeForm = activeFigure.getPhase(activePhase);
        activeFigureX = 5;
        activeFigureY = 2;
    }

    public static void removeRows() {
        for (int y = 2; y < FIELD.length - 2; y++) {
            boolean fullRow = true;
            for (int x = 2; x < FIELD[0].length - 2; x++) {
                if (FIELD[y][x] == 0) {
                    fullRow = false;
                }
            }
            if (fullRow) {
                for (int i = y; i > 3; i--) {
                    for (int x = 2; x < FIELD[0].length - 2; x++) {
                        FIELD[i][x] = FIELD[i - 1][x];
                    }
                }
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
