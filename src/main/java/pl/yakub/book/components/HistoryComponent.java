package pl.yakub.book.components;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.yakub.book.event.Event;
import pl.yakub.book.event.EventType;

import java.util.ArrayList;
import java.util.List;

@Component()
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HistoryComponent {

    private List<Event> events = new ArrayList<>();


    public List<Event> getEvents() {
        return events;
    }

    public void appendEventAdd(String description) {
        this.events.add(new Event(EventType.ADD, description));
    }

    public void appendEventDelete(String description) {
        this.events.add(new Event(EventType.DELETE, description));
    }
}
