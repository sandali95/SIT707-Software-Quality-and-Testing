package sit707_tasks;

/**
 * @author Ahsan Habib
 */
public class DateUtil {

    // Months in order 0-11 maps to January-December.
    private static String[] MONTHS = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private int day, month, year;

    /*
     * Constructs object from given day, month and year.
     */
    public DateUtil(int day, int month, int year) {
        // Is supplied day/month/year a valid date?
        if (day < 1 || day > 31)
            throw new RuntimeException("Invalid day: " + day + ", expected range 1-31");
        if (month < 1 || month > 12)
            throw new RuntimeException("Invalid month: " + month + ", expected range 1-12");
        if (year < 1700 || year > 2026)
            throw new RuntimeException("Invalid year: " + year + ", expected range 1700-2026");
        if (day > monthDuration(month, year))
            throw new RuntimeException("Invalid day: " + day + ", max day: " + monthDuration(month, year));
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Increment one day.
     */
    public void increment() {
        if (day < monthDuration(month, year)) {
            // At least 1 day remaining in current month of year.
            day++;
        } else if (month < 12) {
            // Last day of a month AND month is less than December, so +1d is first day of next month.
            day = 1;
            month++;
        } else {
            // Month is December, so +1d is 1st January next year.
            day = 1;
            month = 1;
            year++;
        }
    }

    /**
     * Decrement one day from current date.
     */
    public void decrement() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            month = 12;
            year--;
            day = monthDuration(month, year);
        }
    }

    /**
     * Increments the current date by a specified number of days.
     * This method repeatedly calls the existing one-day increment().
     *
     * @param days the number of days to add to the current date.
     * @throws IllegalArgumentException if the input is negative.
     */
    public void increment(int days) {
        if (days < 0)
            throw new IllegalArgumentException("Use decrement(int days) for negative values.");
        for (int i = 0; i < days; i++) {
            increment();
        }
    }

    /**
     * Decrements the current date by a specified number of days.
     * This method repeatedly calls the existing one-day decrement().
     *
     * @param days the number of days to subtract from the current date.
     * @throws IllegalArgumentException if the input is negative.
     */
    public void decrement(int days) {
        if (days < 0)
            throw new IllegalArgumentException("Use increment(int days) for negative values.");
        for (int i = 0; i < days; i++) {
            decrement();
        }
    }

    /**
     * Increments the current date by a specified number of weeks.
     * Each week is treated as 7 days.
     *
     * @param weeks the number of weeks to add.
     * @throws IllegalArgumentException if the input is negative.
     */
    public void incrementByWeeks(int weeks) {
        if (weeks < 0)
            throw new IllegalArgumentException("Use decrementByWeeks(int weeks) for negative values.");
        increment(weeks * 7);
    }

    /**
     * Decrements the current date by a specified number of weeks.
     * Each week is treated as 7 days.
     *
     * @param weeks the number of weeks to subtract.
     * @throws IllegalArgumentException if the input is negative.
     */
    public void decrementByWeeks(int weeks) {
        if (weeks < 0)
            throw new IllegalArgumentException("Use incrementByWeeks(int weeks) for negative values.");
        decrement(weeks * 7);
    }

    /**
     * Increments the current date by a specified number of months.
     * Handles varying month lengths and year rollover.
     *
     * @param months the number of months to add.
     * @throws IllegalArgumentException if the input is negative.
     */
    public void incrementByMonths(int months) {
        if (months < 0)
            throw new IllegalArgumentException("Use decrementByMonths(int months) for negative values.");

        int totalMonths = this.month + months;
        this.year += (totalMonths - 1) / 12;
        this.month = ((totalMonths - 1) % 12) + 1;

        int maxDay = monthDuration(this.month, this.year);
        if (this.day > maxDay) {
            this.day = maxDay;  // Adjust if original day overflows in new month
        }
    }

    /**
     * Increments the current date by a specified number of years.
     * Adjusts the day for leap year rules (e.g., Feb 29 becomes Feb 28 in non-leap years).
     *
     * @param years the number of years to add.
     * @throws IllegalArgumentException if input is negative.
     */
    public void incrementByYears(int years) {
        if (years < 0)
            throw new IllegalArgumentException("Use decrementByYears(int years) for negative values.");

        this.year += years;

        // Adjust day if the new year makes the current day invalid (e.g., Feb 29 → Feb 28)
        int maxDay = monthDuration(this.month, this.year);
        if (this.day > maxDay) {
            this.day = maxDay;
        }
    }

    /**
     * Decrements the current date by a specified number of years.
     * Adjusts the day for leap year rules (e.g., Feb 29 becomes Feb 28 in non-leap years).
     *
     * @param years the number of years to subtract.
     * @throws IllegalArgumentException if input is negative.
     */
    public void decrementByYears(int years) {
        if (years < 0)
            throw new IllegalArgumentException("Use incrementByYears(int years) for negative values.");

        this.year -= years;

        int maxDay = monthDuration(this.month, this.year);
        if (this.day > maxDay) {
            this.day = maxDay;
        }
    }


    /**
     * Decrements the current date by a specified number of months.
     * Handles varying month lengths and year rollback.
     *
     * @param months the number of months to subtract.
     * @throws IllegalArgumentException if the input is negative.
     */
    public void decrementByMonths(int months) {
        if (months < 0)
            throw new IllegalArgumentException("Use incrementByMonths(int months) for negative values.");

        int totalMonths = this.month - months;
        while (totalMonths <= 0) {
            this.year--;
            totalMonths += 12;
        }
        this.month = totalMonths;

        int maxDay = monthDuration(this.month, this.year);
        if (this.day > maxDay) {
            this.day = maxDay;  // Adjust if original day overflows in new month
        }
    }


    /**
     * Calculate duration of current month of year.
     *
     * @param month
     * @param year
     * @return
     */
    public static int monthDuration(int month, int year) {
        if (month == 2 && year % 4 == 0) {
            // February leap year?
            return 29;
        } else if (month == 2) {
            // normal 28 days February
            return 28;

        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // 30 days' months
            return 30;
        }
        return 31;  // rest are 31 days' months.
    }

    /**
     * User friendly output.
     */
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }

}
