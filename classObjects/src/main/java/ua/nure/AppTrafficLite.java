package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTrafficLite
{
    public static void main( String[] args )
    {
        TrafficLight light = TrafficLight.RED;
        light.displayMessage();         // Виклик перевизначеного методу
        light.turnOn();                 // Виклик методу з інтерфейсу
        System.out.println("Тривалість: " + light.getDuration() + " секунд");

        TrafficLight nextLight = TrafficLight.getNextLight(light);  // Статичний метод
        System.out.println("Наступне світло: " + nextLight);

// Використання вкладеного класу
        TrafficLight.Controller controller = new TrafficLight.Controller();
        controller.switchLight(TrafficLight.GREEN);    }
}
