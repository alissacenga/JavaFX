package com.example.week3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    // if whoseTurn is Pending that means the game is over
    private CellState whoseTurn = CellState.FIRST_PLAYER;
    private final Cell[][] cells = new Cell[3][3];
    private final GridPane gridPane = new GridPane();
    private final Label gameStatus = new Label(whoseTurn + "'s turn to play");

    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
                gridPane.add(cells[i][j], j, i);
            }
        }
    }

    @Override
    public void start (Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(gameStatus);
        borderPane.setCenter(gridPane);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }
    private class Cell extends StackPane {
        private CellState token = CellState.PENDING;
        public Cell() {
            setStyle("-fx-border-width: 4px; -fx-border-color: black");
            setPrefSize(200, 200);
            setOnMouseClicked(mouseEvent -> handleMouseClick());
        }

        private void handleMouseClick() {
            if (this.token == CellState.PENDING && whoseTurn != CellState.PENDING) {
                setToken(whoseTurn);
                if (isWonBy(token)) {
                    gameStatus.setText(token + " won the game!");
                    // end the game
                    whoseTurn = CellState.PENDING;
                } else if (isDraw()) {
                    gameStatus.setText("Game ended in a draw!");
                    whoseTurn = CellState.PENDING;
                } else {
                    whoseTurn = (whoseTurn == CellState.FIRST_PLAYER ? CellState.SECOND_PLAYER : CellState.FIRST_PLAYER);
                    gameStatus.setText(whoseTurn + "'s turn to play");
                }
            }
        }

        public CellState getToken() {
            return token;
        }

        public void setToken(CellState token) {
            this.token = token;
            if (token == CellState.FIRST_PLAYER)
                drawRectangle();
            else
                drawEllipse();
        }

        private void drawEllipse() {
            Ellipse ellipse = new Ellipse();
            ellipse.setRadiusX(super.getWidth()/4);
            ellipse.setRadiusY(super.getHeight()/4);
            // style it
            ellipse.setFill(Color.WHITE);
            ellipse.setStroke(Color.BLACK);
            getChildren().add(ellipse);
        }

        private void drawRectangle() {

            Line line1 = new Line(getWidth()/2, 5, getWidth()/2, getHeight() - 5);
            line1.setRotate(45);
            Line line2 = new Line(getWidth()/2, 5, getWidth()/2, getHeight() - 5);
            line2.setRotate(-45);
            getChildren().addAll(line1, line2);
        }
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cells[i][j].getToken() == CellState.PENDING)
                    return false;
        return true;
    }

    private boolean isWonBy(CellState token) {
        // check for rows first
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getToken() == token && cells[i][1].getToken() == token && cells[i][2].getToken() == token)
                return true;
        }
        // check for columns
        for (int i = 0; i < 3; i++) {
            if (cells[0][i].getToken() == token && cells[1][i].getToken() == token && cells[2][i].getToken() == token)
                return true;
        }
        // check for the first diagonal
        if (cells[0][0].getToken() == token && cells[1][1].getToken() == token && cells[2][2].getToken() == token)
            return true;
        // check for the other diagonal
        if (cells[0][2].getToken() == token && cells[1][1].getToken() == token && cells[2][0].getToken() == token)
            return true;
        return false;
    }

    private enum CellState {
        FIRST_PLAYER,
        SECOND_PLAYER,
        PENDING
    }
}

