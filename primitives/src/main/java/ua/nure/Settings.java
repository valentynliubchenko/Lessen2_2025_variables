package ua.nure;

public class Settings {
    private static final Settings instance = new Settings();  // єдиний екземпляр класу
    private int settingValue;  // змінна для зберігання значення типу int

    private Settings() {}  // закритий конструктор, щоб не можна було створити новий екземпляр

    public static Settings getInstance() {
        return instance;  // повернення єдиного екземпляра
    }

    public int getSettingValue() {
        return settingValue;  // отримання значення
    }

    public void setSettingValue(int value) {
        settingValue = value;  // зміна значення
    }
}
