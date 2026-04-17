package geometry;

public class Main {
    public static void main(String[] args){
        System.out.println("Геометрические фигуры");

        GeometricShape circle = new Circle(5,"Серый","Чёрный");
        GeometricShape rectangle = new Rectangle(5,4, "Синий", "Белый");
        GeometricShape triangle = new Triangle(4,5,6,"Фиолетовый","Жёлтый");

        System.out.println("Круг: ");
        circle.printInfo();

        System.out.println("Прямоугольник: ");
        rectangle.printInfo();

        System.out.println("Треугольник: ");
        triangle.printInfo();
    }
}
