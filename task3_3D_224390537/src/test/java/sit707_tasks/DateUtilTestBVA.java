package sit707_tasks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateUtilTestBVA {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Day boundaries by one day

    @Test
    public void testMinimumValidDay() {
        DateUtil date = new DateUtil(1, 5, 2024);
        Assert.assertEquals("1 May 2024", date.toString());
    }

    @Test
    public void testMaximumValidDay() {
        DateUtil date = new DateUtil(31, 1, 2024);
        Assert.assertEquals("31 January 2024", date.toString());
    }

    // Leap year boundaries by one day

    @Test
    public void testLeapYearEndOfFebruary() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        Assert.assertEquals("29 February 2024", date.toString());
    }

    @Test
    public void testNonLeapYearEndOfFebruary() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        Assert.assertEquals("1 March 2023", date.toString());
    }

    // Month boundaries by one day

    @Test
    public void testEndOfAprilToMay() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals("1 May 2024", date.toString());
    }

    @Test
    public void testEndOfJanuaryToFebruary() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals("1 February 2024", date.toString());
    }

    // Year rollover by one day

    @Test
    public void testEndOfYearToNextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals("1 January 2025", date.toString());
    }

    @Test
    public void testStartOfYearToPreviousYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals("31 December 2023", date.toString());
    }

    // Week boundaries

    @Test
    public void testIncrementByWeeksToNextMonth() {
        DateUtil date = new DateUtil(25, 1, 2024);
        date.incrementByWeeks(1);
        Assert.assertEquals("1 February 2024", date.toString());
    }

    @Test
    public void testDecrementByWeeksToPreviousMonth() {
        DateUtil date = new DateUtil(3, 3, 2024);
        date.decrementByWeeks(1);
        Assert.assertEquals("25 February 2024", date.toString());
    }

    // Month boundaries

    @Test
    public void testIncrementByMonthsBoundaryEndOfMonth() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.incrementByMonths(1);
        Assert.assertEquals("29 February 2024", date.toString());
    }

    @Test
    public void testDecrementByMonthsBoundaryEndOfMonth() {
        DateUtil date = new DateUtil(31, 5, 2024);
        date.decrementByMonths(1);
        Assert.assertEquals("30 April 2024", date.toString());
    }

    // Year boundaries

    @Test
    public void testIncrementByYearsLeapToNonLeap() {
        DateUtil date = new DateUtil(29, 2, 2024); // Leap year
        date.incrementByYears(1); // 2025 is not leap
        Assert.assertEquals("28 February 2025", date.toString());
    }

    @Test
    public void testDecrementByYearsLeapToNonLeap() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.decrementByYears(4); // 2020 was leap, 2020 → 2016
        Assert.assertEquals("29 February 2020", date.toString()); // Still leap
    }

    @Test
    public void testDecrementByYearsToNonLeapYear() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.decrementByYears(1); // 2023 not leap
        Assert.assertEquals("28 February 2023", date.toString());
    }
}
