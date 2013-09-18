//What is the first term in the Fibonacci sequence to contain 1000 digits?
public class Problem025 {
    
    public static void overflow(int[] a) {
        for (int i = 0; i < 1000; i++) {
            if (a[i] > 9) {
                int b = a[i] / 10;
                a[i] = a[i] % 10;
                a[i+1] += b;
            }
        }
    }
    
    public static void sum(int[] a, int[] b) {
        for (int i = 0; i < 1000; i++) {
            b[i] = b[i] + a[i];
        }
        overflow(b);
    }
    
    public static void iterate(int[] fibo1, int[] fibo2) {
        int[] fibo3 = new int[1000];
        for (int i = 0; i < 1000; i++) fibo3[i]=fibo2[i];
        sum(fibo1, fibo2);
        for (int i = 0; i < 1000; i++) fibo1[i]=fibo3[i];
    }


public static void main(String[] args) {
    int[] fibo1 = new int[1000];
    int[] fibo2 = new int[1000];
    fibo1[0] = 1;
    fibo2[0] = 1;

    int N = 1000; //numdigits
    
    int counter = 2;    
    while(fibo2[N-1] == 0) {
        iterate(fibo1, fibo2);
        counter++;
    }
    

    System.out.println(counter);
    
    
    
}

}