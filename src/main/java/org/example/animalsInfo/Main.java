package animalsInfo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Животные");
        Dog dog1 = new Dog("Жук");
        Dog dog2 = new Dog("Дружок");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Марсик");

        dog1.run(600);
        dog2.run(150);
        dog1.swim(5);

        cat1.run(100);
        cat2.swim(5);

        System.out.println("Всего животных: " + Animals.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Кошек: " + Cat.getCatCount());

        System.out.println("Еда: ");
        Bowl bowl = new Bowl(10);
        Cat[] cats = {cat1, cat2};

        for (Cat cat : cats) {
            cat.Eat(bowl, 20);
        }
    }
}