package ThirdHomeworkAston;

import java.util.ArrayList;
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

        intList.add(2);
        intList.add(7);
        intList.add(6);
        intList.add(4);

        System.out.println("Несортированный список Integer:");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("Element at index " + i + ": " + intList.get(i));
        }

        MyArrayList.sort(intList);

        System.out.println("\nОтсортированный список Integer:");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("Element at index " + i + ": " + intList.get(i));
        }


        // Пример работы с пользовательскими объектами (если есть такой класс)
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 30));
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 35));

        MyArrayList<Person> customList = new MyArrayList<>(personList);

        customList.add(new Person("Charlie", 28));

        System.out.println("\nНесортированный список Person:");
        for (int i = 0; i < customList.size(); i++) {
            System.out.println("Element at index " + i + ": " + customList.get(i));
        }

        MyArrayList.sort(customList); // Предполагается, что класс Person реализует Comparable

        System.out.println("\nОтсортированный список Person:");
        for (int i = 0; i < customList.size(); i++) {
            System.out.println("Element at index " + i + ": " + customList.get(i));
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