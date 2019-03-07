package com.itschool;

import java.util.Random;

public class Main {

    public static void ShowField(int[][] field, int n) {
        System.out.println("\n\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + (field[i][j] == 0 ? " " : (field[i][j] == 1 ? "X" : "O")));
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
                return true;
            }
        }
        for (int i = 0; i < n; i++)
        {
            if (field[0][i] == m && field[1][i] == m && field[2][i] == m)
            {
                return true;
            }
        }
        int i = 0;
        for (i = 0; i < n - 1; i++)
        {
            if (field[i][i] == 0 || field[i][i] != field[i + 1][i + 1])
            {
                break;
            }
        }
        if (i == 2)
        {
            return true;
        }

        for (i = 0; i < n - 1; i++)
        {
            if (field[i][i] == 0 || field[i][n - i - 1] != field[i + 1][n - 1 - i - 1])
            {
                break;
            }
        }

        if (i == 2)
        {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        final int n = 3;
        int[][] field = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                field[i][j] = 0;

        ShowField(field, n);

        for (int i = 0; i < n * n; i++)
        {
            NextMove(field, n, i % 2 + 1);
            ShowField(field, n);
            if (CheckVictory(field, n, i % 2 + 1))
            {
                System.out.println("Winner is " + ((i % 2 + 1) == 1 ? "X" : "0"));
                return;
            }
        }

        System.out.println("Draw");
    }
}
