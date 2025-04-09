package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class ConditionalLoopUtilsTest {

    @Test
    public void testSumUpToZero() {
        Assert.assertEquals(0, ConditionalLoopUtils.sumUpTo(0));
    }

    @Test
    public void testSumUpToOne() {
        Assert.assertEquals(1, ConditionalLoopUtils.sumUpTo(1));
    }

    @Test
    public void testSumUpToFive() {
        Assert.assertEquals(15, ConditionalLoopUtils.sumUpTo(5));
    }

    @Test
    public void testCountEvenZero() {
        Assert.assertEquals(0, ConditionalLoopUtils.countEvenNumbers(0));
    }

    @Test
    public void testCountEvenOne() {
        Assert.assertEquals(0, ConditionalLoopUtils.countEvenNumbers(1));
    }

    @Test
    public void testCountEvenFive() {
        Assert.assertEquals(2, ConditionalLoopUtils.countEvenNumbers(5));
    }

    @Test
    public void testCountEvenTen() {
        Assert.assertEquals(5, ConditionalLoopUtils.countEvenNumbers(10));
    }
}
