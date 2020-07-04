package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(30,30);
        board.fillBoard();
        BoardView view = new BoardView();
        view.printBoard(board);

        while(true){
            board = updateBoard(board);
            view.printBoard(board);
        }

    }

    private static Board updateBoard(Board board){
        int width = board.getWidth();
        int height = board.getHeight();

        int [][] updated = new int[width][height];
        int [][] values = board.getBoard();
        int [][] directions = {{-1,-1}, {0,-1}, {1, -1},
                                {-1,0}, {1,0},
                                {-1, 1}, {0,1}, {1, 1}};

        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int totalOnes = 0;

                for (int[] direction : directions) {
                    int x = direction[0] + i;
                    int y = direction[1] + j;

                    if(x >= 0 && x < width && y >=0 && y < height){
                        totalOnes += values[x][y];
                    }
                }

                // updating board

                if(totalOnes <= 2 && values[i][j] == 1){
                    updated[i][j] = 0;
                }
                else if(totalOnes <= 4 && values[i][j] == 1){
                    updated[i][j] = 1;
                }
                else if(totalOnes >= 4 && values[i][j] == 1){
                    updated[i][j] = 0;
                }
                else if(totalOnes == 3 && values[i][j] == 0){
                    updated[i][j] = 1;
                }
            }
        }

        Board newBoard = new Board(updated);
        return newBoard;
    }
}
