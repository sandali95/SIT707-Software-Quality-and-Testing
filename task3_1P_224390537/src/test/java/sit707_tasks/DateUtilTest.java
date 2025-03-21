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
		String studentId = "s224390537";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandali Samarawickrama";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
		System.out.println("january31ShouldIncrementToFebruary1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
		System.out.println("january31ShouldDecrementToJanuary30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
		DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
		System.out.println("testJanuaryNominal > " + date);
		date.increment();
		System.out.println(date);
	}

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// January min boundary area: min+1
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// January min boundary area: min-1
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMaxFebruary29ShouldIncrementToMarch1() {
		// February max boundary area: max+1 (leap year)
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("february29ShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxFebruary29ShouldDecrementToFebruary28() {
		// February max boundary area: max-1 (leap year)
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("february29ShouldDecrementToFebruary28 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testNominalFebruary() {
		int rand_day_1_to_29 = 1 + new Random().nextInt(29);
		DateUtil date = new DateUtil(rand_day_1_to_29, 2, 2024);
		System.out.println("testFebruaryNominal > " + date);
		date.increment();
		System.out.println(date);
	}

	@Test
	public void testMinFebruary1ShouldIncrementToFebruary2() {
		// February min boundary area: min+1
		DateUtil date = new DateUtil(1, 2, 2024);
		System.out.println("february1ShouldIncrementToFebruary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMinFebruary1ShouldDecrementToJanuary31() {
		// February min boundary area: min-1
		DateUtil date = new DateUtil(1, 2, 2024);
		System.out.println("february1ShouldDecrementToJanuary31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMaxMarch31ShouldIncrementToApril1() {
		// March max boundary area: max+1
		DateUtil date = new DateUtil(31, 3, 2024);
		System.out.println("march31ShouldIncrementToApril1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(4, date.getMonth());
		Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxMarch31ShouldDecrementToMarch30() {
		// March max boundary area: max-1
		DateUtil date = new DateUtil(31, 3, 2024);
		System.out.println("march31ShouldDecrementToMarch30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testNominalMarch() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
		DateUtil date = new DateUtil(rand_day_1_to_31, 3, 2024);
		System.out.println("testMarchNominal > " + date);
		date.increment();
		System.out.println(date);
	}

	@Test
	public void testMinMarch1ShouldIncrementToMarch2() {
		// March min boundary area: min+1
		DateUtil date = new DateUtil(1, 3, 2024);
		System.out.println("march1ShouldIncrementToMarch2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMarch1ShouldDecrementToFebruary29() {
		// March min boundary area: min-1 (leap year)
		DateUtil date = new DateUtil(1, 3, 2024);
		System.out.println("march1ShouldDecrementToFebruary29 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	// ... (similar tests for April to December)

	@Test
	public void testMaxDecember31ShouldIncrementToJanuary1() {
		// December max boundary area: max+1
		DateUtil date = new DateUtil(31, 12, 2024);
		System.out.println("december31ShouldIncrementToJanuary1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxDecember31ShouldDecrementToDecember30() {
		// December max boundary area: max-1
		DateUtil date = new DateUtil(31, 12, 2024);
		System.out.println("december31ShouldDecrementToDecember30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testNominalDecember() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
		DateUtil date = new DateUtil(rand_day_1_to_31, 12, 2024);
		System.out.println("testDecemberNominal > " + date);
		date.increment();
		System.out.println(date);
	}

	@Test
	public void testMinDecember1ShouldIncrementToDecember2() {
		// December min boundary area: min+1
		DateUtil date = new DateUtil(1, 12, 2024);
		System.out.println("december1ShouldIncrementToDecember2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMinDecember1ShouldDecrementToNovember30() {
		// December min boundary area: min-1
		DateUtil date = new DateUtil(1, 12, 2024);
		System.out.println("december1ShouldDecrementToNovember30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(11, date.getMonth());
	}

	// Year which is not a leap year

	@Test
	public void testMaxFebruary28ShouldIncrementToMarch1() {
		// February max boundary area: max+1 (non-leap year)
		DateUtil date = new DateUtil(28, 2, 2023);
		System.out.println("february28ShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(3, date.getMonth()); // March
		Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxFebruary28ShouldDecrementToFebruary27NonLeap() {
		// February max boundary area: max-1 (non-leap year)
		DateUtil date = new DateUtil(28, 2, 2023);
		System.out.println("february28ShouldDecrementToFebruary27 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(27, date.getDay());
		Assert.assertEquals(2, date.getMonth()); // February
	}

	@Test
	public void testNominalFebruaryNonLeap() {
		// February nominal case (non-leap year)
		int rand_day_1_to_28 = 1 + new Random().nextInt(28);
		DateUtil date = new DateUtil(rand_day_1_to_28, 2, 2023);
		System.out.println("testFebruaryNominal > " + date);
		date.increment();
		System.out.println(date);
	}

	@Test
	public void testMinFebruary1ShouldIncrementToFebruary2NonLeap() {
		// February min boundary area: min+1 (non-leap year)
		DateUtil date = new DateUtil(1, 2, 2023);
		System.out.println("february1ShouldIncrementToFebruary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(2, date.getMonth()); // February
	}

	@Test
	public void testMinFebruary1ShouldDecrementToJanuary31NonLeap() {
		// February min boundary area: min-1 (non-leap year)
		DateUtil date = new DateUtil(1, 2, 2023);
		System.out.println("february1ShouldDecrementToJanuary31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(1, date.getMonth()); // January
	}
}