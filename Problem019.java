// how many sundays fell on the first of the month during the 20th century?
// 1/1/1901-12/31/2000
public class Problem019 {
    
    public static void main(String[] args) {
        //cycle through dates to check for desired sundays
        // Date(date, month, year, day of week - 0 == sunday)
        
        // see helper class
        Problem019Date date = new Problem019Date(1, 1, 1900, 1);
        
        int counter = 0;
        while (date.year != 2001) {
            if (date.date == 1 && date.day == 0 && date.year>=1901) counter++;
            date.nextDay();
        }
        
        // for (int i = 0; i < 4; i++) System.out.println(date[i]);
        System.out.println(counter);
    }
}
