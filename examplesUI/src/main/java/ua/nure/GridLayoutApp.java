package ua.nure;

import javax.swing.*;
import java.awt.*;

public class GridLayoutApp
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setSize(300, 300);

            JPanel panel = new JPanel(new GridLayout(2, 3)); // 2 рядки, 3 стовпці
            for (int i = 1; i <= 7; i++) {
                panel.add(new JButton("Кнопка " + i));
            }
            frame.add(panel);

            frame.setVisible(true);
        });

    }
}
