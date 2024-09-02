package ThirdHomeworkAston;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Пример работы с Integer
        List<Integer> initialList = new ArrayList<>();
        initialList.add(5);
        initialList.add(3);
        initialList.add(8);
        initialList.add(1);

        MyArrayList<Integer> intList = new MyArrayList<>(initialList);

        // Добавление дополнительных элементов
        intList.add(2);
        intList.add(7);
        intList.add(6);
        intList.add(4);

        // Вывод начального списка
        System.out.println("Несортированный список Integer:");
        printList(intList);

        // Сортировка и вывод отсортированного списка
        MyArrayList.sort(intList);
        System.out.println("\nОтсортированный список Integer:");
        printList(intList);

        // Удаление элемента по индексу
        intList.remove(3);  // Удаление элемента по индексу 3
        System.out.println("\nСписок после удаления элемента с индексом 3:");
        printList(intList);

        // Очистка списка
        intList.clear();
        System.out.println("\nСписок после очистки:");
        printList(intList);

        // Пример работы с addAll
        List<Integer> additionalInts = new ArrayList<>();
        additionalInts.add(10);
        additionalInts.add(20);
        additionalInts.add(30);

        // Инициализация нового списка и добавление элементов
        MyArrayList<Integer> newIntList = new MyArrayList<>();
        newIntList.add(1);
        newIntList.add(2);

        // Использование метода addAll для добавления всех элементов из additionalInts
        newIntList.addAll(additionalInts);
        System.out.println("\nСписок после добавления элементов из additionalInts:");
        printList(newIntList);

        // Пример работы с пользовательскими объектами
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 30));
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 35));

        MyArrayList<Person> customList = new MyArrayList<>(personList);

        // Добавление нового объекта
        customList.add(new Person("Charlie", 28));

        // Вывод начального списка
        System.out.println("\nНесортированный список Person:");
        printList(customList);

        // Сортировка и вывод отсортированного списка
        MyArrayList.sort(customList);
        System.out.println("\nОтсортированный список Person:");
        printList(customList);

        // Удаление элемента по индексу
        customList.remove(1);  // Удаление элемента по индексу 1
        System.out.println("\nСписок после удаления элемента с индексом 1:");
        printList(customList);

        // Очистка списка
        customList.clear();
        System.out.println("\nСписок после очистки:");
        printList(customList);

        // Пример работы с addAll для пользовательских объектов
        List<Person> morePeople = new ArrayList<>();
        morePeople.add(new Person("Eve", 40));
        morePeople.add(new Person("Frank", 22));

        MyArrayList<Person> anotherCustomList = new MyArrayList<>();
        anotherCustomList.add(new Person("Grace", 32));

        // Использование метода addAll для добавления всех элементов из morePeople
        anotherCustomList.addAll(morePeople);
        System.out.println("\nСписок после добавления элементов из morePeople:");
        printList(anotherCustomList);
    }

    // Метод для печати элементов списка
    private static <T> void printList(MyArrayList<T> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Element at index " + i + ": " + list.get(i));
            }
        }
    }
}

// Пример класса Person, который реализует Comparable для сортировки
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
