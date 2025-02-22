package ua.nure;

import lombok.extern.slf4j.Slf4j;

public class TestWrongThreadString extends Thread {
    static String sbr = "";  // Спільна змінна для всіх потоків

    public void run() {
        for (int i = 0; i < 1000; i++) {
                sbr += "Hello ";  // Потенційна проблема: одночасний доступ з різних потоків
                System.out.println("Thread " + Thread.currentThread().getId() + " is changed sbr " + sbr);
        }

    }
}
