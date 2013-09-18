/*
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 
 0.123456789101112131415161718192021...
 
 It can be seen that the 12th digit of the fractional part is 1.
 
 If dn represents the nth digit of the fractional part, find the value of the following expression.
 
 d1 ? d10 ? d100 ? d1000 ? d10000 ? d100000 ? d1000000
 */
public class Problem40 {
    
    
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
    
    public static int fractionDigit(int a) {
        int counter = 1;
        int i = 1;
        
        while (counter < a) {
            counter += numDigits(i);
            i++;
        }
        
        if (counter != a) {
            int c = counter-a;
            return ((i - 1) / (int)Math.pow(10, c - 1)) % 10;
        }
        return leadingDigit(i);
    }
    
    public static void main(String[] args) {
        int product = 1;
        
        for (int i = 0; i <= 6; i++) {
            product *= fractionDigit((int)Math.pow(10, i));
        }
        
        System.out.println(product);
    }
}