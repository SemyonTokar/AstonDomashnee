package animalsInfo;

public class Dog extends Animals {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10, true);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

}
