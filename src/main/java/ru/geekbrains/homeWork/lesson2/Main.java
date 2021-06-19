package ru.geekbrains.homeWork.lesson2;

public class Main {

    public static void main(String[] args) {
        String[][] correctArr = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7", "8"}
        };
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convertStringToNumber(correctArr) + ".\n");
        } catch (MyException e) {
            e.getStackTrace();
        }

        String[][] wrongSizeArr = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7"}
        };
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convertStringToNumber(wrongSizeArr) + ".\n");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        String[][] toCharArr = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7", "A"}
        };
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convertStringToNumber(toCharArr) + ".\n");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        String[][] toStringArr = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "String", "2"},
                {"0", "2", "7", "8"}
        };
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convertStringToNumber(toStringArr) + ".\n");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
