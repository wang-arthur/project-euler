// Sum the multiples of 3 or 5 below 1000
public class Problem1 {
    
    public static void main(String[] args) {
        
        int N = 1000;
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 || (i % 5 == 0 && i % 3 != 0)) sum += i;
        }
        System.out.println(sum);
    }
}