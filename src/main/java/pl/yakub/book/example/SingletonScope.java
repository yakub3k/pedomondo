package pl.yakub.book.example;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SingletonScope {
    private Long time;
    private LocalDateTime creationTime;
    private String message = "empty";

    public SingletonScope() {
        time = System.currentTimeMillis();
        creationTime = LocalDateTime.now();
    }

}
