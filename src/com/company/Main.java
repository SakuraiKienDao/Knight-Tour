package com.company;

import java.util.Scanner;

public class Main {
    static int size=8;
    static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int boad[][]= new int[8][8];

    static void printSov(int boad[][]){
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++)
                System.out.print(boad[x][y] + " ");
            System.out.println();
        }
    }
    static boolean isSafe(int x, int y){
        return (x >= 0 && x < size && y >= 0 && y < size && boad[x][y]==0);
    }

    static boolean kMove(int x,int y,int moveTotal, int xMove[], int yMove[]  ){
        if(moveTotal== size*size) {
            return true;
        }
            for(int i = 0; i<size;i++){
                int nextX = x+ xMove[i];
                int nextY = y+ yMove[i];
                if(isSafe(nextX,nextY)){
                    boad[nextX][nextY]= moveTotal;
                    if(kMove(nextX,nextY,moveTotal+1,xMove,yMove)){
                        return true;
                    }else boad[nextX][nextY]=0;

                }
            }

        return false;
    }

    static boolean SolveK(){
        Scanner myObj = new Scanner(System.in);
        System.out.print("FirstX:");
        int X = myObj.nextInt();
        System.out.print("FirstY:");
        int Y = myObj.nextInt();

        boad[X][Y]=1;
        if(kMove(X,Y,1,xMove,yMove)){
            printSov(boad);
        }else System.out.println("Erro");

        return true;
    }

    public static void main(String[] args) {
	SolveK();
    }
}
