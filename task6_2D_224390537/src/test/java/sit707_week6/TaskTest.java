package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TaskTest {

    @Test
    public void testGetTaskId() {
        Task task = new Task("T100", "student123", "Title", "Content", "Status");
        Assert.assertEquals("T100", task.getTaskId());
    }

    @Test
    public void testGetStudentId() {
        Task task = new Task("T100", "student123", "Title", "Content", "Status");
        Assert.assertEquals("student123", task.getStudentId());
    }

    @Test
    public void testGetTitle() {
        Task task = new Task("T100", "student123", "My Title", "Content", "Status");
        Assert.assertEquals("My Title", task.getTitle());
    }


    @Test
    public void testGetContent() {
        Task task = new Task("T100", "student123", "Title", "My Content", "Status");
        Assert.assertEquals("My Content", task.getContent());
    }

    @Test
    public void testSetContent() {
        Task task = new Task("T100", "student123", "Title", "Old Content", "Status");
        task.setContent("Updated Content");
        Assert.assertEquals("Updated Content", task.getContent());
    }

    @Test
    public void testGetStatus() {
        Task task = new Task("T100", "student123", "Title", "Content", "In Progress");
        Assert.assertEquals("In Progress", task.getStatus());
    }

    @Test
    public void testSetStatus() {
        Task task = new Task("T100", "student123", "Title", "Content", "Old Status");
        task.setStatus("New Status");
        Assert.assertEquals("New Status", task.getStatus());
    }

    @Test
    public void testAddToChatbox() {
        Task task = new Task("T100", "student123", "Title", "Content", "Status");
        Message msg = new Message("tutor1", "Message 1", java.time.LocalDateTime.now());
        task.addToChatbox(msg);
        List<Message> chatbox = task.getChatbox();
        Assert.assertEquals(1, chatbox.size());
        Assert.assertEquals("Message 1", chatbox.get(0).getMessage());
    }

    @Test
    public void testGetChatboxInitiallyEmpty() {
        Task task = new Task("T100", "student123", "Title", "Content", "Status");
        Assert.assertTrue(task.getChatbox().isEmpty());
    }
}
