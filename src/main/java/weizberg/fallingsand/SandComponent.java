package weizberg.fallingsand;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the sand

        sand.fall();
        ArrayList<Integer> valuesOfOnesX = sand.getXs();
        ArrayList<Integer> valuesOfOnesY = sand.getYs();

        int x;
        int y;
        for (int i = 0; i < valuesOfOnesX.size(); i++) {
            x = valuesOfOnesX.get(i);
            y = valuesOfOnesY.get(i);
            g.setColor(Color.CYAN);
            g.fillRect(x, y, 5, 5);
        }

    }
}
