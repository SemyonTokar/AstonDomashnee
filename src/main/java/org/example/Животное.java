package org.example;

public class Животное {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected boolean canSwim;

    protected static int animalCount = 0;

    public Животное(String name, int runLimit, int swimLimit, boolean canSwim) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.canSwim = canSwim;

        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не пробежал " + distance + " м. (лимит: " + runLimit + ")");
        }
    }

    public void swim(int distance) {
        if (!canSwim) {
            System.out.println(name + " не умеет плавать!");
            return;
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " Не может проплыть " + distance + " м. (лимит: " + swimLimit);
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }

}
