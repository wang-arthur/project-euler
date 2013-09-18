// find the difference between (1+2+3+...+100)^2 and 1^2+2^2+3^2+...+100^2
public class Problem6 {
    public static void main(String[] args) {
        int N = 100;
        
        // use closed form expressions for the summations
        int sumSquared = N * (N+1) * N * (N+1) / 4;
        int squareSum = N * (N+1) * (2*N+1) / 6;
        
        int difference = sumSquared - squareSum;
        System.out.println(difference);
    }
}