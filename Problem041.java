
public class Problem041 {
    
    public static boolean isPandigital(int a) {
        int numDigits = (int)(Math.log10(a)+1);
        
        int[] digits = new int[numDigits];
        
        int b = a;
        
        for (int i = 0; i < numDigits; i++) {
            digits[i] = b % 10;
            b /= 10;
        }
        
        //test that digits are all distinct
        for (int i = 0; i < numDigits-1; i++) {
            for (int j = i + 1; j < numDigits; j++) {
                if (digits[i] == digits[j] || digits[i] == 0) return false;   
            }
        }
        
        // test that distinct digits are between 1 and numDigits
        // digits should sum to numDigits*(numDigits+1)/2
        int sum = 0;
        for (int i = 0; i < numDigits; i++) {
            sum += digits[i];
        }
        if (sum != numDigits*(numDigits+1)/2) return false;
        return true;
    }
    
    public static boolean isComposite(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        int max = 0;
        // narrow range -- 1-9 and 1-8 pandigital sums can't be prime
        // because they're always divisible by 3.  Therefore, we only have to
        // find the largest 7-digit pandigital prime.
        for (int i = 1234567; i < 7654321; i++) {
            if (isPandigital(i) && !isComposite(i)) max = i;
        }
        System.out.println(max);
    }
    
}

