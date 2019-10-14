package tetris.figures;

import java.util.Date;
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

    public static Figure pickRandomFigure() {
        int number = new Random(new Date().getTime()).nextInt(ALL_FIGURES.length());
        return Figure.valueOf(ALL_FIGURES.substring(number, number + 1));
    }

    public int pickRandomPhase() {
        return new Random(new Date().getTime()).nextInt(this.points.length);
    }

    public int[][] getPhase(int phase) {
        return points[phase];
    }

    public int nextPhase(int currentPhase, int change) {
        currentPhase += change;
        currentPhase = (currentPhase + points.length) % points.length;
        return currentPhase;
    }

    public int[][] nextForm(int currentPhase, int change) {
        return points[nextPhase(currentPhase, change)];
    }
}
