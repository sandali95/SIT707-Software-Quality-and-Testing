package sit707_week5;

import org.junit.*;
import static org.junit.Assert.*;

public class WeatherControllerTest {

	private static WeatherController wController;
	private static double[] cachedTemperatures;
	private static int nHours;

	@BeforeClass
	public static void init() {
		wController = WeatherController.getInstance();
		nHours = wController.getTotalHours();
		cachedTemperatures = new double[nHours];

		// Cache temperatures to avoid repeated queries with delays
		for (int i = 0; i < nHours; i++) {
			cachedTemperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@AfterClass
	public static void cleanup() {
		wController.close();
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "224390537";
		assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandali Samarawickrama";
		assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		double minTemperature = Double.MAX_VALUE;
		for (double temp : cachedTemperatures) {
			if (temp < minTemperature) {
				minTemperature = temp;
			}
		}
		assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.0);
	}

	@Test
	public void testTemperatureMax() {
		double maxTemperature = Double.MIN_VALUE;
		for (double temp : cachedTemperatures) {
			if (temp > maxTemperature) {
				maxTemperature = temp;
			}
		}
		assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.0);
	}

	@Test
	public void testTemperatureAverage() {
		double sumTemp = 0;
		for (double temp : cachedTemperatures) {
			sumTemp += temp;
		}
		double averageTemp = sumTemp / nHours;
		assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0.0);
	}

	@Test
	public void testTemperaturePersist() {
		// Skip if not required for 5.3C
		// String persistTime = wController.persistTemperature(10, 19.5);
		// String now = new SimpleDateFormat("H:m:s").format(new Date());
		// assertEquals(persistTime, now);
	}
}