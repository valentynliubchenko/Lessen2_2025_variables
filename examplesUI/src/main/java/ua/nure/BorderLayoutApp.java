package ua.nure;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutApp
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.add(new JButton("Верх"), BorderLayout.NORTH);
            frame.add(new JButton("Низ"), BorderLayout.SOUTH);
            frame.add(new JButton("Лівий"), BorderLayout.WEST);
            frame.add(new JButton("Правий"), BorderLayout.EAST);
            frame.add(new JButton("Центр"), BorderLayout.CENTER);


            frame.setVisible(true);
        });

    }
}
