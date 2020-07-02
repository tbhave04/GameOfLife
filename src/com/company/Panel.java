package com.company;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

public class Panel extends JPanel {
    private JButton[][] displayBoard;

    public Panel(Board gameBoard){
        setLayout(new GridLayout(gameBoard.getWidth(), gameBoard.getHeight()));
        displayBoard = new JButton[gameBoard.getWidth()][gameBoard.getHeight()];
        int[][] board = gameBoard.getBoard();

        for(int i = 0; i < gameBoard.getWidth(); i++) {
            for (int j = 0; j < gameBoard.getHeight(); j++) {
                displayBoard[i][j] = new JButton();
                if (board[i][j] == 0) {
                    displayBoard[i][j].setBackground(Color.black);
                } else {
                    displayBoard[i][j].setBackground(Color.white);
                }
                displayBoard[i][j].setEnabled(false);
                add(displayBoard[i][j]);
            }
        }
    }
}
