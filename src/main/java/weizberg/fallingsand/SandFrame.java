package weizberg.fallingsand;

import javax.inject.Inject;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class SandFrame extends JFrame {


    @Inject
    public SandFrame(Sand sand,
                     SandComponent sandComponent,
                     int width,
                     int height
    ) {
        setSize(width, height);
        setTitle("Falling Sand");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        sand.randomSand(4000);

        add(sandComponent, BorderLayout.CENTER);
    }

}