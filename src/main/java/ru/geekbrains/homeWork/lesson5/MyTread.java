package ru.geekbrains.homeWork.lesson5;

import java.util.Arrays;

public class MyTread {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        calculate(arr);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void runTwoThreads() {
        float[] fullSizeArr = new float[SIZE];
        float[] halfSizeArr1 = new float[HALF_SIZE];
        float[] halfSizeArr2 = new float[HALF_SIZE];
        Arrays.fill(fullSizeArr, 1.0f);

        long startTime = System.currentTimeMillis();
        System.arraycopy(fullSizeArr, 0, halfSizeArr1, 0, HALF_SIZE);
        System.arraycopy(fullSizeArr, HALF_SIZE, halfSizeArr2, 0, HALF_SIZE);

        new Thread(() -> {
            float[] a1 = calculate(halfSizeArr1);
            System.arraycopy(a1, 0, halfSizeArr1, 0, a1.length);
        }).start();

        new Thread(() -> {
            float[] a2 = calculate(halfSizeArr2);
            System.arraycopy(a2, 0, halfSizeArr2, 0, a2.length);
        }).start();

        System.arraycopy(halfSizeArr1, 0, fullSizeArr, 0, HALF_SIZE);
        System.arraycopy(halfSizeArr2, 0, fullSizeArr, HALF_SIZE, HALF_SIZE);
        System.out.println("Two threads time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void main(String[] args) {
        MyTread o = new MyTread();
        o.runOneThread();
        o.runTwoThreads();
    }
}
