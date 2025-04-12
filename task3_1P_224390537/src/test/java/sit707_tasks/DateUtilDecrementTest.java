package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for DateUtil decrement functionality.
 */
public class DateUtilDecrementTest {

    @Test
    public void test1A(){
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("June1ShouldDecrementToMay31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test2A(){
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("June2ShouldDecrementToJune1 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test3A(){
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("June15ShouldDecrementToJune16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test4A(){
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("June30ShouldDecrementToJune29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test5A() {
        try {
            DateUtil date = new DateUtil(31, 6, 1994);
            System.out.println("June31ShouldThrowException > " + date);

            Assert.fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            Assert.assertEquals("Invalid day: 31, max day: 30",ex.getMessage());
        }
    }

    @Test
    public void test6A(){
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("January15ShouldDecrementToJanuary14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test7A(){
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("February15ShouldDecrementFebruary14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test8A(){
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("November15ShouldDecrementToNovember16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test9A(){
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("December15ShouldDecrementToDecember14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test10A(){
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("June15ShouldDecrementToJune14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1700, date.getYear());
    }

    @Test
    public void test11A(){
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("June15ShouldDecrementToJune14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1701, date.getYear());
    }

    @Test
    public void test12A(){
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("June15ShouldDecrementToJune14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void test13A(){
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("June15ShouldDecrementToJune14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void test14B() {
        DateUtil date = new DateUtil(1, 3, 1996);
        System.out.println("March01_1996ShouldDecrementToFebruary29_1996 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test15B() {
        DateUtil date = new DateUtil(1, 3, 2021);
        System.out.println("March01_2021ShouldDecrementToFebruary28_2021 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(28, date.getDay());
    }

}
