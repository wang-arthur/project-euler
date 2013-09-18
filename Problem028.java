// evaluate the sum of the numbers on the diagonal of a 1001x1001 spiral 
// http://projecteuler.net/problem=28

public class Problem028 {
    
    public static void main(String[] args) {

        int sum = 0;
        int a = 1;
        
        // dimension
        int N = 1001;
        //number of terms
        int M = 2*(N-1) + 1;
        
        for (int i = 1; i <= M; i++) {
            sum += a;
            // evaluate terms based on the pattern that every 4 terms
            // the gap between terms increases by 2
            a +=  2 * ( (i-1) / 4 + 1);
        }
        System.out.println(sum);
        
    }
}