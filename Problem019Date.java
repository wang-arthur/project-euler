
// create date data type
public class Problem019Date {
    public int date; // date -- ex: 25
    public int month;
    public int year;
    public int day; //day of week
    
    public Problem019Date(int date, int month, int year, int day) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.day = day;
    }
    
    public void nextDay() {
        //increase day
        date++;
        
        // increase day of week
        day = (day + 1) % 7;
        
        // new month
        if ((month == 9 
                 || month == 4 
                 || month == 6 
                 || month == 11) // month is September, April, June, or November
                && date > 30) // and we've reached the end of the month
        {
            date = 1;
            month++;
        }
        //leap years
        else if (month == 2 // month is February
                     && (year % 4 == 0) && (!(year % 100 == 0) || year % 400 == 0) // and it's a leap year
                     && date > 29) // and it's the end of the month
        {
            date = 1;
            month++;
        }
        //non leap year Februaries
        else if (month == 2 && date > 28) {
            date = 1;
            month++;
        }
        // 31 day months
        else if (date > 31) {
            date = 1;
            month++;
        }
        
        
        // new years
        if (month > 12) {
            date = 1;
            month = 1;
            year++;
        }
    }
}