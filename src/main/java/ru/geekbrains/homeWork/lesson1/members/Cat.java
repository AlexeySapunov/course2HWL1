package ru.geekbrains.homeWork.lesson1.members;

public class Cat implements Member {
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Cat(String name) {
        this.name = name;
        this.maxRunDistance = 1500;
        this.maxJumpHeight = 5;
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
