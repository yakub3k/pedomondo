package pl.yakub.book.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.yakub.book.example.PrototypeScope;
import pl.yakub.book.example.SingletonScope;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ExampleService {

    @Inject
    private PrototypeScope prototypeScope;

    @Inject
    private PrototypeScope prototypeScopeSecond;

    @Inject
    private SingletonScope singletonScope;

    @Inject
    private SingletonScope singletonScopeSecond;

    public List<PrototypeScope> getPrototypes() {
        return Arrays.asList(prototypeScope, prototypeScopeSecond);
    }

    public List<SingletonScope> getSingletons() {
        return Arrays.asList(singletonScope, singletonScopeSecond);
    }
}
