package ua.nure;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.net.URL;

public class JEditorPaneExample {

    public static void main(String[] args) {
        // Створюємо головне вікно
        JFrame frame = new JFrame("JEditorPane і JTextPane приклад");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(3, 1, 10, 10));

        // --------- JEditorPane для HTML ---------
        JEditorPane htmlPane = new JEditorPane();
        htmlPane.setContentType("text/html");
        htmlPane.setText("<html><h1>Заголовок</h1><p>Параграф <b>жирним</b> шрифтом</p></html>");
        htmlPane.setEditable(false);

        JScrollPane htmlScrollPane = new JScrollPane(htmlPane);
        htmlScrollPane.setBorder(BorderFactory.createTitledBorder("HTML редактор"));

        // --------- JEditorPane для web-сторінки ---------
        JEditorPane webPane = new JEditorPane();
        JScrollPane webScrollPane = new JScrollPane(webPane);
        webScrollPane.setBorder(BorderFactory.createTitledBorder("Web сторінка"));

        try {
            webPane.setPage(new URL("https://example.com"));
            webPane.setEditable(false);
        } catch (Exception e) {
            webPane.setContentType("text/html");
            webPane.setText("<html><h2>Помилка завантаження веб-сторінки</h2><p>" + e.getMessage() + "</p></html>");
            e.printStackTrace();
        }

        // --------- JTextPane для форматованого тексту ---------
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/rtf");

        // Додавання стилів до JTextPane
        StyledDocument doc = textPane.getStyledDocument();
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

        Style boldStyle = doc.addStyle("bold", defaultStyle);
        StyleConstants.setBold(boldStyle, true);

        Style italicStyle = doc.addStyle("italic", defaultStyle);
        StyleConstants.setItalic(italicStyle, true);

        Style colorStyle = doc.addStyle("color", defaultStyle);
        StyleConstants.setForeground(colorStyle, Color.BLUE);

        Style bigStyle = doc.addStyle("big", defaultStyle);
        StyleConstants.setFontSize(bigStyle, 20);

        try {
            doc.insertString(0, "Звичайний текст", defaultStyle);
            doc.insertString(doc.getLength(), " Жирний текст", boldStyle);
            doc.insertString(doc.getLength(), " Курсив", italicStyle);
            doc.insertString(doc.getLength(), " Синій текст", colorStyle);
            doc.insertString(doc.getLength(), " Великий текст", bigStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        JScrollPane textScrollPane = new JScrollPane(textPane);
        textScrollPane.setBorder(BorderFactory.createTitledBorder("Форматований текстовий редактор"));

        // Додавання панелей до вікна
        frame.add(htmlScrollPane);
        frame.add(webScrollPane);
        frame.add(textScrollPane);

        // Відображення вікна
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
