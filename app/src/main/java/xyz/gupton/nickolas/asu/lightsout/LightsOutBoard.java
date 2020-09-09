package xyz.gupton.nickolas.asu.lightsout;

import java.util.Random;

/**
 * @author Nickolas Gupton
 */
public class LightsOutBoard {
    /**
     * numRows int: Number of rows in the board.
     * numColumns int: Number of columns in the board.
     * numColors int: Number of possible colors the lights can be.
     * lights int[][]: The current state of the board in terms of the lights.
     * random Random: A random generator.
     */
    final private int numRows;
    final private int numColumns;
    final private int numColors;
    private int[][] lights;
    final private static Random random = new Random();

    /**
     * Creates a new LightsOutBoard object.
     * @param numRows int: Number of rows to create.
     * @param numColumns int: Number of columns to create.
     * @param numColors int: Number of light states to create.
     */
    public LightsOutBoard(int numRows, int numColumns, int numColors) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numColors = numColors;

        lights = new int[this.numRows][this.numColumns];
        this.randomize();
    }

    /**
     * Creates a new LightsOutBoard object.
     * @param numRows int: Number of rows to create.
     * @param numColumns int: Number of columns to create.
     */
    public LightsOutBoard(int numRows, int numColumns) {
        this(numRows, numColumns, 2);
    }

    /**
     * Gets the current color of a light.
     * @param row int: Row of the light.
     * @param column int: Column of the light.
     * @return int: The color of the light.
     */
    public int getLightColor(int row, int column) {
        try {
            return this.lights[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("getLightColor(" + row + ", " + column + "): ArrayIndexOutOfBoundsException");
            return 0;
        }
    }

    /**
     * Flips the color of the light down one.
     * @param row int: Row of the light.
     * @param column int: Column of the light.
     */
    private void flip(int row, int column) {
        try {
            this.lights[row][column]--;
            if (getLightColor(row, column) < 0) {
                this.lights[row][column] = this.numColors - 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // We can safely skip this.
            //System.out.println("flip(" + row + ", " + column + "): ArrayIndexOutOfBoundsException");
        }
    }

    /**
     * Flips the color of the light and those around it down one.
     * @param row int: Row of the light.
     * @param column int: Column of the light.
     */
    public void click(int row, int column) {
        this.flip(row, column);
        this.flip(row+1, column);
        this.flip(row-1, column);
        this.flip(row, column+1);
        this.flip(row, column-1);
    }

    /**
     * Flips the color of the light and those around it down a number of times.
     * @param row int: THe row of the light.
     * @param column int: The column of the light.
     * @param timesToClick int: Times to flip the lights down.
     */
    public void click(int row, int column, int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            click(row, column);
        }
    }

    /**
     * Checks if the board is cleared in its current state.
     * @return boolean: True if all of the lights are at 0.
     */
    public boolean isCleared() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                if (getLightColor(i, j) > 0) return false;
            }
        }

        return true;
    }

    /**
     * Randomizes the current boards lights, making sure its not cleared.
     */
    public void randomize() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                this.lights[i][j] = 0;
            }
        }

        while(this.isCleared()){
            for (int i = 0; i < this.numRows; i++) {
                for (int j = 0; j < this.numColumns; j++) {
                    this.click(i, j, random.nextInt(numColors));
                }
            }
        }
    }

    /**
     * Makes the current board into a string.
     * @return String: The current board.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.numRows; i++) {
            stringBuilder.append("[");
            for (int j = 0; j < this.numColumns; j++) {
                stringBuilder.append(this.getLightColor(i, j));
            }
            stringBuilder.append("]\n");
        }

        return stringBuilder.toString();
    }
}
