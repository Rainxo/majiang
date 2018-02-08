package com.neo.majiang.people;

/**
 * ���
 * Created by luoyulin1 on 2018/2/7.
 */
public class GamePlayer {

    /**
     * ����
     */
    private int[] handValue = new int[14];

    private int[][] matrix = new int[3][9];

    private int que = -1;

    /**
     * 属性 0-总数量 1-将数 2-坎数 3-搭数
     */
    private int[][] attribute = new int[3][4];

    /**
     * ����
     *
     * @param v
     */
    public void out(int v) {

    }

    /**
     * ����
     *
     * @param v
     */
    public void in(int v) {
        if (-1 == handValue[0] || 0 == handValue[0]) {
            handValue[0] = v;
            sort(handValue);
        } else {
            System.out.println("出错了=========");
        }
        printHand();
    }

    private void sort(int[] handValue) {
        for (int i = 1; i < handValue.length; i++) {
            for (int j = i; j > 0; j--) {
                if (handValue[j] < handValue[j - 1]) {
                    int temp = handValue[j - 1];
                    handValue[j - 1] = handValue[j];
                    handValue[j] = temp;
                } else break;
            }
        }
    }

    public int[] getHandValue() {
        return handValue;
    }

    public void setHandValue(int[] handValue) {
        System.out.println();
        this.handValue = handValue;
        sort(handValue);
        printHand();
        handToMatrix();
    }

    private void printHand() {
        for (int i = 0; i < handValue.length; i++) {
            System.out.print(handValue[i] + " ");
        }
    }

    private void printMatrix() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void handToMatrix() {
        for (int i = 0; i < handValue.length; i++) {
            if (handValue[i] > 10) {
                matrix[(handValue[i] / 10) - 1][(handValue[i] % 10) - 1] += 1;
            }
        }
        printMatrix();
    }

    private void attribute() {
        int tempMatrix [][]= new int[3][9];
        System.arraycopy(matrix, 0, tempMatrix, 0, 3);

        //总数
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                attribute[i][0] += tempMatrix[i][j];
            }
        }

//        //将数
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (tempMatrix[i][j] >= 2) {
//                    attribute[i][1] += 1;
//                    tempMatrix[i][j] -= 2;
//                }
//            }
//        }



    }

    /**
     * 对子
     */
    private void findGoalkeeper() {

    }

}


