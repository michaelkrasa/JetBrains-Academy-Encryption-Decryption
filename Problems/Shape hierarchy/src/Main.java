abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    final double a;
    final double b;
    final double c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a+b+c;
    }

    @Override
    double getArea() {
        double s = getPerimeter()/2.0;
        return Math.pow(s * (s-a) * (s-b) * (s-c), 0.5);
    }
}

class Rectangle extends Shape {

    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getPerimeter() {
        return 2*(length + width);
    }

    @Override
    double getArea() {
        return length * width;
    }
}

class Circle extends Shape {

    final double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }
}
