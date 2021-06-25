package ru.geekbrains.homeWork.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("абажур");
        words.add("абаз");
        words.add("абаза");
        words.add("абаим");
        words.add("абака");
        words.add("абакумовщина");
        words.add("абажур");
        words.add("абанус");
        words.add("абанусливый");
        words.add("абажур");
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println(uniqueWords);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(words, word));
        }

        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "791234567901");
        phonebook.add("Иванов", "791234567902");
        phonebook.add("Иванов", "791234567906");
        phonebook.add("Петров", "791234567903");
        phonebook.add("Петров", "791234567904");
        phonebook.add("Сидоров", "791234567905");

        System.out.println("Иванов");
        System.out.println(phonebook.get("Иванов"));
        System.out.println("Петров");
        System.out.println(phonebook.get("Петров"));
        System.out.println("Сидоров");
        System.out.println(phonebook.get("Сидоров"));
    }

    static class Phonebook {
        private final HashMap<String, List<String>> book;

        public Phonebook(){
            this.book = new HashMap<>();
        }

        public void add(String lastname, String number){
            if(book.containsKey(lastname)){
                List<String> numbers = book.get(lastname);
                if(!numbers.contains(number)){
                    numbers.add(number);
                    System.out.printf("Фамилия %s номер телефона %s\n", lastname, number);
                }
            } else {
                book.put(lastname, new ArrayList<>(Collections.singletonList(number)));
                System.out.printf("Фамилия %s номер телефона %s\n", lastname, number);
            }
        }

        public List<String> get(String lastname){
            if(book.containsKey(lastname)){
                return book.get(lastname);
            }
            return new ArrayList<>();
        }
    }
}
