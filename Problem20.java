// find the sum of digits of 100!
public class Problem20 {
    // store large number as array of digits
    public static void overflow(int[] a) {
        for (int i = 0; i < 200; i++) {
            if (a[i] > 9) {
                int c = a[i] / 100;
                int b = (a[i] / 10) % 10;
                a[i] = a[i] % 10;
                
                a[i+1] += b;
                a[i+2] += c;
            }
        }
    }
        
    public static void Multiply(int[] a, int n) {
        for (int i = 0; i < 200; i++) {
            a[i] *=n;
        }
        overflow(a);
    }
    
    public static void main(String[] args) {
       
        int[] A = new int[200];
        A[0] = 1;
        int N = 100;
        
        for (int i = 1; i <= N; i++ ) {
            Multiply(A, i);
        }
        
        int sum = 0;
        for (int i = 0; i < 200; i++) {
            sum += A[i];
        }
        
        System.out.println(sum);
    }
}


