package pl.yakub.book.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.yakub.book.example.PrototypeScope;
import pl.yakub.book.example.SingletonScope;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "example")
public class ExampleController {

    private final PrototypeScope prototypeScope;

    private final PrototypeScope prototypeScopeSecond;

    private final SingletonScope singletonScope;

    private final SingletonScope singletonScopeSecond;


    public ExampleController(PrototypeScope prototypeScope,
                             PrototypeScope prototypeScopeSecond, SingletonScope singletonScope, SingletonScope singletonScopeSecond) {
        this.prototypeScope = prototypeScope;
        this.prototypeScopeSecond = prototypeScopeSecond;
        this.singletonScope = singletonScope;
        this.singletonScopeSecond = singletonScopeSecond;
    }

    @GetMapping(path = "singleton")
    public List<SingletonScope> getSingleton() {
        singletonScope.setMessage("singleton");
        return Arrays.asList(singletonScope, singletonScopeSecond);
    }

    @GetMapping(path = "prototype")
    public List<PrototypeScope> getPrototype() {
        prototypeScope.setMessage("prototypeScope");
        return Arrays.asList(prototypeScope, prototypeScopeSecond);
    }

    @PostMapping(path = "post")
    public String checkPostMethod() {
        return "post";
    }

    @GetMapping(path = "get")
    public String checkGetMethod() {
        return "get";
    }
}
