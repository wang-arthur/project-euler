// how many words in the text file are "triangle words"?
// triangle words are words whose value (sum of alphabetical position of letters)
// is a triangular number

public class Problem42 {
    
    public static boolean isTriangular(int a) {
        int i = 0;
        while (i * (i+1) / 2 <= a) {
            if (i* (i+1) /2 == a) return true;
            i++;
        }
        return false;
    }
    
    public static int wordValue (String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (int)(s.charAt(i)) - 64;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int counter = 0;
        
        while (!StdIn.isEmpty()) {
        String s = StdIn.readString();
        if (isTriangular(wordValue(s))) counter++;
        }
        StdOut.println(counter);

    }
}