// find the 10001th prime number
public class Problem7 {
    public static boolean isPrime(int a) {
        // assume a >= 2
        for (int i = 2; i < Math.sqrt(a)+1; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int N = 10001;
        int counter = 1;
        int i = 2;
        int latestPrime = 2;
        
        while (counter < N) {
            if (isPrime(i)) {
                counter+=1;   
                latestPrime = i;
            }
            i++;
        }

        System.out.println(latestPrime);
    }

}
