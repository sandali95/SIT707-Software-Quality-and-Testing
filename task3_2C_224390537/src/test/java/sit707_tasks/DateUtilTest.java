package sit707_tasks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Ahsan Habib
 */
public class DateUtilTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid day: 29, max day: 28");
		new DateUtil(29, 2, 2021);
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
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid day: 31, max day: 30");
		new DateUtil(31, 4, 2020);
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
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid day: 30, max day: 29");
		new DateUtil(30, 2, 2020);
	}

	@Test
	public void testIncrementDay() {
		DateUtil date = new DateUtil(31, 12, 2020);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2021, date.getYear());
	}

	@Test
	public void testDecrementDay() {
		DateUtil date = new DateUtil(1, 1, 2021);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2020, date.getYear());
	}

	@Test
	public void testInvalidYearBelowRange() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid year: 1699, expected range 1700-2024");
		new DateUtil(1, 1, 1699);
	}

	@Test
	public void testInvalidYearAboveRange() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid year: 2025, expected range 1700-2024");
		new DateUtil(1, 1, 2025);
	}

	@Test
	public void testInvalidMonthBelowRange() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid month: 0, expected range 1-12");
		new DateUtil(1, 0, 2025);
	}

	@Test
	public void testInvalidMonthAboveRange() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid month: 13, expected range 1-12");
		new DateUtil(1, 13, 2025);
	}

	@Test
	public void testInvalidDayBelowRange() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid day: 0, expected range 1-31");
		new DateUtil(0, 1, 2025);
	}

	@Test
	public void testInvalidDayAboveRange() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid day: 32, expected range 1-31");
		new DateUtil(32, 1, 2025);
	}
}