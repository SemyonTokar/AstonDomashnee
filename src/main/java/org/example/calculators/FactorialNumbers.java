package calculators;

public class FactorialNumbers {
    public static long calculate(int n){
        if (n < 0) throw new IllegalArgumentException("Число должно быть 0 или больше");
        long result = 1;

        for (int i = 2; i <= n; i++){
            result = result * i;
        }
        return result;
    }
}
