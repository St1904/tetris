package tetris.figures;

import java.util.Random;

public enum Figure {

    O(new int[][][]{
            {
                    {0, 0, 0, 0},
                    {0, 1, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0}
            }
    }),
    I(new int[][][]{
            {
                    {0, 0, 0, 0},
                    {1, 1, 1, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0}
            }
    }),
    S(new int[][][]{
            {
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 0}
            }
    }),
    Z(new int[][][]{
            {
                    {0, 0, 0, 0},
                    {0, 1, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 0, 1},
                    {0, 0, 1, 1},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            }
    }),
    L(new int[][][]{
            {
                    {0, 0, 0, 1},
                    {0, 1, 1, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 1, 0, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 1, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            }
    }),
    J(new int[][][]{
            {
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 1, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 1},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            }
    }),
    T(new int[][][]{
            {
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            },
            {
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            }
    })
    ;

    private static final String ALL_FIGURES = "OISZLJT";

    int[][][] points;

    Figure(int[][][] points) {
        this.points = points;
    }

    public int[][][] getPoints() {
        return points;
    }

    public static Figure pickRandom() {
        int number = new Random().nextInt(ALL_FIGURES.length());
        return Figure.valueOf(ALL_FIGURES.substring(number, number + 1));
    }
}
