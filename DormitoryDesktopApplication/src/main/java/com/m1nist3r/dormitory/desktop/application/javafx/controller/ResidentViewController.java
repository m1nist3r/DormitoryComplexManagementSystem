package com.m1nist3r.dormitory.desktop.application.javafx.controller;

import com.m1nist3r.dormitory.desktop.application.javafx.model.Resident;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class ResidentViewController {
    @FXML
    private Button editButton;
    @FXML
    private Label searchLabel;
    @FXML
    private TextField searchTextField;
    @FXML
    private TableView<Resident> residentTableView;

    @FXML
    public void initialize() {

    }

    @FXML
    public void performSearch() {

    }

}
