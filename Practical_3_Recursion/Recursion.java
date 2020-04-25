package lab3_recursion;

public class Recursion{


    static int Fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    static int fibonacciIterative(int n){
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }

        //temp = 1
        //fib = 1 + 1
        //prevFib = 1

        //temp = 2
        //fib = 2 + 1
        //prevFib = 2

        //temp = 3
        //fib = 3 + 2
        //prevFib = 3

        return fib;
    }



    static void towersOfHanoi(int disk, String source, String dest, String auxiliary){
        //towersOfHanoi(disk, source, dest, auxiliary);
        if(disk == 1){
            //towersOfHanoi(disk-1, dest, source, auxiliary);
            System.out.println(source + "->" + dest);
            return;
        }


        towersOfHanoi(disk-1, source, auxiliary, dest);
        System.out.println(source + "->" + dest);
        towersOfHanoi(disk -1, auxiliary, dest, source);



    }

    public static void main(String[] args) {
        // write your code here
        int n = 4;
        //System.out.println(Fibonacci(n));
        //System.out.println(fibonacciIterative(n));
        String auxiliary = "B";
        String dest = "C";
        String source = "A";
        int disk = 3;
        towersOfHanoi(disk, source, dest, auxiliary);
    }

 
 
}
