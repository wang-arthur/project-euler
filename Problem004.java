// find the largest palindrome that's the product of two 3-digit #s
public class Problem004 {
    
    public static boolean isPalindrome(int a) {
        String s = "" + a;
        for (int i = 0; i <= s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int max = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = i; j <= 999; j++) {
                int product = i*j;
                if (isPalindrome(product) &&  i*j >= max) max = i*j;
            }
        }   
        
        System.out.println(max);
    }
}