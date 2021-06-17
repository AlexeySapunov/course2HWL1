package ru.geekbrains.homeWork.lesson1.obstacles;

import ru.geekbrains.homeWork.lesson1.members.Member;
import ru.geekbrains.homeWork.lesson1.members.Team;

public class Course {

    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        Member[] teamMembers = team.getMembers();
        if(teamMembers.length > 0){
            for (Member c: teamMembers){
                for (Obstacle o: obstacles){
                    o.doIt(c);
                    if (!c.isOnDistance()) break;
                }
            }
        } else {
            System.out.println("There are no members in the team!");
        }
    }
}
