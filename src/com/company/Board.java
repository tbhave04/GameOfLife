package com.company;

/**
 * Holds game state
 */
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
        height = array.length;
        width = array[0].length;
        board = new int[height][width];
        for(int i = 0; i < height; i++){
            System.arraycopy(array[i], 0, board[i], 0, width);
        }
    }

    /**
     * Fills board with random 0's and 1's
     */
    public void fillBoard(){
        for(int i = 0; i<width; i++){
            for(int j = 0;j<height; j++){
                int random = (int)(Math.random()*2);
                board[i][j] = random;
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] getBoard(){
        return board;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }
}
