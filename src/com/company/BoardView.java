package com.company;

import javax.swing.JFrame;

/**
 * Creates frame to display the board
 */
public class BoardView {
    JFrame frame;
    public BoardView(Board board) {
        frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int avg_board_length = (board.getHeight() + board.getWidth())/2;
        int square_side = (500/avg_board_length);
        frame.setSize(board.getWidth()*square_side,board.getHeight()*square_side);
        frame.setLocation(0, 0);
        frame.setContentPane(new Panel(board));
        frame.setVisible(true);
    }

    public JFrame getFrame(){
       return frame;
    }
}

