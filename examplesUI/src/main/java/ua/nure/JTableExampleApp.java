package ua.nure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class JTableExampleApp {

    public static void main(String[] args) {
        // Створюємо головне вікно
        JFrame frame = new JFrame("JTable Приклад");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new GridLayout(2, 1, 0, 20));

        // Створення панелей для розміщення таблиць
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());

        // Створення моделі даних для таблиці
        Object[][] data = {
                {"Іван", "Петров", 25, true},
                {"Марія", "Іванова", 30, false},
                {"Олег", "Сидоров", 28, true},
                {"Анна", "Коваль", 22, false}
        };
        String[] columnNames = {"Ім'я", "Прізвище", "Вік", "Одружений"};

        // Створення простої таблиці
        JTable table = new JTable(data, columnNames);

        // Додавання таблиці до панелі прокрутки
        JScrollPane scrollPane = new JScrollPane(table);

        // Налаштування таблиці
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true); // дозволяє сортувати клацанням на заголовки

        // Використання власної моделі таблиці
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) return Integer.class; // для сортування чисел
                if (columnIndex == 3) return Boolean.class; // для відображення чекбоксів
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // перший стовпець не редагується
            }
        };

        JTable customTable = new JTable(model);

        // Налаштування вдосконаленої таблиці
        customTable.setRowHeight(25);
        customTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customTable.setAutoCreateRowSorter(true);

        // Налаштування заголовків стовпців
        TableColumnModel columnModel = customTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(100);

        // Додавання вдосконаленої таблиці до панелі прокрутки
        JScrollPane customScrollPane = new JScrollPane(customTable);

        // Додавання підписів до панелей
        panel1.setBorder(BorderFactory.createTitledBorder("Проста таблиця"));
        panel2.setBorder(BorderFactory.createTitledBorder("Таблиця з власною моделлю"));

        // Додавання компонентів до панелей
        panel1.add(scrollPane, BorderLayout.CENTER);
        panel2.add(customScrollPane, BorderLayout.CENTER);

        // Додавання панелей до вікна
        frame.add(panel1);
        frame.add(panel2);

        // Відображення вікна
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}