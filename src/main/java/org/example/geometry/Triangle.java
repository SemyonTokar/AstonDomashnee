package geometry;

public class Triangle implements GeometricShape {
    private double a,b,c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor){
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public double getPerimetr(){return a + b + c;}
    public double getArea(){
        double p = getPerimetr() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public String getFillColor(){return fillColor;}
    public String getBorderColor(){return borderColor;}
}
