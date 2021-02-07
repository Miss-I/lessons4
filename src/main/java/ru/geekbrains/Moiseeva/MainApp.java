package ru.geekbrains.Moiseeva;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    static char DOT_EMPTY = '*';
    static char DOT_AI = '0';
    static char DOT_PLAYER = 'X';

    static int SIZE = 3;
    static char[][] map = new char[SIZE][SIZE];

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        FillMap();
        PrintMap();
        while (true){
            PlayerTurn();
            if (CheckWin(DOT_PLAYER)){
                System.out.println("Вы Победили!");
                break;
            }
            if (IsMapFull()){
                System.out.println("Ничья!");
                break;
            }

            AITurn();
            if(CheckWin(DOT_AI)){
                System.out.println("AI победил!");
                break;
            }
            if (IsMapFull()){
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра завершена!");

    }

    public static boolean CheckWin(char DOT) {
        for (int i = 0; i < SIZE; i++) {
            if (map[i][0] == DOT && map[i][1] == DOT && map[i][2] == DOT) {
                return true;
            } else if (map[0][i] == DOT && map[1][i] == DOT && map[2][i] == DOT) {
                return true;
            } else if (map[0][0] == DOT && map[1][1] == DOT && map[2][2] == DOT) {
                return true;
            } else if (map[0][2] == DOT && map[1][1] == DOT && map[2][0] == DOT) {
                return true;
            }
        }return false;
    }
    public static void FillMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void PrintMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void PlayerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты хода в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!IsCellEmpty(x, y));
        map[x][y] = DOT_PLAYER;
        PrintMap();

    }

    public static void AITurn() {
        int a, b;
        do {
            a = random.nextInt(SIZE);
            b = random.nextInt(SIZE);
        } while (!IsCellEmpty(a, b));
        System.out.printf("Ход AI: [%d, %d]\n", a + 1,  b + 1);
        map[a][b] = DOT_AI;
        PrintMap();

    }

    public static boolean IsCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean IsMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
