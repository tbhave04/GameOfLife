package com.company;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Draws grid on to frame using buttons
 */
public class Panel extends JPanel {
    private JButton[][] displayBoard;
    int[][] board;
    Board gameBoard;
    public Panel(Board gameBoard){
        this.gameBoard = gameBoard;
        setLayout(new BorderLayout());

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(gameBoard.getHeight(), gameBoard.getWidth()));
        add(center, BorderLayout.CENTER);

        displayBoard = new JButton[gameBoard.getHeight()][gameBoard.getWidth()];
        board = gameBoard.getBoard();

        for(int i = 0; i < gameBoard.getHeight(); i++) {
            for (int j = 0; j < gameBoard.getWidth(); j++) {
                displayBoard[i][j] = new JButton();
                if (board[i][j] == 0) {
                    displayBoard[i][j].setBackground(Color.black);
                } else {
                    displayBoard[i][j].setBackground(Color.white);
                }
                displayBoard[i][j].setEnabled(false);
                center.add(displayBoard[i][j]);
            }
        }
    }
}
