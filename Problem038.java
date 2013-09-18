// What is the largest 1 to 9 pandigital 9-digit number that
// can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
public class Problem038 {
    
    public static boolean isPandigital(int a) {
        int[] digits = new int[9];
        int b = a;
        for (int i = 0; i < 9; i++) {
        digits[i] = b % 10;
        b /= 10;
        }
        
        // test to see if digits are all distinct (O(n^2) time, but because n is low,
        // an O(n log(n)) algorithm based on sorting might not be an improvement
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (digits[i] == digits[j] || digits[i] == 0) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int max = 0;
        // deduce that the largest 1-9 pandigital concatenation must start with a 9
        // could only be a 4 digit # multiplied by (1, 2)
        // (3 digits -> 9xx * (1, 2, 3) -- wouldn't produce the correct # of digits)
        // 2 digits -> 9x * (1, 2, 3, 4), etc.
        
        for (int i = 9000; i < 9400; i++) {
            int concat = (i * 100000 + 2 * i);
            if (isPandigital(concat) && concat > max) max = concat;
        }
        System.out.println(max);
    }
}

