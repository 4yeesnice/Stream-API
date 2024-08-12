package org.example.tasks;

import org.example.entity.Product;
import org.example.entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class secondDay {

    public static void firstTask(){
        /*
         * Фильтрация уникальных элементов
         * Напишите программу, которая принимает список строк и использует Stream API для получения списка уникальных слов
         * (без учета регистра) длиной более 4 символов, отсортированных в алфавитном порядке.
         */

        System.out.println("/*\n" +
                "         * Фильтрация уникальных элементов\n" +
                "         * Напишите программу, которая принимает список строк и использует Stream API для получения списка уникальных слов\n" +
                "         * (без учета регистра) длиной более 4 символов, отсортированных в алфавитном порядке.\n" +
                "        */");

        System.out.println("List<String> words = Arrays.asList(\"Apple\", \"Banana\", \"apple\", \"Orange\", \"banana\", \"Pineapple\", \"Grape\", \"grape\"); ");
        List<String> words = Arrays.asList("Apple", "Banana", "apple", "Orange", "banana", "Pineapple", "Grape", "grape");


         List<String> distinctWords = words.stream().map(String::toLowerCase)
         .filter(word -> word.length() > 4).distinct().sorted().collect(Collectors.toList());

         System.out.println(distinctWords);
    }
    public static void secondTask(){
        /* Создайте программу, которая принимает список строк и вычисляет среднюю длину всех строк в списке с использованием Stream API. */

        System.out.println("/* Создайте программу, которая принимает список строк и вычисляет среднюю длину всех строк в списке с использованием Stream API. */ ");
        List<String> strings = Arrays.asList("Java", "Stream", "API", "is", "powerful");

         Double averageStringLenght = strings.stream()
            .mapToInt(String::length).average().orElse(0);

         System.out.println(averageStringLenght);
    }

    public static void thirdTask(){
        /* Напишите программу, которая преобразует список объектов класса Product в список строк,
            содержащих только названия продуктов, цена которых выше 100. Используйте Stream API для выполнения этой задачи. */
        System.out.println("/* Напишите программу, которая преобразует список объектов класса Product в список строк,\n" +
                "            содержащих только названия продуктов, цена которых выше 100. Используйте Stream API для выполнения этой задачи. */");
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200),
                new Product("Phone", 800),
                new Product("Pen", 2),
                new Product("Notebook", 150),
                new Product("Tablet", 200)
        );



        List<String> newList = products.stream()
                .filter(p -> p.getPrice() > 100)
                .map(Product::getName)
                .collect(Collectors.toList());


        System.out.println(newList);
    }

    public static void fourthTask(){
        /* Создайте программу, которая группирует список транзакций по категориям и вычисляет общую сумму транзакций для каждой категории. */
        System.out.println("/* Создайте программу, которая группирует список транзакций по категориям и вычисляет общую сумму транзакций для каждой категории. *");
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Food", 50),
                new Transaction("Entertainment", 100),
                new Transaction("Food", 30),
                new Transaction("Utilities", 200),
                new Transaction("Entertainment", 150)
        );

        Map<String, Double> transactionGroup = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingDouble(Transaction::getAmount)));

        for(Map.Entry<String, Double> transaction: transactionGroup.entrySet()){
            System.out.println(transaction.getKey() + ": " + transaction.getValue());
        }
    }

    public static void fifthTask(){
        /* Напишите программу, которая находит объект с максимальным значением по определенному критерию.
        Например, найдите продукт с максимальной ценой из списка объектов класса Product. */


        System.out.println("/* Напишите программу, которая находит объект с максимальным значением по определенному критерию.\n" +
                "        Например, найдите продукт с максимальной ценой из списка объектов класса Product. */");
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200),
                new Product("Phone", 800),
                new Product("Pen", 2),
                new Product("Notebook", 150),
                new Product("Tablet", 200)
        );


        // Два решенения
        Product maxPriceItem = products.stream() // Если есть компаратор в классе и без исклочения
                .max(Product::compareTo).get();

        Product maxPriceItem2 = products.stream() // можно сделать и без компоратара в классе, тогда нужно будет использовать Comparator.comparingDouble()
                // так же жеталельно добавить метод stream.ifPresent() или как здесь .orElseThrow()
                .max(Comparator.comparingDouble(Product::getPrice)).orElseThrow(() -> new RuntimeException("No max price item found"));

        System.out.println("Продукт с максимальной ценой: " + maxPriceItem2.getName() + ", Цена: " + maxPriceItem2.getPrice());
    }

}
