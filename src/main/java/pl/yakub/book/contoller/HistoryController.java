package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.components.HistoryComponent;
import pl.yakub.book.event.Event;

import javax.inject.Inject;
import java.util.List;

@RestController()
@RequestMapping("/history")
public class HistoryController {

    @Inject
    private HistoryComponent historyController;

    @GetMapping("")
    public List<Event> getHistory() {
        return historyController.getEvents();
    }
}
