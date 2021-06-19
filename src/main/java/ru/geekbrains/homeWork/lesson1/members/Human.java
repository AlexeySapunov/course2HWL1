package ru.geekbrains.homeWork.lesson1.members;

public class Human implements Member {
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 500;
        this.maxJumpHeight = 3;
        this.onDistance = true;
    }

    public void run(int distance){
        if (distance <=maxRunDistance){
            System.out.println(name + " " + " ran successfully");
        } else {
            System.out.println(name + " " + " could not run");
            onDistance = false;
        }
    }

    public void jump(int height){
        if (height <=maxJumpHeight){
            System.out.println(name + " " + " successfully coped with the obstacle");
        } else {
            System.out.println(name + " " + " could not overcome the obstacle");
            onDistance = false;
        }
    }

    public void showResult(){
        System.out.println(name + ": " + onDistance);
    }
}
