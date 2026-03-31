package org.example;

public class Кот extends Животное {
    private static int catCount = 0;
    private boolean isFull = false;

    public Кот(String name) {
        super(name, 200, 0, false);
        catCount++;
    }

    public void Покушать(Миска bowl, int amount) {
        if (bowl.уменьшениеПитания(amount)) {
            isFull = true;
            System.out.println(name + " Покушал и сыт");
        } else {
            System.out.println(name + " Не стал есть мало еды");
        }
    }

    public boolean isFull(){return isFull;}
    public static int getCatCount(){return catCount;}

}