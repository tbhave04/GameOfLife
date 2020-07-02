package com.company;

import javax.swing.JFrame;

public class BoardView {
    public void printBoard(Board board) {
        JFrame frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocation(0, 0);
        frame.setContentPane(new Panel(board));
        frame.setVisible(true);
    }
}

