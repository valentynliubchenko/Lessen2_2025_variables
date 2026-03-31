package ua.nure;

import javax.swing.*;
import java.awt.*;

public class JTextAreaExampleApp {
    public static void main(String[] args) {
        // Створюємо основне вікно програми
        JFrame frame = new JFrame("JTextArea Приклад");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Створення текстової області
        JTextArea textArea = new JTextArea(5, 20); // 5 рядків, 20 стовпців

        // Встановлення тексту
        textArea.setText("Багаторядковий\nтекст\nдля прикладу");

        // Налаштування переносу рядків
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Додавання до скрол-панелі (для забезпечення прокрутки)
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Додавання тексту
        textArea.append("\nДодатковий текст");

        // Заборона редагування (тільки для читання)
        textArea.setEditable(false);

        // Додаємо кнопку для демонстрації відновлення можливості редагування
        JButton editButton = new JButton("Дозволити редагування");
        editButton.addActionListener(e -> {
            textArea.setEditable(true);
            textArea.setBackground(Color.WHITE);
            editButton.setEnabled(false);
        });

        // Змінюємо колір фону для візуального позначення режиму "тільки для читання"
        textArea.setBackground(new Color(240, 240, 240));

        // Додаємо компоненти до вікна
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(editButton, BorderLayout.SOUTH);

        // Центруємо вікно на екрані та показуємо його
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
