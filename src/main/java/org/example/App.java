package org.example;


import org.example.entity.Employee;

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
        // 1-я задача
        firstTask();
        // 2-я задача
        secondTask();
        // 3-я задача
        thirdTask();
        // 4-я задача
        fourthTask();
        // 5-я задача
        fifthTask();
        // 6-я задача
        sixthTask();



    }


    public static void firstTask(){
        // Разные подходы к решению первой задачи
        // 1
        System.out.println("Задача 1");

        employees.stream()
                .filter(employee -> employee.getSalary() > 50000 && employee.getAge() > 30)
                .forEach(System.out::println);

        System.out.println("=======================================");

        // 2
        Stream<Employee> employeesStream = employees.stream()
                .filter(employee -> employee.getSalary() > 50000 && employee.getAge() > 30);

        employeesStream.forEach(System.out::println);

    }

    public static void secondTask(){
        // 2-я задача
        System.out.println("=======================================");
        System.out.println("Задача 2");

        System.out.println("Отсортируйте отфильтрованный список сотрудников по имени в алфавитном порядке.");

        employees.stream()
                .sorted(Employee::compareTo).forEach(System.out::println);
    }


    public static void thirdTask(){
        // 3-я задача
        System.out.println("=======================================");
        System.out.println("Задача 3");
        System.out.println("Используя метод map, " +
                "преобразуйте список сотрудников в список строк, содержащих информацию о каждом сотруднике в формате: Имя: {name}, Отдел: {department}");
        employees.stream().map(employee -> "Имя: " + employee.getName() + ", Отдел: " + employee.getDepartment())
                .forEach(System.out::println);
    }


    public static void fourthTask(){
        // 4-я задача
        System.out.println("=======================================");
        System.out.println("Задача 4");
        System.out.println("Соберите преобразованный список в коллекцию List<String>");
        System.out.println(employees.stream().collect(Collectors.toList()));
    }


    public static void fifthTask(){
        // 5-я задача
        System.out.println("=======================================");
        System.out.println("Задача 5");
        System.out.println(" * Найдите среднюю зарплату сотрудников, отфильтрованных на этапе 2.\n" +
                " * Найдите сотрудника с максимальной зарплатой.");

        Double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println(averageSalary);

        Optional<Employee> highestPaidEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));

        highestPaidEmployee.ifPresent(employee -> System.out.println("Highest Paid Employee: " + employee.getName() +
                ".Salary: " + employee.getSalary()));

    }

    public static void sixthTask(){
        // 6-я задача
        System.out.println("=======================================");
        System.out.println("Задача 6");

        System.out.println("* Используя метод groupingBy, сгруппируйте сотрудников по отделам, " +
                "и подсчитайте количество сотрудников в каждом отделе.");


        Map<String, Long> departamentCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        for (Map.Entry<String, Long> entry : departamentCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        }

    }

