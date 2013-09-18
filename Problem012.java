// find the first triangular number (n*n+1)/2 with over 500 divisors
public class Problem012 {
    
    //divisor function calculation/algorithm from elementary number theory
    public static int divisorFunction(int a) {
        int b = a;
        int sigma = 1;
        int i = 2;
        
        while (b != 1) {
            int counter = 1;
            while (b % i == 0) {
                b /= i;
                counter++;
            }
            i++;
            sigma *= counter;
        }
        return sigma;
    }
    
    public static int nthTriangular(int n) {
        return n*(n+1) / 2;    
    }
    
    public static void main(String[] args) {
        
        int maxDivisors = 0;
        int c = 1;
        
        while (maxDivisors <= 500) {
            int d = divisorFunction(nthTriangular(c));
            if (d > maxDivisors) maxDivisors = d;
            c++;
        }
        
       System.out.println(nthTriangular(c-1));
    }
    
}