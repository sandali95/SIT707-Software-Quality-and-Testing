package sit707_week6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OnTrackServiceTest {

    private OnTrackService service;

    @Before
    public void setUp() {
        service = new OnTrackService();
    }

    @Test
    public void testListTasks() {
        service.submitTask("student123", "Task 1", "Content 1");
        List<Task> tasks = service.listTasks("student123");
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("student123", tasks.get(0).getStudentId());
    }

    @Test
    public void testListTasksForInvalidStudent() {
        service.submitTask("student123", "Task 1", "Content 1");
        List<Task> tasks = service.listTasks("student11");
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void testViewTask() {
        service.submitTask("student123", "Task 2", "Content 2");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        Task task = service.viewTask(taskId);
        Assert.assertNotNull(task);
        Assert.assertEquals("Task 2", task.getTitle());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testViewTaskInvalidStudent() {
        service.submitTask("student123", "Task 2", "Content 2");
        String taskId = service.listTasks("student1").get(0).getTaskId();
        service.viewTask(taskId);
    }

    @Test
    public void testSubmitTask() {
        boolean result = service.submitTask("student123", "New Task", "Details");
        Assert.assertTrue(result);
    }

    @Test
    public void testEditTask() {
        service.submitTask("student123", "Task 3", "Old Content");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        boolean result = service.editTask("student123", taskId, "Updated Content");
        Assert.assertTrue(result);
        Assert.assertEquals("Updated Content", service.viewTask(taskId).getContent());
    }

    @Test
    public void testChangeStatus() {
        service.submitTask("student123", "Task 4", "Content");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        boolean result = service.changeStatus(taskId, "Need Help");
        Assert.assertTrue(result);
    }

    @Test
    public void testResubmitTask() {
        service.submitTask("student123", "Task 5", "Content");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        boolean result = service.resubmitTask("student123", taskId, "New Submission");
        Assert.assertTrue(result);
        Assert.assertEquals("Read For Feedback", service.viewTask(taskId).getStatus());
    }

    @Test
    public void testListCompletedTasks() {
        service.submitTask("student123", "Task 6", "Content");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        service.changeStatus(taskId, "Completed");
        List<Task> completedTasks = service.listCompletedTasks("student123");
        Assert.assertEquals(1, completedTasks.size());
    }

    @Test
    public void testListPendingTasks() {
        service.submitTask("student123", "Task 7", "Content");
        List<Task> pendingTasks = service.listPendingTasks("student123");
        Assert.assertFalse(pendingTasks.isEmpty());
        Assert.assertNotEquals("Completed", pendingTasks.get(0).getStatus());
    }

    @Test
    public void testSearchTask() {
        service.submitTask("student123", "Quiz 1", "Math");
        service.submitTask("student123", "Assignment", "Science");
        List<Task> searchResults = service.searchTask("student123", "quiz");
        Assert.assertEquals(1, searchResults.size());
    }

    @Test
    public void testSendMessage() {
        service.submitTask("student123", "Task 8", "Content");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        service.sendMessage("tutor1", taskId, "Please fix this");
        List<Message> chat = service.getChatHistory(taskId);
        Assert.assertEquals(1, chat.size());
        Assert.assertEquals("tutor1", chat.get(0).getMessengerId());
    }

    @Test
    public void testGetChatHistory() {
        service.submitTask("student123", "Task 9", "Content");
        String taskId = service.listTasks("student123").get(0).getTaskId();
        service.sendMessage("student123", taskId, "Initial message");
        List<Message> messages = service.getChatHistory(taskId);
        Assert.assertFalse(messages.isEmpty());
        Assert.assertEquals("Initial message", messages.get(0).getMessage());
    }

    @Test
    public void testSubmitTaskWithNullStudentId() {
        boolean result = service.submitTask(null, "Task", "Content");
        Assert.assertFalse(result);
    }

    @Test
    public void testSubmitTaskWithNullTitle() {
        boolean result = service.submitTask("student123", null, "Content");
        Assert.assertFalse(result);
    }

    @Test
    public void testSubmitTaskWithNullContent() {
        boolean result = service.submitTask("student123", "Title", null);
        Assert.assertFalse(result);
    }

    @Test
    public void testEditTaskWithNulls() {
        boolean result = service.editTask(null, null, null);
        Assert.assertFalse(result);
    }

    @Test
    public void testResubmitTaskWithNulls() {
        boolean result = service.resubmitTask(null, null, null);
        Assert.assertFalse(result);
    }

    @Test
    public void testChangeStatusWithNulls() {
        boolean result = service.changeStatus(null, null);
        Assert.assertFalse(result);
    }

    @Test
    public void testSearchTaskWithNulls() {
        List<Task> result = service.searchTask(null, null);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetChatHistoryWithNullTaskId() {
        List<Message> history = service.getChatHistory(null);
        Assert.assertTrue(history.isEmpty());
    }

    @Test
    public void testGetChatHistoryWithInvalidTaskId() {
        List<Message> history = service.getChatHistory("invalid-id");
        Assert.assertTrue(history.isEmpty());
    }
}
