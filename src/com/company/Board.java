package com.company;

public class Board {
    private int[][] board;
    private final int height;
    private final int width;

    public Board(int height, int width){
        board = new int[width][height];
        this.height = height;
        this.width = width;
    }

    public Board(int[][] array){
        board = array;
        height = array.length;
        width = array[0].length;
    }

    public void fillBoard(){
        for(int i = 0; i<width; i++){
            for(int j = 0;j<height; j++){
                int random = (int)(Math.random()*2);
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

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }
}
