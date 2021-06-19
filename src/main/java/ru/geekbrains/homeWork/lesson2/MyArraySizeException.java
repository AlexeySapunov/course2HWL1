package ru.geekbrains.homeWork.lesson2;

public class MyArraySizeException extends MyException {
    public MyArraySizeException() {
        super("Размерность массива должна быть [4 x 4]\n");
    }
}
