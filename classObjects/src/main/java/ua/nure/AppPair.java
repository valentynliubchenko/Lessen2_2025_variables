package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppPair {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String, Integer>("Age", 34);
        log.info(pair.toString());
        Pair<Double, Integer> pair2 = new Pair<>(4.6, 334);
        log.info(pair2.toString());

    }
}
