// Sum the even Fibonacci #s below four million
public class Problem2 {
    public static void main(String[] args) {
        
        int N = 4000000;
        
        int sum = 0;
        
        int fibo1 = 1;
        int fibo2 = 2;
        
        while (fibo2 < N) {
            if (fibo2 % 2 == 0) sum += fibo2;
            int i = fibo2;
            fibo2 = fibo1 + fibo2;
            fibo1 = i;
        }
    
        System.out.println(sum);
    }
}