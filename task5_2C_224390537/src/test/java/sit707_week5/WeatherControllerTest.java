package sit707_week5;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class WeatherControllerTest {

    private static WeatherController wController;

    private static Instant fixedInstant;



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

    @BeforeClass
    public static void init() {
        // Arrange: fixed instant
        fixedInstant = Instant.parse("2023-01-01T10:15:30Z");
        Clock fixedClock = Clock.fixed(fixedInstant, ZoneId.systemDefault());
        wController = WeatherController.getInstance(fixedClock);
    }

    @AfterClass
    public static void cleanup() {
        wController.close();
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Expected time
        String expectedTime = new SimpleDateFormat("H:m:s").format(Date.from(fixedInstant));

        // Act
        String persistTime = wController.persistTemperature(10, 19.5);

        // Assert
        Assert.assertEquals(expectedTime, persistTime);

    }

}
