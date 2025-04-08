package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(3));
	}

	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}
	
    @Test
    public void testCancelWeatherAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

	@Test
	public void testDangerousRainfallOnly() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
	}

	@Test
	public void testConcerningWindAndRain() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
	}

	@Test
	public void testOnlyConcerningWind() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 0.0));
	}

	@Test
	public void testOnlyConcerningRain() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 5.0));
	}

	@Test
	public void testAllClearAdvice() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 2.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWeatherAdviceWithNegativeInputs() {
		WeatherAndMathUtils.weatherAdvice(-1.0, 0.0);
	}

	@Test
	public void testFalseIsPrime(){
		Assert.assertFalse(WeatherAndMathUtils.isPrime(66));
	}

	@Test
	public void testTrueIsPrime(){
		Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
	}

	@Test
	public void testN1IsPrime(){
		Assert.assertTrue((WeatherAndMathUtils.isPrime(1)));
	}
}
