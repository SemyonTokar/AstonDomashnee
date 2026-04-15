package tests;

import calculators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class jUnit5Tests {
    @Test
    @DisplayName("Факториал 5! = 120")
    void testFactorialNormal(){
        assertEquals(120, FactorialNumbers.calculate(5));
    }
    @Test
    @DisplayName("Факториал 0! = 1 (граничный случай)")
    void testFactorialZero(){
        assertEquals(1,FactorialNumbers.calculate(0));
    }
    @Test
    @DisplayName("Факториал: отрицательное число - исключение")
    void testFactorialNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialNumbers.calculate(-3);
        });
    }
    @Test
    @DisplayName("Площадь треугольника: основание = 10, высота = 5 площадь = 25")
    void testTriangleNormal(){
        assertEquals(25.0,TriangleNumbers.calculate(10,5));
    }
    @Test
    @DisplayName("Площадь треугольника: дробные числа")
    void testTriangleFractional(){
        assertEquals(3.75,TriangleNumbers.calculate(2.5,3));
    }
    @Test
    @DisplayName("Площадь треугольника: отрицательное основание = исключение")
    void testTriangleNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleNumbers.calculate(-5,10);
        });
    }
    @Test
    @DisplayName("Арифметика: сложение и вычитание")
    void testArithmeticAddSubtract(){
        assertEquals(15,ArithmeticNumbers.add(10,5));
        assertEquals(5,ArithmeticNumbers.subtract(10,5));
    }
    @Test
    @DisplayName("Арифметика: умножение и деление")
    void testArithmeticMultiplyDivide(){
        assertEquals(50,ArithmeticNumbers.multiply(10,5));
        assertEquals(2.0,ArithmeticNumbers.divide(10,5));
    }
    @Test
    @DisplayName("Арифметика: деление на ноль = исключение")
    void testArithmeticDivideByZero(){
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticNumbers.divide(10,0);
        } );
    }
    @Test
    @DisplayName("Сравнение: первое больше второго -> 1")
    void testComparatorFirstGreater(){
        assertEquals(1,ComparatorNumbers.compare(10,5));
    }
    @Test
    @DisplayName("Сравнение: первое меньше второго -> -1")
    void testComparatorFirstLess(){
        assertEquals(-1,ComparatorNumbers.compare(3,8));
    }
    @Test
    @DisplayName("Сравнение: числа равны -> 0")
    void testComparatorEqual(){
        assertEquals(0, ComparatorNumbers.compare(7,7));
    }
}
