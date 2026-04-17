package animalsInfo;

public class Cat extends Animals {
    private static int catCount = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name, 200, 0, false);
        catCount++;
    }

    public void Eat(Bowl bowl, int amount) {
        if (bowl.minusFood(amount)) {
            isFull = true;
            System.out.println(name + " Покушал и сыт");
        } else {
            System.out.println(name + " Не стал есть мало еды");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

}