package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(30,30);
        board.fillBoard();

        BoardView view = new BoardView();
        view.printBoard(board);
    }
}
