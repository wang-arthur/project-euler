// find the sum of all #s less than a million that are palindromes in base 10 and base 2
public class Problem036 {
    
    public static boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    
    // converts a base-10 integer to a binary string
    public static String toBinary(int a) {
        String binA = "";
        
        while (a != 0) {
            binA = a%2 + binA;
            a /= 2;
        }
        return binA;   
    }
    
    
    public static void main(String[] args) {
        
        int sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(i + "") && isPalindrome(toBinary(i))) sum+=i;  
        }
        
        System.out.println(sum);
        
        
    }
}