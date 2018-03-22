package com.neo.majiang.people;

import com.neo.majiang.room.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoyulin1 on 2018/2/7.
 */
public class GamePlayer {


    private int[] handValue = new int[Room.HAND_LENGTH];

    private Integer[][] matrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}};
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

        opt(0, 0, matrix[0], "", 0);
        opt(1, 0, matrix[1], "", 0);
        opt(2, 0, matrix[2], "", 0);
        for (String s : re) {
            System.out.println(s);
        }
    }

    public void out(int v) {

    }

    public void in(int v) {

    }

    private void printArr(Integer[] v) {
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
    int min = Integer.MAX_VALUE;
    List<String> re = new ArrayList<>();
    private void opt(int row, Integer index, Integer[] hand, String shape, int fictitious) {
        if (index > 8) {
            if (min > fictitious) {
                min = fictitious;
                re.clear();
                re.add(shape + ":" + fictitious);
            } else if (min == fictitious){
                re.add(shape + ":" + fictitious);
            }
            return;
        }
        Integer[] tempJ = new Integer [9];
        System.arraycopy(hand, 0, tempJ, 0, 9);
        int fj = findjiang(row, index, tempJ);
        if (fj != -1) {
            opt(row, index + 1, tempJ, shape + "_将", fictitious + fj);
        }

        Integer[] tempD = new Integer [9];
        System.arraycopy(hand, 0, tempD, 0, 9);
        int fd = findDa(row, index, tempD);
        if (fd != -1) {
            opt(row, index + 3, tempD, shape + "_搭_搭_搭", fictitious + fd);
        }

        Integer[] tempK = new Integer [9];
        System.arraycopy(hand, 0, tempK, 0, 9);
        int fk = findKan(row, index, tempK);
        if (fk != -1) {
            opt(row, index + 1, tempK, shape + "_坎", fictitious + fk);
        }

        Integer[] tempG = new Integer [9];
        System.arraycopy(hand, 0, tempG, 0, 9);
        int fg = findGang(row, index, tempG);
        if (fg != -1) {
            opt(row, index + 1, tempG, shape + "_杠", fictitious + fg);
        }
        int guo = guo(row, index, hand);
        if (guo != -1) {
            opt(row, index + 1, hand, shape + "_过", fictitious + guo);
        }
    }

    private int findjiang(int row, Integer index, Integer[] hand) {
        int maxChance = findMaxChance(row, index);
        int card = hand[index] - 2;
        if (card >= 0) {
            hand[index] = card;
            return 0;
        } else {
            if (maxChance >= (Math.abs(card))) {
                return Math.abs(card);
            }
            return -1;
        }
    }


    private int findDa(int row, Integer index, Integer[] hand) {
        if (index > 6) {
            return -1;
        }
        int maxChance1 = findMaxChance(row, index);
        int maxChance2 = findMaxChance(row, index + 1);
        int maxChance3 = findMaxChance(row, index + 2);

        int card1 =  hand[index] - 1;
        int card2 =  hand[index + 1] - 1;
        int card3 =  hand[index + 2] - 1;

        if (card1 > -1 && card2 > -1 && card3 > -1) {
            hand[index] = card1;
            hand[index+1] = card2;
            hand[index+2] = card3;
            return 0;
        }
        if (card1 < 0 && maxChance1 < Math.abs(card1)) {
            return - 1;
        }
        if (card2 < 0 && maxChance2 < Math.abs(card2)) {
            return - 1;
        }
        if (card3 < 0 && maxChance3 < Math.abs(card3)) {
            return - 1;
        }
        return Math.abs(card1) + Math.abs(card2) + Math.abs(card3);
    }


    private int findKan(int row, Integer index, Integer[] hand) {
        int maxChance = findMaxChance(row, index);
        int card = hand[index] - 3;
        if (card >= 0) {
            hand[index] = card;
            return 0;
        } else {
            if (maxChance >= (Math.abs(card))) {
                return Math.abs(card);
            }
            return -1;
        }
    }

    private int findGang(int row, Integer index, Integer[] hand) {
        int maxChance = findMaxChance(row, index);
        int card = hand[index] - 4;
        if (card >= 0) {
            hand[index] = card;
            return 0;
        } else {
            if (maxChance >= (Math.abs(card))) {
                return Math.abs(card);
            }
            return -1;
        }
    }

    private int guo(int row, Integer index, Integer[] hand) {
        if (hand[index] == 0) {
            return 0;
        }
        return -1;
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

    private int findMaxChance(int row, int column) {
        return pondMatrix[row][column];
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(5d, 9d));
    }
}


