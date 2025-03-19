package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppPair {
    public static void main(String[] args) {
        Pair<String, Integer> person = new Pair<>("Іван", 25);
        String name = person.getKey();
        Integer age = person.getValue();
        System.out.printf("Pair: name: %s age %d\n", name, age);
        log.info("Pair: name: {} age {}", name, age);
    }
}
