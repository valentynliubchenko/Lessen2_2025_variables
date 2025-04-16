package ua.nure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomJFrameExample extends JFrame {

    public CustomJFrameExample() {
        // Базове налаштування
        setTitle("Кастомізований JFrame");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Встановлення іконки
        ImageIcon icon = new ImageIcon("app_icon.png");
        setIconImage(icon.getImage());

        // Зміна менеджера розміщення
        setLayout(new BorderLayout(10, 10));

        // Додавання обробника закриття для підтвердження
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        CustomJFrameExample.this,
                        "Закрити програму?",
                        "Підтвердження",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });

        // Додавання компонентів
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(240, 240, 255));
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 1; i <= 9; i++) {
            centerPanel.add(new JButton("Кнопка " + i));
        }
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton("OK"));
        bottomPanel.add(new JButton("Скасувати"));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomJFrameExample frame = new CustomJFrameExample();
            frame.setVisible(true);
        });
    }
}
