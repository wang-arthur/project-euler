// a bouncy # is one that's neither (weakly) increasing nor decreasing.
// Find the least number for which the proportion of bouncy numbers is exactly 99%.
public class Problem112 {
    
    public static boolean isIncreasing(int a) {
        int b = a;
        while (b != 0) {
            if (b%10 < ((b/10)%10)) return false;
            b/= 10;
        }
        return true;
    }
    
    public static boolean isDecreasing(int a) {
        int b = a;
        while (b != 0 && b/10 != 0) {
            if (b%10 > ((b/10)%10)) return false;
            b/= 10;
        }
        return true;
    }
    
    public static boolean isBouncy(int a) {
        if (!isIncreasing(a) && !isDecreasing(a)) return true;
        else return false;
    }
    
    
    public static void main(String[] args) {
        double bouncy = 1.;
        double total = 101.;
        int i = 101;
        
        while (bouncy/total < .99) {
            i++;
            if (isBouncy(i)) bouncy = bouncy+1;
            total = total+1;
        }
        
        System.out.println(i);

        
        
        
    }
    
}