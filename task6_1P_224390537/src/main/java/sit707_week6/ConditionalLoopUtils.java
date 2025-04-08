package sit707_week6;

public class ConditionalLoopUtils {

    /**
     * Part B(a): Loop with simple instructions in the body.
     * Sums integers from 1 to n (inclusive).
     */
    public static int sumUpTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Part B(b): Loop with a conditional inside.
     * Counts how many numbers from 1 to n are even.
     */
    public static int countEvenNumbers(int n) {
        int count = 0;
        int i = 1;
        while (i <= n) {
            if (i % 2 == 0) {
                count++;
            }
            i++;
        }
        return count;
    }
}
