package com.company;
import java.util.*;

public class Main {

    public static void displayGrid(String[][] newGrid){

        //Print 2 lines which labels the coloums on the grid so the user knows where to enter there checker
        System.out.println(" 0 1 2 3 4 5 6 7 8 9 ");
        //2 for loops will go through the array and print the grid out, first printing the line for the 5 rows and then going through each coloum
        for (int i = 0; i < newGrid.length; i++){
            System.out.print("|");
            for (int j = 0; j < newGrid[0].length; j++){
                System.out.print(newGrid[i][j]);
                System.out.print("|");
            }
            System.out.println("\n");
        }
    }

    public static void playerDrop(String[][] newGrid, int number, String playerSymbol) {
        //Goes through the grid to the column selected and then checks for the first empty space and places the checker in
        for (int i = newGrid.length - 1; i >= 0; i--) {
            if(newGrid[i][number] == " "){
                newGrid[i][number] = playerSymbol;
                break;
            }
        }
    }

    public static boolean isWinner(String[][] newGrid, String player){

        //using 2 loops, it goes through the grid and checks if there are 4 consistent spaces going horizontally that have the same player and returns if they won
        for(int i = 0; i < newGrid.length; i++){
            for(int j = 0; j < newGrid[0].length - 3; j++){
                if (newGrid[i][j] != " " && newGrid[i][j+1] != " " && newGrid[i][j+2] != " " && newGrid[i][j+3] != " "
                        && newGrid[i][j] == player && newGrid[i][j+1] == player && newGrid[i][j+2] == player && newGrid[i][j+3] == player) {
                    return true;
                }
            }
        }
        //using 2 for loops, it goes through the Grid and checks if there are 4 consistent spaces going vertically with the same player and returns if they won
        for(int i = 0; i<newGrid.length - 3; i++){
            for (int j = 0; j < newGrid[0].length; j++){
                if (newGrid[i][j] != " " && newGrid[i+1][j] != " " && newGrid[i+2][j] != " " && newGrid[i+3][j] != " "
                    && newGrid[i][j] == player && newGrid[i+1][j] == player && newGrid[i+2][j] == player && newGrid[i+3][j] == player) {
                    return true;
                }
            }
        }

        //using 2 for loops, it goes through the Grid and checks if there are 4 consistent spaces going diagonal upwards with the same player and returns if they won
        for(int i = 3; i < newGrid.length; i++){
            for(int j = 0; j < newGrid[0].length - 3; j++){
                if (newGrid[i][j] != " " && newGrid[i-1][j+1] != " " && newGrid[i-2][j+2] != " " && newGrid[i-3][j+3] != " "
                        && newGrid[i][j] == player && newGrid[i-1][j+1] == player && newGrid[i-2][j+2] == player && newGrid[i-3][j+3] == player) {
                    return true;
                }
            }
        }
        //using 2 for loops, it goes through the Grid and checks if there are 4 consistent spaces going down vertically with the same player and returns if they won
        for(int i = 0; i < newGrid.length - 3; i++){
            for(int j = 0; j < newGrid[0].length - 3; j++){
                if (newGrid[i][j] != " " && newGrid[i+1][j+1] != " " && newGrid[i+2][j+2] != " " && newGrid[i+3][j+3] != " " &&
                        newGrid[i][j] == player && newGrid[i+1][j+1] == player && newGrid[i+2][j+2] == player && newGrid[i+3][j+3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int totalCounter = 1;
        String player = "O";
        boolean winner = false;

        String[][] newGrid = new String[5][10];

        for (int i = 0; i < newGrid.length; i++){
            for (int j = 0; j < newGrid[0].length; j++){
                newGrid[i][j] = " ";
            }
        }

        //play a turn
        while (!winner) {
            int play = 0;
            Scanner number = new Scanner(System.in);
            //display the grid in terminal
            displayGrid(newGrid);
            //ask user for choice and store the number
            System.out.print("Player " + player + ", choose a column: ");
            play = number.nextInt();
            //send information to playerDrop method so it can insert the checker
            playerDrop(newGrid, play, player);
            //after every turn check if anyone has won which means winner will equal true
            winner = isWinner(newGrid, player);
            //alternate between the players turns
            if (player == "O") {
                player = "X";
            }else {
                player = "O";
            }
            totalCounter++;
        }

        displayGrid(newGrid);

        //Prints information for the user who won so they know
        if (player == "X"){
            System.out.println("O won");
        }else if (player == "O"){
            System.out.println("X won");
        }else{
            System.out.println("Tie game");
        }
    }
}
