package animalsInfo;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean minusFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void plusFood(int amount) {
        foodAmount += amount;
        System.out.println("Добавлено: " + amount + " еды. Всего: " + foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
