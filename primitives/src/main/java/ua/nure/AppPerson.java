package ua.nure;

public class AppPerson {
    public static void main(String[] args) {
        Person person = new Person("first name");
        System.out.println(person );
        System.out.println(person.getClass() );
        System.out.println(person.hashCode() );

        Object object = new Person("Second name");

    }
}
