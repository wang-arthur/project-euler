// which starting number, under 1M, produces the longest collatz chain?
public class Problem14 {
    
    public static int cLength(Long n) {
        int counter = 1;
        while (n != 1) {
            if (n % 2 == 0) n = n/2;
            else n = 3*n+1;
            counter++;
        }
        return counter;
    }
    
    //brute force solution ~3 seconds
    public static void main(String[] args) {
        int max = 0;
        int N = 1000000;
     
        Long starting = 0L;
        for (Long i = 1L; i < N; i++) {
            int j = cLength(i);
            if (j > max) {
                max = j;
                starting = i;
            }
        }
            System.out.println(max);
            System.out.println(starting);
    }
}


