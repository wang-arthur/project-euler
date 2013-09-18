public class Problem21{
    public static int LCM(int a, int b) {
        int x = a;
        int y = b;
        
        while (x != y) {
            if (x < y) x += a;
            else y += b;
        }
        return x;
    }
    
    // sigma function (sum of divisors) -- calculation from elementary number theory
    public static int sigma(int a) {
        int sum = 1;
        int b = a;
        for (int i = 2; i <= Math.sqrt(a) + 1; i++) {
            int ipower = 0;
            while (LCM(i, b) == b) {
                ipower++;
                b/=i;
            }
            sum *= (Math.pow(i, ipower + 1) - 1) / (i - 1);
        }
        if (b != 1) {
            sum *= (b  + 1);
        } 
            return sum - a;
        
    }
        public static void main(String[] args) {
            
            int sum = 0;
            for (int i = 2; i < 10000; i++) {
                if (sigma(sigma(i)) == i && sigma(i) != i) { sum+= i;
                
                if (i < sigma(i)) System.out.println(i + " and " + sigma(i));
                }
            }
            System.out.println(sum);            
        }
    }