package ru.geekbrains.homeWork.lesson1;

import ru.geekbrains.homeWork.lesson1.members.*;
import ru.geekbrains.homeWork.lesson1.obstacles.*;

public class AppTest {

    public static void main(String[] args) {

        Member[] members = {new Human("Alex"), new Cat("Tom"), new Robot("Bender")};
        Obstacle[] obstacles = {new RunningTrack(500), new Wall(6)};

        Team team = new Team("Rockets", members);

        System.out.println(team.getTeamName());

        team.showResults();

        Course course = new Course(obstacles);

        course.doIt(team);

        team.showResults();

        team.showMembersFinishedCourse();
    }

}
