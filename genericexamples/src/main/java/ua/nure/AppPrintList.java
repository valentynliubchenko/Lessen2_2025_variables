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

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        double sum1 = printer.sumOfElements(integers); // 6.0
        double sum2 = printer.sumOfElements(doubles);  // 7.5
//        double sum3 = printer.sumOfElements(strings);  // 7.5

        log.info("sum1 {} sum2 {}", sum1, sum2);
    }
}
