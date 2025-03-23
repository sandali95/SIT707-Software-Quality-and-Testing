package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224390537";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandali Samarawickrama";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testValidDate() {
		// Valid date: 15th January 2020
		DateUtil date = new DateUtil(15, 1, 2020);
		Assert.assertEquals(15, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
	}

	@Test
	public void testInvalidDayInFebruaryNonLeapYear() {
		// Invalid date: 29th February 2021 (not a leap year)
		try{
			new DateUtil(29, 2, 2021);
			Assert.fail("Expected RuntimeException for 29-02-2021");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}

	@Test
	public void testValidLeapYearDate() {
		// Valid date: 29th February 2020 (leap year)
		DateUtil date = new DateUtil(29, 2, 2020);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
	}

	@Test
	public void testInvalidDayIn30DayMonth() {
		// Invalid date: 31st April 2020 (April has only 30 days)
		try{
			new DateUtil(31, 4, 2020);
			Assert.fail("Expected RuntimeException for 31-04-2020");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}

	@Test
	public void testValid30DayMonthDate() {
		// Valid date: 30th April 2020
		DateUtil date = new DateUtil(30, 4, 2020);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(4, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
	}

	@Test
	public void testInvalidDayInFebruary() {
		// Invalid date: 30th February 2020 (February never has 30 days)
		try{
			new DateUtil(30, 2, 2020);
			Assert.fail("Expected RuntimeException for day 30-02-2020");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}

	@Test
	public void testIncrementDay() {
		// Test incrementing a valid date
		DateUtil date = new DateUtil(31, 12, 2020);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2021, date.getYear());
	}

	@Test
	public void testDecrementDay() {
		// Test decrementing a valid date
		DateUtil date = new DateUtil(1, 1, 2021);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
	}

	@Test
	public void testInvalidYearBelowRange() {
		try{
			new DateUtil(1,1,1699);
			Assert.fail("Expected RuntimeException for year 1699");
		}catch (Exception ex){
			Assert.assertEquals(RuntimeException.class,ex.getClass());
		}

	}

	@Test
	public void testInvalidYearAboveRange() {
		try{
			new DateUtil(1, 1, 2025);
			Assert.fail("Expected RuntimeException for year 2025");
		}catch (Exception ex){
			Assert.assertEquals(RuntimeException.class,ex.getClass());
		}
	}

	@Test
	public void testInvalidMonthBelowRange() {
		try{
			new DateUtil(1, 0, 2025);
			Assert.fail("Expected RuntimeException for month 0");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}

	@Test
	public void testInvalidMonthAboveRange() {
		try{
			new DateUtil(1, 13, 2025);
			Assert.fail("Expected RuntimeException for month 13");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}

	@Test
	public void testInvalidDayBelowRange() {
		try{
			new DateUtil(0, 1, 2025);
			Assert.fail("Expected RuntimeException for day 0");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}

	@Test
	public void testInvalidDayAboveRange() {
		try{
			new DateUtil(32, 1, 2025);
			Assert.fail("Expected RuntimeException for day 32");
		}catch (Exception ex) {
			Assert.assertEquals(RuntimeException.class, ex.getClass());
		}
	}
	

}
