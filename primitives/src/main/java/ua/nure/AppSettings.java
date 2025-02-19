package ua.nure;

public class AppSettings {
    public static void main(String[] args) {
        // Отримуємо єдиний екземпляр Settings
        Settings settings = Settings.getInstance();
        // Встановлюємо значення
        settings.setSettingValue(42);
        // Отримуємо значення
        System.out.println("Setting value: " + settings.getSettingValue());  // Виведе: Setting value: 42
        Settings newSettings = Settings.getInstance();
        System.out.println("newSettings value: " + newSettings.getSettingValue());  // Виведе: Setting value: 42
        settings.setSettingValue(55);
        System.out.println("newSettings value: " + newSettings.getSettingValue());  // Виведе: Setting value: 55
    }
}
