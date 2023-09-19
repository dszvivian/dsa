package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionMaze {

    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };

        int[][] matrix = {
                {-1,-1,-1},
                {-1,-1,-1},
                {-1,-1,-1}
        };
        System.out.println(Arrays.toString(allPathsMatrix(0,0,maze,matrix,0,"").toArray()));

    }

    /*
    start:1,1 target:3,3
    At each it can either move Right or Down one step*/
    static int q1(int row,int col){
        if(row==3||col==3){
            return 1;
        }
        return q1(row+1,col) + q1(row,col+1);
    }

    //Path: ---> MyApproach
    static ArrayList<String> q1Path(int row,int col,String p){

        if(row==3||col==3){
            ArrayList<String> list = new ArrayList<>();
            StringBuilder newP = new StringBuilder();
            newP.append(p);

            while(row!=3){
                newP.append("D");
                row++;
            }

            while(col!=3){
                newP.append("R");
                col++;
            }

            list.add(newP.toString());


            return list;
        }

        ArrayList<String> ans= new ArrayList<>();
        ans.addAll(q1Path(row+1,col,p+"D"));
        ans.addAll(q1Path(row, col+1,p+"R"));

        return ans;
    }


    //Path--> Kunal's Approach
    static ArrayList<String> q1Path2(int row,int col,String p){

        if(row==3&&col==3){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans= new ArrayList<>();

        if(col<3){
            ans.addAll(q1Path2(row, col+1,p+"R"));
        }
        if(row<3){
            ans.addAll(q1Path2(row+1,col,p+"D"));
        }

        return ans;
    }

    static ArrayList<String> q1PathDiagonal(int row,int col,String p){

        if(row==3&&col==3){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans= new ArrayList<>();

        if(col<3){
            ans.addAll(q1PathDiagonal(row, col+1,p+"H"));
        }
        if(row<3 && col<3){
            ans.addAll(q1PathDiagonal(row+1, col+1,p+"D"));
        }
        if(row<3){
            ans.addAll(q1PathDiagonal(row+1,col,p+"V"));
        }

        return ans;
    }

    /*
    Maze with Obstacles
    In this Case: 1,1 is a obstacle, Given maze array as Input
    cells from ---> 0..2
    */
    static ArrayList<String> q1WithObstacles2(int row,int col,boolean[][] maze,String p){

        if(row== maze.length-1 && col==maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        //Obstacle
        if(!maze[row][col]){
            return new ArrayList<>();
        }

        ArrayList<String> ans = new ArrayList<>();

        if(row< maze.length-1){
            ans.addAll(q1WithObstacles2(row+1,col,maze,p+"D"));
        }

        if(col< maze[0].length-1){
            ans.addAll(q1WithObstacles2(row,col+1,maze,p+"R"));
        }

        return ans;
    }

    /*
    Maze with Obstacles
    In this Case: 2,2 is a obstacle
    */
    static ArrayList<String> q1WithObstacles(int row,int col,String p){

        if(row==3 && col==3){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        if(row==2  && col==2){
            return new ArrayList<>();
        }

        ArrayList<String> ans = new ArrayList<>();

        if(row<3){
            ans.addAll(q1WithObstacles(row+1,col,p+"D"));
        }

        if(col<3){
            ans.addAll(q1WithObstacles(row,col+1,p+"R"));
        }


        return ans;

    }


    //BackTracking
    static ArrayList<String> allPaths(int row,int col,boolean[][] maze,String p){

        if(row== maze.length-1 && col==maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        //Obstacle
        if(!maze[row][col]){
            return new ArrayList<>();
        }

        maze[row][col]=false;

        ArrayList<String> ans = new ArrayList<>();

        if(row< maze.length-1){
            ans.addAll(allPaths(row+1,col,maze,p+"D"));
        }

        if(col< maze[0].length-1){
            ans.addAll(allPaths(row,col+1,maze,p+"R"));
        }

        if(row>0){
            ans.addAll(allPaths(row-1,col,maze,p+"U"));
        }

        if(col>0){
            ans.addAll(allPaths(row,col-1,maze,p+"L"));
        }

        maze[row][col]=true;

        return ans;
    }


    //Path with Matrix
    static ArrayList<String> allPathsMatrix(int row,int col,boolean[][] maze,int[][] matrix,int step,String p){

        if(row== maze.length-1 && col==maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);

            System.out.println(p);
            matrix[row][col] = step;
            for(int[] arr:matrix){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            System.out.println();

            return list;
        }

        //Obstacle
        if(!maze[row][col]){
            return new ArrayList<>();
        }

        maze[row][col]=false;

        ArrayList<String> ans = new ArrayList<>();
        matrix[row][col] = step;

        if(row< maze.length-1){
            ans.addAll(allPathsMatrix(row+1,col,maze,matrix,step+1,p+"D"));
        }

        if(col< maze[0].length-1){
            ans.addAll(allPathsMatrix(row,col+1,maze,matrix,step+1,p+"R"));
        }

        if(row>0){
            ans.addAll(allPathsMatrix(row-1,col,maze,matrix,step+1,p+"U"));
        }

        if(col>0){
            ans.addAll(allPathsMatrix(row,col-1,maze,matrix,step+1,p+"L"));
        }

        maze[row][col]=true;
        matrix[row][col] = -1;
        return ans;
    }

}
