// first 10 digits of the sum of 100 50-digit #s

public class Problem013 {
    
    // approach: represent large numbers with digit arrays
    
    
    public static void add(int[] a, int[] b) {
        for (int i = 0; i < 53; i++) {
            a[i] += b[i];
        }
        overflow(a);
    }
    
    //"carry" helper method
    public static void overflow(int[] a) {
        for (int i = 0; i < 53; i++) {
            if (a[i] > 9) {
                int b = (a[i] / 10) % 10;
                a[i] = a[i] % 10;
                
                a[i+1] += b;
            }
        }
    }
        

    
    public static void main(String[] args) {
       
        int[] A = new int[53];
        int[] B = new int[53];
        
        String s = StdIn.readString();
        for (int i = 0; i < 50; i++) {
            A[i] = Integer.parseInt(s.substring(i, i+1));
        }
        
        for (int j = 0; j < 99; j++) {
            String p = StdIn.readString();
            for (int i= 0; i < 50; i++) {
                B[i] = Integer.parseInt(p.substring(i, i+1));
            }
            add(A, B);
        }
        
        for (int i = 0; i < 53; i++) {
            System.out.print(A[i]);
        }
         System.out.println();
        
    }
}


