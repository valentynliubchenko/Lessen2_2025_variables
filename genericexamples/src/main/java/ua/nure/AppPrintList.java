package ua.nure;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppPrintList {
    public static void main(String[] args) {
        PrintList printer = new PrintList();
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<String> strings = Arrays.asList("a", "b", "c");
        printer.printList(integers);
        printer.printList(strings);

        log.info("Hello World! {} {}", 232, 2.5);
    }
}
