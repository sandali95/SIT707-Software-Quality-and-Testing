package sit707_tasks;

import java.util.Random;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main {
    public static void main(String[] args) {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Original Date >>"+ date);
        date.incrementByMonths(1);  // Becomes 29 Feb 2024 (leap year adjustment)
        System.out.println("After adding 1 month >> "+date);

        date.incrementByWeeks(2);   // Adds 14 days
        System.out.println("After adding 2 weeks >>"+date);
        date.decrementByMonths(3);  // Moves 3 months back
        System.out.println("After reducing 3 months >>"+date);

        date.incrementByYears(1);  // Should become 28 Feb 2025
        System.out.println(date);  // 28 February 2025

        date.decrementByYears(1);  // Back to 28 Feb 2024 (will NOT go back to 29th)


    }
}
