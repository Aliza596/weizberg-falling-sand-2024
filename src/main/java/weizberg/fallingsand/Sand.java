package weizberg.fallingsand;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.min;

public class Sand {

    private int[][] field;
    private final Random random;
    private int height;
    private int width;

    public Sand(int width, int height) {
        this(width, height, new Random());
    }

    public Sand(int width, int height, Random random) {
        field = new int[height][width];
        this.random = random;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return field.length;
    }

    public int getWidth() {
        return field[0].length;
    }

    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            put(
                    random.nextInt(field[0].length),
                    random.nextInt(field.length)
            );
        }
    }

    /**
     * Sets the value in field to be 1
     */
    public void put(int x, int y) {
        field[y][x] = 1;
    }

    /**
     *
     * @param startX             top left of the rectangle
     * @param startY             top left of the rectangle
     * @param width
     * @param height
     * @param probability   that an empty spot in the circle will be sand
     */
    public void put(int startX, int startY, int width, int height, double probability) {
        for (int y = startY; y < startY + height; y++) {
            for (int x = startX; x < startX + width; x++) {
                if(random.nextDouble() <= probability) {
                    field[y][x] = 1;
                }
            }
        }
    }

    /**
     * sets the field to be the values in s.
     * the format of s should be the same as the format of the String in toString
     */
    public void load(String sandString) {
        int counterRows = 0;
        int counterColumns = 0;


        for (int i = 0; i < sandString.length(); i++) {
            char c = sandString.charAt(i);
            switch(c) {
                case '\n' -> {
                    counterRows++;
                    counterColumns = 0;
                }
                case '1' -> {
                    put(counterColumns, counterRows);
                    counterColumns++;
                }
                default -> {
                    field[counterRows][counterColumns] = 0;
                    counterColumns++;
                }
            }
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                builder.append(field[y][x]);
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     *
     * @return the value in field
     */
    public int get(int x, int y) {
        return field[y][x];
    }

    public void fall() {
        //moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (isSand(x, y)) {
                    moveSandDown(x, y);
                }
            }
        }
    }

    public boolean isSand(int x, int y) {
        return field[y][x] == 1;
    }

    /**
     * moves the sand down one square, or diagonally to the right or left
     */
    private void moveSandDown(int x, int y) {
        //move down
        if(move(x, y, x, y + 1)) {
            return;
        }

        //choose either left or right
        int direction = random.nextBoolean() ? +1 : -1;

        //move diagonally in one direction
        if(move(x, y, x + direction, y + 1)) {
            return;
        }

        //move diagonally down in the other direction
        move(x, y, x - direction, y + 1);
    }

    /**
     * moves the sand from x1, y1 to x2, y2
     *
     * @return true if move was successful, otherwise false
     */
    public boolean move(int x1, int y1, int x2, int y2) {
        if(inBounds(x2, y2) && isSand(x1, y1) && !isSand(x2, y2)) {
            field[y1][x1] = 0;
            field[y2][x2] = 1;
            return true;
        }
        return false;
    }

    /**
     * @return true if the coordinates are in the field, otheriwse false
     */
    public boolean inBounds(int x, int y) {
        return 0 <= x && x < field[y].length;
    }

    /**
     * change the width and height of the field
     * keep the contents
     */
    public void resize(int width, int height) {
        if(height == field.length && width == field[0].length) {
            return;
        }
        int[][] newField = new int[height][width];

        for (int y = 0; y < min(newField.length, field.length); y++) {
            System.arraycopy(field[y], 0, newField[y], 0, min(newField[y].length, field[y].length));
        }
        field = newField;
    }

    public int[][] getField() {
        return field;
    }


    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);

        sand.randomSand(50);
        System.out.println(sand);

        System.out.println("Press the enter key to drop the sand. ");
        Scanner input = new Scanner(System.in);

        while (input.nextLine().isEmpty()) {
            sand.fall();
            System.out.println(sand);
        }

    }
}


