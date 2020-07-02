package com.company;

import java.lang.reflect.Array;

public class Board {
    private int[][] board;
    private final int height;
    private final int width;
    public Board(int height, int width){
        board = new int[width][height];
        this.height = height;
        this.width = width;
    }

    public void fillBoard(){
        for(int i = 0; i<height; i++){
            for(int j = 0;j<width; j++){
                int random = (int)Math.random();
                board[i][j] = random;
            }
        }
    }

    public int[][] getBoard(){
        return board;
    }

    public int getState(int x, int y){
        return board[x][y];
    }

    public void setState(int x, int y, int val){
        board[x][y] = val;
    }
}
