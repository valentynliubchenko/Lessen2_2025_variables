package ua.nure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Виконання в потоці EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            // Створення вікна
            JFrame frame = new JFrame("Моя перша Swing програма");

            // Встановлення розміру
            frame.setSize(400, 300);

            // Дії при закритті вікна
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Додавання компонентів
            JLabel label = new JLabel("Привіт, Swing!");

// Проста текстова мітка
            JLabel simpleLabel = new JLabel("Текстова мітка");

// Мітка з вирівнюванням
            JLabel centeredLabel = new JLabel("Центрований текст", JLabel.CENTER);

// Мітка з іконкою
            ImageIcon icon = new ImageIcon("icon.png");
            JLabel iconLabel = new JLabel("Текст з іконкою", icon, JLabel.LEFT);

// HTML-форматування в мітці
            JLabel htmlLabel = new JLabel("<html><b>Жирний текст</b> і <i>курсив</i></html>");

// Зміна параметрів мітки
            JLabel customLabel = new JLabel("Налаштований текст");
            customLabel.setForeground(Color.BLUE);
            customLabel.setFont(new Font("Arial", Font.BOLD, 16));
            customLabel.setToolTipText("Це підказка");
            customLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            label.setHorizontalAlignment(JLabel.CENTER);
            frame.add(label);

            // Відображення вікна
            frame.setVisible(true);
        });
    }
}