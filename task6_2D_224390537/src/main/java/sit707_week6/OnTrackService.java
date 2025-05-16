package sit707_week6;

import java.time.LocalDateTime;
import java.util.*;

/**
 * A simple implementation of the OnTrack services.
 */
public class OnTrackService {

    private Map<String, Task> tasks = new HashMap<>();
    private Map<String, List<String>> studentTaskMap = new HashMap<>();
    private int taskCounter = 1;

    public List<Task> listTasks(String studentId) {
        List<Task> result = new ArrayList<>();
        if (studentId == null) return result;
        List<String> taskIds = studentTaskMap.get(studentId);
        if (taskIds != null) {
            for (String id : taskIds) {
                Task t = tasks.get(id);
                if (t != null) {
                    result.add(t);
                }
            }
        }
        return result;
    }

    public Task viewTask(String taskId) {
        if (taskId == null) return null;
        return tasks.get(taskId);
    }

    public boolean submitTask(String studentId, String title, String content) {
        if (studentId == null || title == null || content == null) return false;
        String taskId = "T" + (taskCounter++);
        Task t = new Task(taskId, studentId, title, content, "Read For Feedback");
        tasks.put(taskId, t);
        studentTaskMap.computeIfAbsent(studentId, k -> new ArrayList<>()).add(taskId);
        return true;
    }

    public boolean editTask(String studentId, String taskId, String newContent) {
        if (studentId == null || taskId == null || newContent == null) return false;
        Task t = tasks.get(taskId);
        if (t != null && studentId.equals(t.getStudentId())) {
            t.setContent(newContent);
            t.setStatus("Read For Feedback");
            return true;
        }
        return false;
    }

    public boolean changeStatus(String taskId, String status) {
        if (taskId == null || status == null) return false;
        Task t = tasks.get(taskId);
        if (t != null) {
            t.setStatus(status);
            return true;
        }
        return false;
    }

    public boolean resubmitTask(String studentId, String taskId, String newContent) {
        if (studentId == null || taskId == null || newContent == null) return false;
        Task t = tasks.get(taskId);
        if (t != null && studentId.equals(t.getStudentId())) {
            t.setContent(newContent);
            t.setStatus("Read For Feedback");
            return true;
        }
        return false;
    }

    public List<Task> listCompletedTasks(String studentId) {
        List<Task> result = new ArrayList<>();
        for (Task t : listTasks(studentId)) {
            if ("Completed".equalsIgnoreCase(t.getStatus())) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Task> listPendingTasks(String studentId) {
        List<Task> result = new ArrayList<>();
        for (Task t : listTasks(studentId)) {
            if (!"Completed".equalsIgnoreCase(t.getStatus())) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Task> searchTask(String studentId, String query) {
        List<Task> result = new ArrayList<>();
        if (studentId == null || query == null) return result;
        query = query.toLowerCase();
        for (Task t : listTasks(studentId)) {
            if ((t.getTitle() != null && t.getTitle().toLowerCase().contains(query)) ||
                    (t.getContent() != null && t.getContent().toLowerCase().contains(query)) ||
                    (t.getStatus() != null && t.getStatus().toLowerCase().contains(query))) {
                result.add(t);
            }
        }
        return result;
    }

    public void sendMessage(String messengerId, String taskId, String messageContent) {
        if (messengerId == null || taskId == null || messageContent == null) return;
        Task task = tasks.get(taskId);
        if (task != null) {
            Message msg = new Message(messengerId, messageContent, LocalDateTime.now());
            task.addToChatbox(msg);
        }
    }

    public List<Message> getChatHistory(String taskId) {
        if (taskId == null) return new ArrayList<>();
        Task task = tasks.get(taskId);
        if (task == null) return new ArrayList<>();
        List<Message> history = task.getChatbox();
        history.sort(Comparator.comparing(Message::getTimestamp));
        return history;
    }
}