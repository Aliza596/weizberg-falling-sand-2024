package weizberg.fallingsand;

public class Sand {

    private int[][] field = new int[3][3];

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
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
     *Sets the value in field to be 1
     */
    public void put(int x, int y) {
        field[y][x] = 1;
    }

    public void fall() {
        //moves all sand down one square
        int[][] newField = new int[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (field[y][x] == 1 && y + 1 < 3 && field [y+1][x] == 0) {
                    newField[y][x] = 0;
                    newField [y + 1][x] = 1;
                } else if (field[y][x] == 1) {
                    newField[y][x] = 1;
                }
            }
        }
        field = newField;
    }

}
