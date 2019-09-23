package pl.yakub.book.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private EventType type;
    private String description;

    @Override
    public String toString() {
        return "[" + type + "] " + description;
    }
}
