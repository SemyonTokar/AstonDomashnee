package calculators;

public class TriangleNumbers {
    public static double calculate(double base, double height){
        if(base <= 0 || height <= 0){
            throw new IllegalArgumentException("Стороны не должны быть меньше 0");
        }
        return 0.5 * base * height;
    }
}
