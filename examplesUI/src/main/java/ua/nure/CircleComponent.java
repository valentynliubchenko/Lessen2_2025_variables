package ua.nure;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.List;


public class CircleComponent extends JComponent {
    public static final int COORD_MAX = 50;
    private int circleCount = 1;

    private static final List<Color> color = List.of(Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA);

    public void setCircleCount(int circleCount) {
        this.circleCount = circleCount;
        repaint();
    }



    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < circleCount; i++) {
            g.setColor(color.get(new Random().nextInt(color.size())));
            int x = randomX();
            int y = randomY();
            int width = randomWidth();
            int height = randomHeight();
            g.drawOval(x, y, width, height);
        }
    }

    private int randomX() {
        return new Random().nextInt(COORD_MAX);
    }
    private int randomY() {
        return new Random().nextInt(COORD_MAX);
    }

    private int randomWidth() {
        return new Random().nextInt(getWidth()/2);
    }


    private int randomHeight() {
        return new Random().nextInt(getHeight()/2);
    }

}
