package sit707_tasks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateUtilTestECT {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testZeroIncrement() {
        DateUtil date = new DateUtil(10, 10, 2024);
        date.increment(0);
        Assert.assertEquals("10 October 2024", date.toString());
    }

    @Test
    public void testZeroDecrement() {
        DateUtil date = new DateUtil(10, 10, 2024);
        date.decrement(0);
        Assert.assertEquals("10 October 2024", date.toString());
    }

    //  Invalid day/month/year inputs

    @Test
    public void testInvalidDay() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Invalid day");
        new DateUtil(29, 2, 2023);
    }

    @Test
    public void testInvalidMonth() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Invalid month");
        new DateUtil(15, 13, 2024);
    }

    @Test
    public void testInvalidYear() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Invalid year");
        new DateUtil(15, 5, 1600);
    }

    //  Negative increments and decrements

    @Test
    public void testNegativeIncrement() {
        DateUtil date = new DateUtil(1, 1, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use decrement(int days)");
        date.increment(-3);
    }

    @Test
    public void testNegativeDecrement() {
        DateUtil date = new DateUtil(1, 1, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use increment(int days)");
        date.decrement(-2);
    }

    //  Weeks (valid and invalid classes)

    @Test
    public void testIncrementByWeeks() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.incrementByWeeks(2);
        Assert.assertEquals("15 March 2024", date.toString());
    }

    @Test
    public void testDecrementByWeeks() {
        DateUtil date = new DateUtil(15, 3, 2024);
        date.decrementByWeeks(2);
        Assert.assertEquals("1 March 2024", date.toString());
    }

    @Test
    public void testNegativeIncrementByWeeks() {
        DateUtil date = new DateUtil(1, 3, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use decrementByWeeks");
        date.incrementByWeeks(-1);
    }

    @Test
    public void testNegativeDecrementByWeeks() {
        DateUtil date = new DateUtil(15, 3, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use incrementByWeeks");
        date.decrementByWeeks(-2);
    }

    //  Months (valid and invalid classes)

    @Test
    public void testIncrementByMonths() {
        DateUtil date = new DateUtil(15, 1, 2024);
        date.incrementByMonths(2);
        Assert.assertEquals("15 March 2024", date.toString());
    }

    @Test
    public void testDecrementByMonths() {
        DateUtil date = new DateUtil(15, 3, 2024);
        date.decrementByMonths(2);
        Assert.assertEquals("15 January 2024", date.toString());
    }

    @Test
    public void testNegativeIncrementByMonths() {
        DateUtil date = new DateUtil(1, 3, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use decrementByMonths");
        date.incrementByMonths(-1);
    }

    @Test
    public void testNegativeDecrementByMonths() {
        DateUtil date = new DateUtil(1, 3, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use incrementByMonths");
        date.decrementByMonths(-1);
    }

    //  Years (valid and invalid classes)

    @Test
    public void testIncrementByYears() {
        DateUtil date = new DateUtil(15, 3, 2024);
        date.incrementByYears(2);
        Assert.assertEquals("15 March 2026", date.toString());
    }

    @Test
    public void testDecrementByYears() {
        DateUtil date = new DateUtil(15, 3, 2024);
        date.decrementByYears(2);
        Assert.assertEquals("15 March 2022", date.toString());
    }

    @Test
    public void testNegativeIncrementByYears() {
        DateUtil date = new DateUtil(15, 3, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use decrementByYears");
        date.incrementByYears(-1);
    }

    @Test
    public void testNegativeDecrementByYears() {
        DateUtil date = new DateUtil(15, 3, 2024);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Use incrementByYears");
        date.decrementByYears(-1);
    }
}
