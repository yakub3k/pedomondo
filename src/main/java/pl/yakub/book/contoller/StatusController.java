package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.bean.StatusBean;

@RestController
@RequestMapping(path = "/system")
public class StatusController {

    @GetMapping("serverStatus")
    public String getServerStatus(){
        return "ok";
    }

    @GetMapping("status")
    public StatusBean getStatus(){
        return new StatusBean("running");
    }
}
