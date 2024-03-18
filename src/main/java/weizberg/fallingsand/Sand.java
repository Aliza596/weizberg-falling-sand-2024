package weizberg.fallingsand;

import java.util.ArrayList;
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

    public ArrayList<Integer> getXs() {
        ArrayList<Integer> xs = new ArrayList<Integer>();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    xs.add(x);
                }
            }

        }
        return xs;
    }

    public ArrayList<Integer> getYs() {
        ArrayList<Integer> ys = new ArrayList<Integer>();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    ys.add(y);
                }
            }

        }
        return ys;
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
                if (field[y][x] == 1 && y + 1 < field.length) {
                    //does the sand fall straight down?
                    if (field[y + 1][x] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x] = 1;
                        continue;
                    }

                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;


                    if (x + direction1 < field[y + 1].length &&  x + direction1 > 0
                            && field[y + 1][x + direction1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction1] = 1;
                    } else if (x + direction2 < field[y + 1].length && x + direction2 > 0
                            && field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction2] = 1;
                    }  else {
                        field[y][x] = 1;
                    }
                }
            }
        }

    }

    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            int valueX = random.nextInt(field[0].length);
            int valueY = random.nextInt(field.length);
            put(valueX, valueY);
        }
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


