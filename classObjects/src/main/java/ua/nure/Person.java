package ua.nure;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
        log.info("Person constructor called wit parameter");
    }

    public Person() {
        this("Unknown");
        log.info("Person constructor called");
    }
}
