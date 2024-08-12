package org.example;


import org.example.entity.Employee;
import org.example.entity.Product;
import org.example.entity.Transaction;
import org.example.tasks.firstDay;
import org.example.tasks.secondDay;

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




    }




}

