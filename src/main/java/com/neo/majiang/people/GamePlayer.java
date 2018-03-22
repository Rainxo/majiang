package com.neo.majiang.people;

import com.neo.majiang.room.Room;

/**
 * Created by luoyulin1 on 2018/2/7.
 */
public class GamePlayer {


    private int[] handValue = new int[Room.HAND_LENGTH];

    private Integer[][] matrix =  {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private Integer[][] pondMatrix = {{4, 4, 4, 4, 4, 4, 4, 4, 4}, {4, 4, 4, 4, 4, 4, 4, 4, 4}, {4, 4, 4, 4, 4, 4, 4, 4, 4}};
    private int que = -1;

    /**
     * 构造函数
     *
     * @param handValue
     */
    public GamePlayer(int[] handValue) {
        this.handValue = handValue;
        //初始化矩阵
        initMatrix();
        //初始化池子
        initPond();

        opt(0, 0, matrix[0], 0);
    }

    public void out(int v) {

    }

    public void in(int v) {

    }

    private void printArr(Integer [] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }

    private void printMatrix() {
        System.out.println("矩阵图");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void opt(int row,Integer index, Integer[] now, Integer fictitiousSize) {

        findjiang(row, index, now);
        //

        /**
         *0 2 2 0 0 0 0 0 0
         *将 f=2  0 2 2 0 0 0 0 0 0  index 1
         *搭 f=1  0 1 1 0 0 0 0 0 0  index 1
         *坎 f=3  0 2 2 0 0 0 0 0 0  index 1
         *杠 f=4  0 2 2 0 0 0 0 0 0  index 1
         *过 f=0  0 2 2 0 0 0 0 0 0  index 1
         *
         *
         *
         *
         *
         *
         *
         */

    }

    private int findjiang(int row,Integer index, Integer[] hand) {
        int card = (row + 1) * 10 + (index + 1);
        switch (hand[index]) {
            case 0:
                if (findMaxChance(card) > 1) {
                    return 2;
                }
                return -1;
            case 1:
            if (findMaxChance(card) > 0) {
                    return 1;
                }
                return -1;
            case 2:
                hand[index] = 0;
                return 0;
            case 3:
                hand[index] = 1;
                return 0;
            case 4:
                hand[index] = 2;
               return 0;
        }
        return -1;
    }


    private void findDa() {

    }


    private void findKan() {

    }

    private void findGang() {

    }

    private void initMatrix() {
        for (int i = 0; i < handValue.length; i++) {
            toMatrix(handValue[i]);
        }
        printMatrix();
    }

    private void initPond() {
        for (int i = 0; i < handValue.length; i++) {
            pond(handValue[i]);
        }
    }

    public void pond(int card) {
        pondMatrix[card / 10 - 1][card % 10 - 1] -= 1;
    }

    public void toMatrix(int card) {
        matrix[card / 10 - 1][card % 10 - 1] += 1;
    }

    private int findMaxChance(int card) {
        return pondMatrix[card / 10 - 1][card % 10 - 1];
    }
}


