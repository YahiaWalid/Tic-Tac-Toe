package com.company;

public class TTT {
    //declaring rows and columns as constants
    static final private int ROWS = 6;
    static final private int COLUMNS = 7;

    //string of X or O or empty inputs
    String[][] boxes = new String[ROWS][COLUMNS];

    //function initializes all boxes to be empty.
    public void emptyBoxes(){
        for(int i=0; i<ROWS; i++)
            for(int j=0; j<COLUMNS; j++)
                boxes[i][j]="   ";// X or O will be placed in the middle space
        // between two other spaces.
    }


    //function prints the layout of the game (boarders-columns-rows)
    public void printBoxes(){

        String layout=new String(); //string containing all layout characters

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if( j!= COLUMNS -1)
                    layout+= boxes[i][j] + "|";
            else{
            layout+=boxes[i][j];
            }
            }
            if(i != ROWS-1)
                layout+= "\n---+---+---+---+---+---+---\n";
        }
        System.out.println(layout+"\n");
    }


    //inserts input in boxes
    public boolean playTurn(int i, int j, String input){

        if(this.boxes[i][j] == "   ") {

            boxes[i][j] = " " + input + " ";
            return true;
        }
        else
        {
            System.out.println("This box is already ticked off\n\n please another input");
            return false;
        }


    }


    //checking if game is over
    public boolean isGameOver(String input){


        int i,j;

        //Checking rows
        for( i=0;i<ROWS;i++){
            for( j=0;j<COLUMNS-2;j++)
                if ((boxes[i][j].equals(" "+input+" ")  ) && (boxes[i][j].equals(boxes[i][j+1]) ) && (boxes[i][j+1].equals( boxes[i][j+2])))
                    return true;
        }

        //checking columns
        for( j=0;j<COLUMNS;j++){
            for( i=0;i<ROWS-2;i++)
                if ((boxes[i][j].equals(" "+input+" ")  ) && (boxes[i][j].equals(boxes[i+1][j]) ) && (boxes[i+1][j].equals( boxes[i+2][j])))
                    return true;
        }

        //checking main diagonals
        for(i=0;i<ROWS-2;i++)
            for(j=0;j<COLUMNS-2;j++)
                if( (boxes[i][j].equals(" "+input+" ")  ) &&  (boxes[i][j].equals(boxes[i+1][j+1])) && (boxes[i+1][j+1].equals(boxes[i+2][j+2])))
                    return true;

        //checking other diagonals
        for(i=2;i<ROWS;i++)
            for(j=0;j<COLUMNS-2;j++)
                if((boxes[i][j].equals(" "+input+" ")) && (boxes[i][j].equals(boxes[i-1][j+1])) && (boxes[i][j].equals(boxes[i-2][j+2])))
                    return true;


        return false;
    }


    public boolean isDraw(){

        int i,j;
        for(i=0;i<ROWS;i++)
            for(j=0;j<COLUMNS;j++)
                if(boxes[i][j].equals("   "))
                    return false;

        return true;

    }
}

