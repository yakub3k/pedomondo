package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/serverStatus")
    public String getServerStatus(){
        return "ok";
    }
}
