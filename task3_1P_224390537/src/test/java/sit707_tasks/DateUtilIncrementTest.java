package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for DateUtil increment functionality.
 */
public class DateUtilIncrementTest {

    @Test
    public void test1B() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("June1ShouldIncrementToJune2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test2B() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("June2ShouldIncrementToJune3 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(3, date.getDay());
    }

    @Test
    public void test3B() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("June15ShouldIncrementToJune16 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test4B() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("June30ShouldIncrementToJuly1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(7, date.getMonth()); // July
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test5B() {
        try {
        DateUtil date = new DateUtil(31, 6, 1994);
        System.out.println("June31ShouldThrowException > " + date);
            Assert.fail("Expected RuntimeException was not thrown");

        } catch (RuntimeException ex) {
            Assert.assertEquals("Invalid day: 31, max day: 30", ex.getMessage());
        }
    }



    @Test
    public void test6B() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("January15ShouldIncrementToJanuary16 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getMonth()); // January
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test7B() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("February15ShouldIncrementToFebruary16 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth()); // February
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test8B() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("November15ShouldIncrementToNovember16 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(11, date.getMonth()); // November
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test9B() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("December15ShouldIncrementToDecember16 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(12, date.getMonth()); // December
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test10B() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("June15_1700ShouldIncrementToJune16_1700 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test11B() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("June15_1701ShouldIncrementToJune16_1701 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test12B() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("June15_2023ShouldIncrementToJune16_2023 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test13B() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("June15_2024ShouldIncrementToJune16_2024 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth()); // June
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test14B() {
        DateUtil date = new DateUtil(28, 2, 1996);
        System.out.println("February28_1996ShouldIncrementToFebruary29_1996 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test15B() {
        DateUtil date = new DateUtil(29, 2, 1996);
        System.out.println("February29_1996ShouldIncrementToMarch01_1996 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test16B() {
        DateUtil date = new DateUtil(28, 2, 2021);
        System.out.println("February28_2021ShouldIncrementToMarch01_2021 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test17B() {
        try {
            DateUtil date = new DateUtil(29, 2, 1994);
            System.out.println("February29ShouldThrowException > " + date);

            Assert.fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            Assert.assertEquals("Invalid day: 29, max day: 28",ex.getMessage());
        }
    }
}
