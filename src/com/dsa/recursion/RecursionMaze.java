package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionMaze {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(q1Path2(1,1,"").toArray()));
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

}
