package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    private final TextField annualInterestRate = new TextField();
    private final TextField numberOfYears = new TextField();
    private final TextField loanAmount = new TextField();
    private final TextField monthlyPayment = new TextField();
    private final TextField totalPayment = new TextField();
    private final Button calculateBtn = new Button("Calculate");
    private final Button resetBtn = new Button("Reset");
    @Override
    public void start(Stage stage) {
        monthlyPayment.setEditable(false);
        totalPayment.setEditable(false);
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Annual interest rate"), 0, 0);
        gridPane.add(annualInterestRate, 1, 0);
        gridPane.add(new Label("Number of Years"), 0, 1);
        gridPane.add(numberOfYears, 1, 1);
        gridPane.add(new Label("Loan amount"), 0, 2);
        gridPane.add(loanAmount, 1, 2);
        gridPane.add(new Label("Monthly Payment"), 0, 3);
        gridPane.add(monthlyPayment, 1, 3);
        gridPane.add(new Label("Total Payment"), 0, 4);
        gridPane.add(totalPayment, 1, 4);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15);
        hBox.getChildren().addAll(resetBtn, calculateBtn);
        gridPane.add(hBox, 1, 5);
        gridPane.setAlignment(Pos.CENTER);

        // listen to the click event
        calculateBtn.setOnAction(event -> calculatePayments());
        resetBtn.setOnAction(event -> resetCalculator());
        Scene scene = new Scene(gridPane, 400, 300);
        stage.setTitle("Loan calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void resetCalculator() {
        annualInterestRate.setText("");
        numberOfYears.setText("");
        loanAmount.setText("");
        monthlyPayment.setText("");
        totalPayment.setText("");
    }

    private void calculatePayments() {
        double annualInterest = Double.parseDouble(annualInterestRate.getText());
        int years = Integer.parseInt(numberOfYears.getText());
        double amount = Double.parseDouble(loanAmount.getText());
        Loan loan = new Loan(years, annualInterest, amount);
        monthlyPayment.setText(String.format("%.2f Euro", loan.getMonthlyPayment()));
        totalPayment.setText(String.format("%.2f Euro", loan.getTotalPayment()));
    }
}
