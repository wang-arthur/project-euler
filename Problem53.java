//How many, not necessarily distinct, values of  n choose r, for 1 ² n ² 100, 
// are greater than one-million?
public class Problem53 {
    
    public static int choose(int n, int r) {
        int a = Math.max(r, n-r);
        int b = Math.min(r, n-r);
        
        double answer = 1.0;
        
        for (int i = 1; i <= b; i++) {
            answer *= a+i;
            answer /= i;
        }
        
        return (int) answer;
        
    }
    
    // find the first value of r such that n choose r is greater than a million
    public static int firstMil(int n) {
        int r = 0;
        
        while (choose(n, r) <= 1000000) {
            r++;
        }
        return r;
    }
    
    // count the number of values r for which n choose r are greater than a mil
    public static int countMil(int n) {
        int R = firstMil(n);
        
        if (n % 2 == 0) return (((n/2) - R) * 2 + 1);
        else return 2*(( n/2 - R) + 1);
        
    }
    
    public static void main(String[] args) {
        int count = 0;
        for (int n = 23; n <= 100; n++) {
            count += countMil(n);  
        }
        
        
        System.out.println(count);
    }
}
