package com.m1nist3r.dormitory.desktop.application.javafx;

import com.m1nist3r.dormitory.desktop.application.ApplicationForManagingDormitoryApplication;
import com.m1nist3r.dormitory.desktop.application.javafx.event.StageReadyEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {

        ApplicationContextInitializer<GenericApplicationContext> initializer =
                genericApplicationContext -> {
                    genericApplicationContext.registerBean(Application.class, () -> this);
                    genericApplicationContext.registerBean(Parameters.class, this::getParameters);
                };

        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(ApplicationForManagingDormitoryApplication.class)
                .initializers(initializer)
                .run(args);
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) {
        this.applicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }

}
