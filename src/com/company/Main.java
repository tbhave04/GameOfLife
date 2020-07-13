package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text filename for your board(type -1 for a random board): ");
        String filename = scanner.nextLine();
        Board board = null;

        if(filename.equals("-1")){
            board = new Board(50, 50);
            board.fillBoard();
        }
        else{
            try {
                File file = new File(filename);
                Scanner myReader = new Scanner(file);
                Scanner reader = new Scanner(file);
                int height = 0;
                int width = 0;
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    width = line.length();
                    height++;
                }
                reader.close();
                int[][] array = new int[height][width];
                for (int row = 0; row < height; row++) {
                    String line = myReader.nextLine();
                    for(int col = 0; col < width; col++){
                        array[row][col] = Character.getNumericValue(line.charAt(col));
                    }
                }
                board = new Board(array);
            }
            catch(FileNotFoundException e){
                System.out.println("An error occurred.");
            }
        }

        BoardView view = new BoardView(board);
        while(true){
            JFrame frame = view.getFrame();
            frame.getContentPane().removeAll();
            board = updateBoard(board);
            frame.getContentPane().add(new Panel(board));
            frame.validate();
        }
    }

    /**
     * Updates board
     * @param board current board state
     * @return updated board state
     */
    private static Board updateBoard(Board board){
        int width = board.getWidth();
        int height = board.getHeight();

        int [][] updated = new int[height][width];
        int [][] values = board.getBoard();
        int [][] directions = {{-1,-1}, {0,-1}, {1, -1},
                {-1,0}, {1,0},
                {-1, 1}, {0,1}, {1, 1}};

        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int totalOnes = 0;

                for (int[] direction : directions) {
                    int x = direction[0] + i;
                    int y = direction[1] + j;

                    if(x >= 0 && x < height && y >=0 && y < width){
                        totalOnes += values[x][y];
                    }
                }

                // updating
                updated[i][j] = values[i][j];

                if (values[i][j] == 1) {
                    if (totalOnes == 2 || totalOnes == 3) {
                        updated[i][j] = 1;
                    }
                    else {
                        updated[i][j] = 0;
                    }
                }
                if (values[i][j] == 0) {
                    if (totalOnes == 3) {
                        updated[i][j] = 1;
                    }
                }
            }
        }

        Board newBoard = new Board(updated);
        return newBoard;
    }
}
