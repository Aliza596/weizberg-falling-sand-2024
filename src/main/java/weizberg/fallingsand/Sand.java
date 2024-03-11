package weizberg.fallingsand;

import java.util.Random;
import java.util.Scanner;

public class Sand {

    private final int[][] field;
    private final Random random;

    public Sand(int width, int height) {
        field = new int[height][width];
        this.random = new Random();
    }

    public Sand(int width, int height, Random random) {
        field = new int[height][width];
        this.random = random;
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
     * @return the value in field
     */
    public int get(int x, int y) {
        return field[y][x];
    }

    /**
     * Sets the value in field to be 1
     */
    public void put(int x, int y) {
            field[y][x] = 1;
    }

    public void fall() {
        //moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    //does the sand fall straight down?
                    if (field[y + 1][x] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x] = 1;
                        continue;
                    }

                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;

                    if (field[y + 1][x + direction1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction1] = 1;
                    } else if (field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction2] = 1;
                    }

                }
            }
        }

    }

    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            int valueX = random.nextInt(50);
            int valueY = random.nextInt(10);
            put(valueX, valueY);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int height;
        System.out.println("Please enter the width dimension of the field: ");
        height = input.nextInt();

        int width;
        System.out.println("Please enter the height dimension of the field: ");
        width = input.nextInt();

        Sand sand = new Sand(height, width);
        System.out.println(sand);

        sand.randomSand(50);

        System.out.println("Press the enter key to drop the sand. ");
        String enter = input.nextLine();

        while (enter.equals(" ")) {
            sand.fall();
            System.out.println(sand);
            enter = input.nextLine();
        }

    }
}


