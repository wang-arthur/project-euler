// find the denominator of the product of the four, digit canceling fractions (for example, 49/98 = 4/8)

public class Problem33 {
    
    public static void main(String[] args) {
        
        for (int a = 1; a < 10; a++) {
            for (int c = 1; c < 10; c++) {
                for (int d = 1; d < 10; d++) {
                    if ((9*a*d + d*c == 10*a*c) && 10*a+c < 10 * c + d) {
                        System.out.println("a = " + a);
                        System.out.println("c = " + c);
                        System.out.println("d = " + d);
                        System.out.println();
                    }   
                }   
            }
        }
    }
}