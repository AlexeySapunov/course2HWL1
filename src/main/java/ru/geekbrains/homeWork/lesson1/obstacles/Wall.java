package ru.geekbrains.homeWork.lesson1.obstacles;

import ru.geekbrains.homeWork.lesson1.members.Member;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Member member) {
        member.jump(height);
    }
}
