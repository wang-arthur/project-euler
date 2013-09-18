//Find the maximum total from top to bottom in triangle.txt, 
//a 15K text file containing a triangle with one-hundred rows.
//Note: same solution as problem 18
public class Problem067 {    
    public static void main(String[] args) {
        int N = 100; // num rows
        int[][] tri = new int[N+1][N+1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                tri[i][j] = StdIn.readInt();
            }
        }
        for (int i = N; i >=2; i--) {
            for (int j = 1; j <= i-1; j++) {
                tri[i-1][j] += Math.max(tri[i][j], tri[i][j+1]);
            }
        }
        
        int maxTotal = tri[1][1];
        StdOut.println(maxTotal);
    }
}