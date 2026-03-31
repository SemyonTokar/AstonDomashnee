package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Животные");
        Собака dog1 = new Собака("Жук");
        Собака dog2 = new Собака("Дружок");
        Кот cat1 = new Кот("Мурзик");
        Кот cat2 = new Кот("Марсик");

        dog1.run(600);
        dog2.run(150);
        dog1.swim(5);

        cat1.run(100);
        cat2.swim(5);

        System.out.println("Всего животных: " + Животное.getAnimalCount());
        System.out.println("Собак: " + Собака.getDogCount());
        System.out.println("Кошек: " + Кот.getCatCount());

        System.out.println("Еда: ");
        Миска bowl = new Миска(10);
        Кот[] cats = {cat1, cat2};

        for (Кот cat : cats) {
            cat.Покушать(bowl, 20);
        }
    }
}