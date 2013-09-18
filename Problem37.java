public class Problem37 {
    
    public static boolean isComposite(int a) {
        
        // 1 is not composite by convention, but I'm using "composite" here to mean non-prime
        if (a == 1) return true;
        
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return true;
        }
        return false;
    }
    
    //helper methods
    public static int numDigits(int a) {
        int counter = 0;
        int b = a;
        while (b != 0) {
            b /= 10;
            counter++;
        }
        return counter;
    }
    public static int leadingDigit(int a) {
        int b = a;
        while (b / 10 != 0) {
            b/=10;   
        }
        return b;
    }
    
    public static int stripLeadingDigit(int a) {
        return a - leadingDigit(a) * (int)Math.pow(10, numDigits(a)-1);
    }
    
    public static boolean isTruncatable(int a) {
        int b = a;
        if (isComposite(a)) return false;
        
        // check truncation from right to left
        while (b > 0) {
            if (isComposite(b)) return false;
            b/= 10;
        }
        
        // check truncation from left to right
        int c = a;
        while (c > 0) {
            if (isComposite(c)) return false;
            
            c = stripLeadingDigit(c);
        }
        return true;
    }
    
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 11; i < 1000000; i = i + 2) {
            if (isTruncatable(i)) sum+=i;
        }
        
        System.out.println(sum);
    }
    
}

