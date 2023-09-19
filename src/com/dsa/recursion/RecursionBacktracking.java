package com.dsa.recursion;

public class RecursionBacktracking {

    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];

        boolean[][] board2 = {
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false}
        };

     NKnights(board,0,0,4);





    }

    //region NQueens

    static int NQueens(int row,boolean[][] board){

        if(row==board.length) {
            nQueensDisplay(board);
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if(nQueensIsSafe(board,row,col)){
                board[row][col]= true;//placing a Queen
                count+=NQueens(row+1,board);
                board[row][col]=false;
            }
        }

        return count;
    }

    private static boolean nQueensIsSafe(boolean[][] board, int row, int col) {

        //Check for Vertical
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        int leftMax = Math.min(row,col);
        for (int i = 1; i <=leftMax; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        int rightMax = Math.min(row, board.length-col-1);
        for (int i = 1; i <=rightMax; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;

    }

    private static void nQueensDisplay(boolean[][] maze) {
        for(boolean[] row:maze){
            for(boolean position:row){
                if(position){
                    System.out.print("Q");
                }else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //endregion NQueens

    static void NKnights(boolean[][] board,int row,int col,int target){

        if(target== 0){
            nKnightsDisplay(board);
            return;
        }

        if(row== board.length-1 && col== board.length){
            return;
        }

        if(col== board.length){
            NKnights(board,row+1,0,target);
            return;
        }

        if(nKnightsIsSafe(board, row, col)){
            board[row][col] = true;
            NKnights(board, row, col+1, target-1);
            board[row][col] = false;
        }

        NKnights(board, row, col+1, target);
    }

    private static void nKnightsDisplay(boolean[][] maze) {
        for(boolean[] row:maze){
            for(boolean position:row){
                if(position){
                    System.out.print("K");
                }else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean nKnightsIsSafe(boolean[][] board, int row, int col) {

        //check all Four conditions individually
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }

        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        return true;
    }

    static boolean isValid(boolean[][] board,int row,int col){
        //check if its out of bound
        if(row>=0 && col>=0 && row< board.length && col< board.length ){
            return true;
        }

        return false;
    }








}
