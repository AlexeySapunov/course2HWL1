package ru.geekbrains.homeWork.lesson1.members;

public class Team {
    String teamName;
    Member[] teamMembers = new Member[4];


    public Team(String teamName, Member[] teamMembers){
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public String getTeamName(){
        return "Team name: " + teamName;
    }

    public Member[] getMembers(){
        return teamMembers;
    }

    public void showResults(){
        for(Member c: teamMembers){
            c.showResult();
        }
    }

    public void showMembersFinishedCourse(){
        for(Member c: teamMembers){
            if(c.isOnDistance())
                c.showResult();
        }
    }
}
