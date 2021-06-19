package ru.geekbrains.homeWork.lesson2;

public class MyArrayDataException extends MyException{
    public MyArrayDataException(int i, int j) {
        super(String.format("Неверные данные находятся в ячейке [%d, %d]\n", i, j));
    }
}
