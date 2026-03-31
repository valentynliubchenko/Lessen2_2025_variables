package ua.nure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawCircleApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Drow Circle ");
            frame.setSize(310, 310);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            JTextField textField = new JTextField(10);
            JButton jButton = new JButton("Draw Circle");
            CircleComponent circleComponent = new CircleComponent();
            circleComponent.setCircleCount(1);
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();
                    try {
                        int countCircle = Integer.parseInt(text);
                        circleComponent.setCircleCount(countCircle);
                        textField.setText("");
                        System.out.println(countCircle);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Кількість кругів вказана не вірно", "Please enter a number", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            panel.add(textField);
            panel.add(jButton);
            frame.add(panel, BorderLayout.SOUTH);
            frame.add(circleComponent, BorderLayout.CENTER);
            frame.setVisible(true);
        });

    }
}
