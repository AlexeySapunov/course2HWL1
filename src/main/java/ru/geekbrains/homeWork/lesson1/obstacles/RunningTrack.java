package ru.geekbrains.homeWork.lesson1.obstacles;

import ru.geekbrains.homeWork.lesson1.members.Member;

public class RunningTrack extends Obstacle {
    private int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Member member) {
        member.run(distance);
    }
}
