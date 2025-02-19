package ua.nure;

public class CheckByValue {

    public static void sendByValue(int a) {
        a+=90;
        System.out.println("in method sendByValue" + a);
    }

    public static void sendByValueInteger(Integer a) {
        a+=90;
        System.out.println("in method sendByValueInteger: " + a);
    }

    public static void main(String[] args) {
        int a =100;
        sendByValue(a);
        System.out.println("after method a: " + a);
        Integer val = 100;
        sendByValueInteger(val);
        System.out.println("after method val" + val);

        String str1 = "Hello"; // Без new
        Integer num1 = 10;
        String str = null;
        if (str == null){
            System.out.println("str is null");
        }

    }
}

