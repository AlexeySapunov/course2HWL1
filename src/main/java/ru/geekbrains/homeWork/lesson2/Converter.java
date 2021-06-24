package ru.geekbrains.homeWork.lesson2;

public class Converter {
    static int convertStringToNumber(String[][] stringsArr) {
        int sum = 0;
        if (stringsArr.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < stringsArr.length; i++) {
            if (stringsArr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < stringsArr[i].length; j++) {
                try {
                    sum += Integer.parseInt(stringsArr[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
