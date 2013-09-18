// find the largest prime factor of 600851475143

public class Problem003 {    
    public static void main(String[] args) {
        long N = 600851475143L;
        
        // loop to divide out all prime factors except for the largest (<N)
        // code is not as inefficient as it seems; i will not iterate 
        // 600851475143L times, because N decreases each time a prime factor is found
        
        for (int i = 2; i < N; i++) {
            while (N % i == 0) {N = N / i;}
        }
        System.out.println(N);

    }
    
}