// find the sum of all positive integers which cannot be written as the sum of 2 abundant #s
// abundant #: a number n for which sumofdivisors(n) > n
// we're given the fact that any integer greater than 28123 can be written as an abundant sum 

public class Problem023{
    
    // approach: 
    
    // sum of divisors
    public static int sigma(int a) {
        int sum = 1;
        
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                sum += i;
                if (a/i != i) sum += a/i;
            }
        }
        return sum;
    }
    
    
    public static boolean isAbundant(int a) {
        return sigma(a) > a;
    }
    
    public static int[] abundantNums(int N) {
        // returns an array of abundant nums <=N
        int[] nums = new int[1];
        int k = 0;
        
        for (int i = 11; i <= N; i++) {
            if (isAbundant(i)) {
                nums[k] = i;
                k++;
                if (k == nums.length) nums = resize(nums, k * 2);
            }
        }
        return nums;
    }
    
    // resize array
    private static int[] resize(int[] a, int N) {
        int[] newarray = new int[N];
        for (int i = 0; i < a.length; i++) {
            newarray[i] = a[i];
        }
        return newarray;
    }
    
    public static void main(String[] args) {
        
        // abundant sums <= 28123
        int[] abundant = abundantNums(28124);
        SET<Integer> abundantsums = new SET<Integer>();


   
        for (int i = 0; i < abundant.length; i++) {
            for (int j = i; j < abundant.length; j++) {
                if (abundant[i] + abundant[j] <= 28123
                   && abundant[i] != 0 && abundant[j] != 0) 
                    abundantsums.add(abundant[i] + abundant[j]);
            }
        }
        int sum = 0;
        for (int i = 1; i <= 28123; i++) {
            if (!abundantsums.contains(i)) sum += i;
        }
        System.out.println(sum);
        
    }
}