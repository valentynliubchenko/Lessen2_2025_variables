package ua.nure;

import java.awt.*;

public enum TrafficLight implements Controllable{
    RED(30) {
        @Override
        public void displayMessage() {
            System.out.println("Стій! Червоне світло горить " + getDuration() + " секунд");
        }
    },
    YELLOW(5) {
        @Override
        public void displayMessage() {
            System.out.println("Приготуйся! Жовте світло горить " + getDuration() + " секунд");
        }
    },
    GREEN(45) {
        @Override
        public void displayMessage() {
            System.out.println("Іди! Зелене світло горить " + getDuration() + " секунд");
        }
    };

    // Приватне поле
    private final int durationInSeconds;

    // Статична константа
    public static final String SYSTEM_NAME = "Світлофор v1.0";

    // Конструктор
    TrafficLight(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    // Геттер
    public int getDuration() {
        return durationInSeconds;
    }

    // Абстрактний метод (повинен бути реалізований кожною константою)
    public abstract void displayMessage();

    // Звичайний метод
    public void countdown() {
        for (int i = durationInSeconds; i > 0; i--) {
            System.out.println(name() + ": залишилось " + i + " секунд");
        }
    }

    // Статичний метод
    public static TrafficLight getNextLight(TrafficLight current) {
        return values()[(current.ordinal() + 1) % values().length];
    }

    // Реалізація методу з інтерфейсу
    @Override
    public void turnOn() {
        System.out.println(name() + " світло увімкнено");
    }

    @Override
    public void turnOff() {
        System.out.println(name() + " світло вимкнено");
    }

    // Вкладений клас
    public static class Controller {
        public void switchLight(TrafficLight light) {
            System.out.println("Перемикання на " + light);
        }
    }
}
