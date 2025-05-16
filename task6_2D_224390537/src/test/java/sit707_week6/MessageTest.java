package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class MessageTest {

    @Test
    public void testGetMessengerId() {
        Message msg = new Message("tutor1", "Hello", LocalDateTime.now());
        Assert.assertEquals("tutor1", msg.getMessengerId());
    }

    @Test
    public void testGetMessage() {
        Message msg = new Message("tutor1", "Test Message", LocalDateTime.now());
        Assert.assertEquals("Test Message", msg.getMessage());
    }

    @Test
    public void testGetTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        Message msg = new Message("tutor1", "Hello", now);
        Assert.assertEquals(now, msg.getTimestamp());
    }
}
