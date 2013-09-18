// find the maximum sum from the top to the bottom of a triangle of numbers
public class Problem18 {

    public static void main(String[] args) {        
        int N = 15; //num rows
        int[][] tri = new int[N+1][N+1];
        
        //fill in the array with the right values
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                tri[i][j] = StdIn.readInt();
            }
        }
        
        
        // method: start from the bottom of the triangle, and reduce the size of the problem
        // by one row at a time
        
        // greedy-ish algorithm: the maximum length path through tri[i-1][j] (second to bottom row)
        // has two options for its last stop: the two adjacent values tri[i][j] and tri[i][j+1]
        // the maximal path all the way to the bottom will go to the greater of the two options
        // => we can eliminate the bottom row, and replace tri[i-1][j] with (tri[i-1][j] + max(tri[i][j], tri[i][j+1])
        // repeat this process until there's only one value left at the peak of the triangle, the overall maximal path
        
        for (int i = N; i >=2; i--) {
            for (int j = 1; j <= i-1; j++) {
                tri[i-1][j] += Math.max(tri[i][j], tri[i][j+1]);
            }
        }
        
        int maxTotal = tri[1][1];
        
        StdOut.println(maxTotal);
        
        
        
    }
}