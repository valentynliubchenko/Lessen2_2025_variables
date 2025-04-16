package ua.nure;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class JLabelExampleApp {

    public static void main(String[] args) {
        // Створюємо основне вікно програми
        JFrame frame = new JFrame("JLabel Приклади");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        // Проста текстова мітка
        JLabel simpleLabel = new JLabel("Текстова мітка");

        // Мітка з вирівнюванням
        JLabel centeredLabel = new JLabel("Центрований текст", JLabel.CENTER);

        // HTML-форматування в мітці
        JLabel htmlLabel = new JLabel("<html><b>Жирний текст</b> і <i>курсив</i></html>");

        // Зміна параметрів мітки
        JLabel customLabel = new JLabel("Налаштований текст");
        customLabel.setForeground(Color.BLUE);
        customLabel.setFont(new Font("Arial", Font.BOLD, 16));
        customLabel.setToolTipText("Це підказка");
        customLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Додаємо всі мітки до вікна
        frame.add(simpleLabel);
        frame.add(centeredLabel);
        frame.add(htmlLabel);
        frame.add(customLabel);

        // Центруємо вікно на екрані та показуємо його
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}