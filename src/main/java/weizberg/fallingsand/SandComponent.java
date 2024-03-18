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
        ArrayList<Integer> xValuesOfOnes = sand.getXs();
        ArrayList<Integer> yValuesOfOnes = sand.getYs();

        int x;
        int y;
        for (int i = 0; i < xValuesOfOnes.size(); i++) {
            x = xValuesOfOnes.get(i);
            y = yValuesOfOnes.get(i);
            g.setColor(Color.CYAN);
            g.fillRect(x, y, 5, 5);
        }

    }
}
