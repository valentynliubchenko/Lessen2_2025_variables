package ua.nure;

import javax.swing.*;
import java.awt.*;

public class SimpleSwingApp
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("SimpleSwingApp");
            frame.setSize(310, 310);
//            frame.setMinimumSize(new Dimension(300, 300));
//            frame.setMaximumSize(new Dimension(350, 350));

            JPanel panel = new JPanel(new GridLayout(0,2,10, 10));
            JLabel label = new JLabel("Hello World");
            panel.add(label);
            panel.add(new JButton("Button"));
            panel.add(new JLabel("Hello World2"));
            panel.add(new JLabel("Hello World3"));
            panel.add(new JRadioButton("Опція 1"));
            panel.add(new JRadioButton("Опція 2"));
            panel.add(new JCheckBox("Вибери"));
            JTextArea textArea = new JTextArea();
            panel.add(textArea);

            frame.add(panel);


            frame.setVisible(true);
        });

    }
}
