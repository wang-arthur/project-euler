// find the sum of all #s that can be written as the sum of 5th powers of their digits
public class Problem030 {
    
    public static int digitPowers(int a) {
        int sum = 0;
        while (a > 0) {
            sum += Math.pow((a % 10), 5);
            a /= 10;
        }
        return sum;
    }
    
    
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i < 300000; i++) {
            if (digitPowers(i) == i) sum += i;
        }
        System.out.println(sum);
    }
    
}