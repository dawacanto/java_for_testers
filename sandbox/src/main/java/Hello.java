public class Hello {
    public static void main(String[] args) {

            var x = 1;
            var y = 0;
            if (y==0){
                System.out.println("Division by zero isn't allowed");
            }else {
                var z = divide(x, y);
                System.out.println("Hello");
            }
        }


    private static int divide(int x, int y) {
        return x / y;
    }
}

