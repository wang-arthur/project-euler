// Find the sum of all numbers which are equal to the sum of the factorial of their digits.
public class Problem34 {
    public static int digitFactorial (int a) {
        int sum = 0;
        int b = a;
        while (b > 0) {
            sum += factorial(b % 10);
            b /= 10;
        }
        return sum;
    }
    public static int factorial(int a) {
        int product = 1;
        for (int i = 1; i <= a; i++) {
            product *= i;
        }
        return product;
    }
    
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 3; i < 9999999; i++) {
            if (i == digitFactorial(i)) sum+= i;
        }
        System.out.println(sum);
    }   
}