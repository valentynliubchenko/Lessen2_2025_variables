package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyDog implements Pet, Mammal {
    private String name;

    public MyDog(String name) {
        this.name = name;
    }

    @Override
    public void breathe() {
        log.info("breathe");
    }

    @Override
    public void play() {

        log.info("play");
    }

    @Override
    public void eat() {
        log.info("eat");
    }

    @Override
    public String toString() {
        return "MyDog{" +
                "name='" + name + '\'' +
                '}';
    }
}
