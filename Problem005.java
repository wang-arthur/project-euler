// find the smallest positive # evenly divisible by all of the integers from 1 to 20

public class Problem005 {
    
    //least common multiple
    public static int LCM(int a, int b) {
        int x = a;
        int y = b;
        
        while (x != y) {
            if (x < y) x += a;
            else y += b;
        }
        return x;
    }
    
    public static void main(String[] args) {
        int N = 20;
        int num = 1;
        
        for (int i = 1; i <= N; i++) {
            num = LCM(num, i);
        }
        System.out.println(num);
    }
    
}