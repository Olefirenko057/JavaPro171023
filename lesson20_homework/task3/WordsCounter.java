package org.example.homeworks.lesson20_homework.task3;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsCounter {
    //3. Разбить текст на слова с помощью регулярного выражение и рассчитать словарь встречающихся слов для этого текста
    //(подсчитать количество одинаковых слов, встречающихся в этом тексте).
    public static void main(String[] args) {
        String text = "There are two kinds of floating-point types, float and double, which represent single- and double-precision numbers, respectively.\n";
        countWords(text);
    }
    public static String[] wordsSplitter(String text) {
        String[] words = text.split("\\W+");
        return words;
    }
    public static void countWords(String text) {
        System.out.println(Arrays.stream(wordsSplitter(text))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
    }
}
