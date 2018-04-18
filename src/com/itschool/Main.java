package com.itschool;

import java.util.Random;

public class Main {

    public static void ShowField(int[][] field, int n) {
        System.out.println("\n\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + field[i][j]);
            }
            System.out.println();
        }
    }

    public static void NextMove(int[][] field, int n, int m) {
        Random r = new Random();
        int moveX, moveY;

        while (field[moveX = r.nextInt(3)][moveY = r.nextInt(3)] != 0) {
            moveX = r.nextInt(3);
            moveY = r.nextInt(3);
        }

        field[moveX][moveY] = m;
    }

    public static boolean CheckVictory(int[][] field, int n, int m) {
        boolean isVictory = false;

        for (int i = 0; i < n; i++) {
            if (field[i][0] == m && field[i][1] == m && field[i][2] == m) {
                isVictory = true;
                break;
            }
        }

        return isVictory;
    }

    public static void main(String[] args) {
        final int n = 3;
        int[][] field = new int[3][3];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                field[i][j] = 0;

        ShowField(field, n);

        for (int i = 0; i < 9; i++) {
            NextMove(field, n, i % 2 + 1);
            ShowField(field, n);
            if (CheckVictory(field, n, i % 2 + 1)) {
                System.out.println("Winner is " + (i % 2 + 1));
                break;
            }
        }


        // write your code here
    }
}
