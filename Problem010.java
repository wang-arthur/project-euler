//sum all the primes below two million

public class Problem010 {
    
    //faster -- uses sieve to build array of primes under 2M
    public static void sieveMethod(int N) {
        //prime[4] == false => 4 is not prime
        boolean[] prime = new boolean[N];
        for (int i = 0; i < N; i++) {
            prime[i] = true;
        }
        
        prime[0] = false;
        prime[1] = false;
        
        for (int i = 2; i < Math.sqrt(N) + 1; i++) {
            if (prime[i]) {
                int multiple = i * i;
                //all lower multiples will already have been knocked out by sieve
                while (multiple < N) {
                    prime[multiple] = false;
                    multiple += i;
                }
            }
        }
        
        Long sum = 0L;
        // sum all the primes under 2 mil
        for (int i = 0; i < N; i++) {
            if (prime[i]) sum += i;
        }
        System.out.println(sum);
    }
    
    
    //slower, brute force method
    public static boolean isPrime(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int N = 2000000;
        Long sum = 0L;
        for (int i = 2; i < N; i++) {
            if (isPrime(i)) sum += i;            
        }
        System.out.println(sum);
    }
    
}