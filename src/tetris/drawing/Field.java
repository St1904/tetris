package tetris.drawing;

public class Field {

    public static final byte[][] FIELD = new byte[20][10];
    private static byte[][] activeFigureCoordinates = {{0, 5}, {0, 6}, {1, 5}, {1, 6}};

    public static void moveActiveFigure(int x, int y) {
        for (int i = 0; i < activeFigureCoordinates.length; i++) {
            activeFigureCoordinates[i][0] += y;
            activeFigureCoordinates[i][1] += x;
        }
    }

    public static void drawActiveFigureOnField() {
        for (int i = 0; i < activeFigureCoordinates.length; i++) {
            FIELD[activeFigureCoordinates[i][0]][activeFigureCoordinates[i][1]] = 1;
        }
    }

    public static void drawActiveFigureOutOfField() {
        for (int i = 0; i < activeFigureCoordinates.length; i++) {
            FIELD[activeFigureCoordinates[i][0]][activeFigureCoordinates[i][1]] = 0;
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
