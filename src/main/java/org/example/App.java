package org.example;


import org.example.entity.Employee;
import org.example.entity.Product;
import org.example.entity.Transaction;
import org.example.tasks.firstDay;
import org.example.tasks.secondDay;
import org.example.tasks.thirdDay;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Требования:
 * Создайте коллекцию объектов класса Employee.
 *
 * Каждый объект Employee должен содержать следующие поля: id (целое число), name (строка), age (целое число), salary (вещественное число), и department (строка).
 * Заполните коллекцию минимум 10 объектами.
 * Фильтрация:
 *
 * Используя Stream API, отфильтруйте всех сотрудников, чей возраст больше 30 лет и зарплата выше 50,000.
 * Сортировка:
 *
 * Отсортируйте отфильтрованный список сотрудников по имени в алфавитном порядке.
 * Маппинг:
 *
 * Используя метод map, преобразуйте список сотрудников в список строк, содержащих информацию о каждом сотруднике в формате: "Имя: {name}, Отдел: {department}".
 * Сборка в коллекцию:
 *
 * Соберите преобразованный список в коллекцию List<String>.
 * Терминальные операции:
 *
 * Найдите среднюю зарплату сотрудников, отфильтрованных на этапе 2.
 * Найдите сотрудника с максимальной зарплатой.
 * Дополнительное задание (необязательно):
 *
 * Используя метод groupingBy, сгруппируйте сотрудников по отделам, и подсчитайте количество сотрудников в каждом отделе.
 *
 *
 */

public class App {
    static List<Employee> employees = Arrays.asList(
            new Employee(50, "IT", 1, "John", 20000),
            new Employee(20, "Management", 2, "Alisa", 1500.5),
            new Employee(35, "Administration", 3, "Derek", 25000),
            new Employee(33, "Cybersecurity", 4, "Son Xiao", 50000),
            new Employee(27, "IT", 6, "Boris", 3555.5),
            new Employee(25, "Sales", 7, "Alejandro", 13456.6),
            new Employee(36, "Management", 8, "Joe Biden", 232345.4),
            new Employee(44, "IT", 9, "Trump", 1),
            new Employee(124, "Administration", 10, "Zeus", 99999)
    );


    public static void main( String[] args ) {

        /**  List<Employee> employees = Arrays.asList(
                new Employee(50, "IT", 1, "John", 20000),
                new Employee(20, "Management", 2, "Alisa", 1500.5),
                new Employee(35, "Administration", 3, "Derek", 25000),
                new Employee(33, "Cybersecurity", 4, "Son Xiao", 50000),
                new Employee(27, "IT", 6, "Boris", 3555.5),
                new Employee(25, "Sales", 7, "Alejandro", 13456.6),
                new Employee(36, "Management", 8, "Joe Biden", 232345.4),
                new Employee(44, "IT", 9, "Trump", 1),
                new Employee(124, "Administration", 10, "Zeus", 99999)
        );
         **/
        System.out.println("=======================================");
        System.out.println("Stream API Java задачи");
        System.out.println("=======================================");


        System.out.println("1 День");
        System.out.println(" ");

        // 1-я задача
        firstDay.firstTask();
        // 2-я задача
        firstDay.secondTask();
        // 3-я задача
        firstDay.thirdTask();
        // 4-я задача
        firstDay.fourthTask();
        // 5-я задача
        firstDay.fifthTask();
        // 6-я задача
        firstDay.sixthTask();

        System.out.println("=======================================");
        System.out.println("2 День");
        System.out.println(" ");


        // 1-я задача 2 день
        secondDay.firstTask();

        System.out.println("=======================================");
        // 2-я задача 2 день
        secondDay.secondTask();
        System.out.println("=======================================");
        // 3-я задача 2 день
        secondDay.thirdTask();
        System.out.println("=======================================");
        // 4-я задача 2 день
        secondDay.fourthTask();
        System.out.println("=======================================");
        // 5-я задача 2 день
        secondDay.fifthTask();
        System.out.println("=======================================");


        List<String> sentences = Arrays.asList("Java is great", "Stream API is powerful", "I love programming");


        Map<String, Integer> sentLength = sentences.stream()
                .collect(Collectors.toMap(
                        sentence -> sentence, // Key
                        sentence -> sentence.split(" ").length // Value
                ));

//        sentLength.forEach(
//                (s, integer) -> {
//                    System.out.println("Строка: " + '"'+ s + '"'+ " содержит " + integer + " слов(а).");
//                }
//        );

        /* Напишите программу, которая находит топ-N самых дорогих продуктов из списка объектов Product.
        Используйте Stream API для сортировки продуктов по цене и выбора топ-N элементов.

        Задача: Найти топ-2 самых дорогих продукта.
         */

        int n = 2;

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200),
                new Product("Phone", 800),
                new Product("Pen", 2),
                new Product("Notebook", 150),
                new Product("Tablet", 200)
        );

        List<String> mostExpensiveProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(n)
                .map(Product::getName)
                .collect(Collectors.toList());

//        mostExpensiveProducts.forEach(System.out::println);

        /* Напишите программу, которая принимает список продуктов и строку поиска,
        а затем возвращает список продуктов, названия которых содержат заданную подстроку (без учета регистра).
         */

        String searchQuery = "pen";

        List<String> arrayQuery = products.stream()
                .map(Product::getName)
                .filter(name -> name.toLowerCase().contains(searchQuery.toLowerCase()))
                .collect(Collectors.toList());

//        arrayQuery.forEach(System.out::println);

        /* Напишите программу, которая объединяет два списка объектов Product и удаляет дубликаты продуктов по их имени. */

        List<Product> products1 = Arrays.asList(
                new Product("Laptop", 1200),
                new Product("Phone", 800)
        );

        List<Product> products2 = Arrays.asList(
                new Product("Pen", 2),
                new Product("Phone", 800),
                new Product("Tablet", 200)
        );


        Map<String, Double> concProduct = Stream.concat(products1.stream(), products2.stream())
                .distinct()
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getPrice,
                        (price1, price2) -> price2
                ));

//        concProduct.forEach((name, price) -> System.out.println(name + " " + price));


        /* Напишите программу, которая находит элемент, который встречается наибольшее количество раз в списке строк.
        Используйте Stream API для этой задачи. */

        List<String> items = Arrays.asList("apple", "banana", "orange", "apple", "orange", "banana", "apple");


        Map<String, Long> mostOccurringItem = items.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

//        mostOccurringItem.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(e -> System.out.println(e.getKey() + " : " + e.getValue()));








    }




}



