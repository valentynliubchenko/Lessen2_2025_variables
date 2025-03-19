package ua.nure;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class AppPerson
{

    public static void main( String[] args ) {
        // Створюємо масив людей
        Person[] people = new Person[4];
        people[0] = new Person("Іван", 25);
        people[1] = new Person("Марія", 20);
        people[2] = new Person("Петро", 30);
        people[3] = new Person("Олена", 22);
        // Виводимо початковий масив
        System.out.println("Масив до сортування:");
        System.out.println(Arrays.toString(people));


        // Сортуємо за допомогою Arrays.sort()
        // Це працює, тому що Person реалізує Comparable
        Arrays.sort(people);

        // Виводимо відсортований масив
        System.out.println("\nМасив після сортування за віком:");
        System.out.println(Arrays.toString(people));
        // Сортування у зворотному порядку з використанням компаратора
        Arrays.sort(people, Comparator.reverseOrder());

        System.out.println("\nМасив після сортування за віком (спадання):");
        System.out.println(Arrays.toString(people));
        // Сортування за ім'ям з використанням компаратора
        Arrays.sort(people, Comparator.comparing(Person::getName));
        System.out.println("\nМасив після сортування за ім'ям:");
        System.out.println(Arrays.toString(people));
        // Приклад використання власного компаратора для більш складного        сортування
        // Сортування: спочатку за довжиною імені, а потім за віком
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // Спочатку порівнюємо за довжиною імені
                int nameLengthComparison =
                        Integer.compare(p1.getName().length(), p2.getName().length());
                // Якщо довжини імен рівні, порівнюємо за віком
                if (nameLengthComparison == 0) {
                    return Integer.compare(p1.getAge(), p2.getAge());
                }
                return nameLengthComparison;
            }
        });
        System.out.println("\nМасив після сортування за довжиною імені, потім за віком:");
        System.out.println(Arrays.toString(people));
    }
}
