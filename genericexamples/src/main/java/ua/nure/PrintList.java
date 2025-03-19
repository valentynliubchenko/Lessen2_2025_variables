package ua.nure;

import java.util.List;

public class PrintList {
    public void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
    public double sumOfElements(List<? extends Number > list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
