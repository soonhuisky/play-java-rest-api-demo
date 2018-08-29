package apple.module;

import apple.service.AppleService;
import apple.service.AppleServiceImpl;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(AppleService.class).to(AppleServiceImpl.class).asEagerSingleton();
    }
}
