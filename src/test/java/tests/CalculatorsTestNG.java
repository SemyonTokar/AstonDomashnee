package tests;

import calculators.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorsTestNG {
    @Test
    public void testFactorialNormal(){
        assertEquals(FactorialNumbers.calculate(5),120);
    }
    @Test
    public void testFactorialZero(){
        assertEquals(FactorialNumbers.calculate(0),1);
    }
    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative(){
            FactorialNumbers.calculate(-3);
    }
    @Test
    public void testTriangleNormal(){
        assertEquals(TriangleNumbers.calculate(10,5),25.0);
    }
    @Test
    public void testTriangleFractional(){
        assertEquals(TriangleNumbers.calculate(2.5,3),3.75);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleNegative(){
            TriangleNumbers.calculate(-5,10);
    }
    @Test
    public void testArithmeticAddSubtract(){
        assertEquals(ArithmeticNumbers.add(10,5),15);
        assertEquals(ArithmeticNumbers.subtract(10,5),5);
    }
    @Test
    public void testArithmeticMultiplyDivide(){
        assertEquals(ArithmeticNumbers.multiply(10,5),50);
        assertEquals(ArithmeticNumbers.divide(10,5),2.0);
    }
    @Test (expectedExceptions = ArithmeticException.class)
    public void testArithmeticDivideByZero(){
            ArithmeticNumbers.divide(10,0);
    }
    @Test
    void testComparatorFirstGreater(){
        assertEquals(ComparatorNumbers.compare(10,5),1);
    }
    @Test
    void testComparatorFirstLess(){
        assertEquals(ComparatorNumbers.compare(3,8),-1);
    }
    @Test
    void testComparatorEqual(){
        assertEquals( ComparatorNumbers.compare(7,7),0);
    }
}
