/*  A spiral is formed by writing 1 in the center of a square grid, and spiraling
 *  anticlockwise (http://projecteuler.net/problem=58).  If this process is continued, 
 *  what is the side length of the square spiral for
 *  which the ratio of primes along both diagonals first falls below 10%?
 */
public class Problem058 {
    
    public static boolean isComposite(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return true;
        }
        return false;
    }
    
    public static boolean isPrime(int a) {
        return (!isComposite(a) && a != 1);
    }
    
    public static void main(String[] args) {
        
        int primeCount = 0;
        int totalCount = 1;
        int a = 1;
        
        
        while (primeCount * 1.0 / totalCount > .1 || a < 5 ) {
            // closed form expression for terms in the spiral
            a += 2 * ( (totalCount-1) / 4 + 1);
            if (isPrime(a)) primeCount++;
            totalCount++;
        }
        
        
        
        
        System.out.println(2 * ((totalCount + 2)/4) + 1);
        
        
        
    }
}