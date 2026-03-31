package org.example;

public class Миска {
    private int foodAmount;

    public Миска(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean уменьшениеПитания(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void добавитьЕду(int amount) {
        foodAmount += amount;
        System.out.println("Добавлено: " + amount + " еды. Всего: " + foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
