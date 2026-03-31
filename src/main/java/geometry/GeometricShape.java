package geometry;

public interface GeometricShape {
    double getPerimetr();
    double getArea();

    String getFillColor();
    String getBorderColor();

    default void printInfo(){
        System.out.println("Периметр: " + getPerimetr());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
    }

}
