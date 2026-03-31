package org.example;

public class Собака extends Животное {
    private static int dogCount = 0;

    public Собака(String name) {
        super(name, 500, 10, true);
        dogCount++;
    }
    public static int getDogCount(){
        return dogCount;
    }

}
