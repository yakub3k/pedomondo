package pl.yakub.book.example;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PrototypeScope {
    private Long time;
    private LocalDateTime creationTime;
    private String message = "empty";

    public PrototypeScope() {
        time = System.currentTimeMillis();
        creationTime = LocalDateTime.now();
    }
}
