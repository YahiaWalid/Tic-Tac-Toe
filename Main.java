package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TTT t = new TTT();
        String input = "X";

        t.emptyBoxes();
        // Greeting the player
        System.out.println("Welcome to the game");
        System.out.println("X will start first \n");
        while(true){

            t.printBoxes();

            System.out.println("Enter number of row from 1 to 6 :");
            int row=sc.nextInt()-1;


            System.out.println("Enter number of column from 1 to 7 :");
            int col=sc.nextInt()-1;
            System.out.println("\n\n****************\n\n");


            boolean isInputValid=t.playTurn(row, col, input);


            if(t.isGameOver(input)){
                t.printBoxes();
                System.out.println(input+" wins !");
                break;
            }


            if(t.isDraw()){
                System.out.println("This game ends in a draw.");
                break;
            }

            if( input == "X"&& isInputValid )
                input="O";
            else if (input == "O"&& isInputValid)
                input="X";
        }


    }


}

