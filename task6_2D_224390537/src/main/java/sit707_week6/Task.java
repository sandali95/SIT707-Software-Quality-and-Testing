package sit707_week6;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Task entity in the OnTrack system.
 */
public class Task {
    private String taskId;
    private String studentId;
    private String title;
    private String content;
    private String status; // e.g., submitted, completed, edited, resubmitted

    private String tutorId;

    private List<Message> chatbox = new ArrayList<>();

    public Task(String taskId, String studentId, String title, String content, String status) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    // Getters
    public String getTaskId() { return taskId; }
    public String getStudentId() { return studentId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getStatus() { return status; }

    public String getTutorId() {return tutorId;}

    public List<Message> getChatbox(){return chatbox;}

    // Setters
    public void setContent(String content) { this.content = content; }
    public void setStatus(String status) { this.status = status; }

    public void  setTutorId(String tutorId) { this.tutorId = tutorId; }

    public void  addToChatbox(Message message) {
        this.chatbox.add(message);
    }

}