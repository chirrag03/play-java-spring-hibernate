package configs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.Logger;
import play.inject.ApplicationLifecycle;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;

@Singleton
public class Global {

    private static ApplicationContext ctx;
    private final ApplicationLifecycle appLifecycle;

    @Inject
    public Global(ApplicationLifecycle appLifecycle) {
        Logger.info("Starting application: Loading Global Settings");

        ctx = new AnnotationConfigApplicationContext(DataConfig.class, AppConfig.class);
        this.appLifecycle = appLifecycle;


        // When the application starts, register a stop hook with the
        // ApplicationLifecycle object. The code inside the stop hook will
        // be run when the application stops.
        appLifecycle.addStopHook(() -> {
            Logger.info("Stopping application: Shutting Resources opened in Global Settings");
            return CompletableFuture.completedFuture(null);
        });
    }

    public static <A> A getBean(Class<A> clazz) {
        return ctx.getBean(clazz);
    }

}
