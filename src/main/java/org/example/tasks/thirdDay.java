package org.example.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class thirdDay {

    public static void firstTask(){
        /* Напишите программу, которая принимает список строк и подсчитывает количество слов в каждой строке,
        а затем собирает результаты в карту, где ключ — это строка, а значение — количество слов в ней.
         */

        List<String> sentences = Arrays.asList("Java is great", "Stream API is powerful", "I love programming");

        Map<String, Integer> stringCount =  sentences.stream()
                .map(s -> s.split(" ")).collect(Collectors.toMap(s -> s[0], s -> 1));

        System.out.println(stringCount);
    }


}
