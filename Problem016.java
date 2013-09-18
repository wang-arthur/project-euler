// What is the sum of the digits of the number 2^1000?

// 302 digits

public class Problem016 {
    //too large to store as integer -- represent powers of two using a digit array
    public static void overflow(int[] a) {
        for (int i = 0; i < 301; i++) {
            if (a[i] > 9) {
                int b = a[i] / 10;
                a[i] = a[i] % 10;
                
                a[i+1] += b;
            }
        }
    }
        
    public static void multiply(int[] a, int n) {
        for (int i = 0; i < 302; i++) {
            a[i] *=n;
        }
        overflow(a);
    }
    
    public static void main(String[] args) {
       
        int[] A = new int[302];
        A[0] = 1;
        int N = 1000;
        
        for (int i = 0; i < N; i++) {
            multiply(A, 2);
        }
        
        int sum = 0;
        for (int i = 0; i < 302; i++) {
            sum += A[i];
        }
        
        System.out.println(sum);
    }
}


