//Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
public class Problem48 {
    
    public static Long addModTen(Long a, Long b) {

        return (a % (10000000000L) + b % (10000000000L))% 10000000000L;
    }
    
    
    public static Long multiplyModTen(Long a, Long b) {
        return (a * b) % (10000000000L);
    }
    
    public static Long selfPowerModTen(Long a) {
        Long b = 1L;
        
        for (int i = 0; i < a; i++) {
        b = multiplyModTen(a, b);
        }
        return b;
    }

public static void main(String[] args) {
    
    
    Long sum = 0L;
    
    for (Long i = 1L; i <= 1000L; i++) {
        
        sum = addModTen(sum, selfPowerModTen(i));
    }
    
    System.out.println(sum);
}

}