package weizberg.fallingsand;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class SandFrame extends JFrame {

    private final Sand sand = new Sand(300, 400);

    public SandFrame() {
        setSize(800, 600);
        setTitle("Falling Sand");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        sand.randomSand(4000);

        SandComponent sandComponent = new SandComponent(sand);
        add(sandComponent, BorderLayout.CENTER);
    }

}