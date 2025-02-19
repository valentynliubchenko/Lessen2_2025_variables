package ua.nure;

public class CheckByValueMutable {

    public static void sendByValue(Person p) {
        Person newP =p.withName("New name");
        System.out.println("in method sendByValue" + newP.getName());
    }

    public static void main(String[] args) {
        Person person = new Person("init name");
        sendByValue(person);
        System.out.println("after method: " + person.getName());
    }
}

