package com.m1nist3r.dormitory.desktop.application;

import com.m1nist3r.dormitory.desktop.application.javafx.JavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationForManagingDormitoryApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }

}
