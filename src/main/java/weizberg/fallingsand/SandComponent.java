package weizberg.fallingsand;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class SandComponent extends JComponent {

    private final Sand sand;


    public SandComponent(Sand sand) {
        this.sand = sand;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sand.put(e.getX(), e.getY(), 10, 10, .3);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                sand.put(e.getX(), e.getY(), 10, 10, .3);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        sand.resize(getWidth(), getHeight());

        // draw the sand

        sand.fall();

        g.setColor(Color.darkGray);
        for (int y = 0; y < sand.getHeight(); y++) {
            for (int x = 0; x < sand.getWidth(); x++) {
                if (sand.isSand(x, y)) {
                    g.fillRect(x, y, 3, 3);
                }
            }
        }

        repaint();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}
