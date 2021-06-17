package ru.geekbrains.homeWork.lesson1.members;

public interface Member {
    void run(int distance);
    void jump(int height);
    boolean isOnDistance();
    void showResult();
}
