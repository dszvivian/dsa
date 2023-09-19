package com.dsa.recursion;

public class SudokuSolver {

    public static void main(String[] args) {

    }

    static void solve(int[][] board){





    }


    static boolean isSafe(int[][] board,int row,int col,int n){

        //check for Row

        for (int i = 1; i <= 9; i++) {
            if(board[row][i]==n){
                return false;
            }
        }

        //check for Column
        for (int i = 1; i <= 9; i++) {
            if(board[i][col]==n){
                return false;
            }
        }

        //check for 3*3 subArray
        int rStartIndex = row-(row%3);
        int cStartIndex = col-(col%3);

        for (int i = col; i <col+3; i++) {
            if(board[row][i]==n){
                return false;
            }
        }

        for (int i = col; i <col+3; i++) {
            if(board[row+1][i]==n){
                return false;
            }
        }

        for (int i = col; i <col+3; i++) {
            if(board[row+2][i]==n){
                return false;
            }
        }


        return true;
    }


}
