package ua.nure;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class AppPerson
{
    public static void main( String[] args )
    {
        log.info( "Hello World! {} {}", 232, 2.5 );
        Set<Person> people = new TreeSet<>();
        people.add(new Person("Іван", "Петров", 28));
        people.add(new Person("Марія", "Коваленко", 32));
        people.add(new Person("Олександр", "Шевченко", 25));
        people.add(new Person("Анна", "Мельник", 30));
        people.add(new Person("Петро", "Іваненко", 42));
// Виводимо всіх людей (будуть відсортовані за прізвищем)
        System.out.println("Список людей (відсортований):");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
