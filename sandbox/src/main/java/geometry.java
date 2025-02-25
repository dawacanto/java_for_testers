public class geometry {
    public static void main(String[] args) {
        printSquareArea(6.8);
        printSquareArea(8.8);
        printSquareArea(6.2);

        printRectangleArea (3.0, 5.0);
        printRectangleArea (4.0, 5.0);
        printRectangleArea (7.0, 9.0);

    }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + "равна " + rectangleArea(a,b) );
    }

    private static double rectangleArea(double a, double b) {
        return a*b;
    }

    static void printSquareArea (double a ){
        System.out.println("Площадь квадрата со стороной " + a +  " = " + squareArea(a));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}
