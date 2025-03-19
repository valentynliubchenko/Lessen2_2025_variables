package ua.nure;

import java.util.List;

public class PrintList {
    public void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
