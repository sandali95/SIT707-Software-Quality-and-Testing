package sit707_week6;

import java.time.LocalDateTime;

public class Message {

    private String messengerId;
    private String message;
    private LocalDateTime timestamp;

    public Message(String messengerId,String message, LocalDateTime timestamp) {
        this.messengerId = messengerId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public  String getMessengerId() { return messengerId; }
}