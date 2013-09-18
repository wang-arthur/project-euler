// a circular prime is a prime for which all rotations of the digits are prime
// How many circular primes are there below one million?
public class Problem35 {
    
        
    public static boolean isComposite(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return true;
        }
        return false;
    }
    
    public static int digits(int a) {
        int counter = 0;
        while (a > 0) {
            a /= 10;
            counter++;   
        }
        return counter;
    }
    
    // this method rotates a (sends unit digit to the front)
    public static int circulate(int a) {
        int digits = digits(a);
        int b = a/10 + (int)Math.pow(10, digits - 1) * (a % 10);
        return b;
    }
    
    // method rotates a n times
    public static int circulateN(int a, int n) {
        int b = a;
        for (int i = 0; i < n; i++) {
            b = circulate(b);
        }
        return b;
    }
    
    public static boolean isCircularPrime(int a) {        
        for (int i = 0; i < digits(a); i++) {
            if (isComposite(circulateN(a, i))) return false;
        }
        return true;
        
    }
    
    
    public static void main(String[] args) {
        int N = 1000000;
        
        int counter = 0;
        
        for (int i = 2; i < N; i++) {
            if (isCircularPrime(i)) counter++;
            
        }
        System.out.println(counter);
    }
}
