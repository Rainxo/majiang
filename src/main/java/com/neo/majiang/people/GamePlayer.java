package com.neo.majiang.people;

/**
 * Íæ¼Ò
 * Created by luoyulin1 on 2018/2/7.
 */
public class GamePlayer {

    /**
     * ÊÖÅÆ
     */
    private Integer [] handValue;

    /**
     * ³öÅÆ
     * @param v
     */
    public void out(Integer v) {

    }

    /**
     * ÃşÅÆ
     * @param v
     */
    public void in(Integer v) {

    }

    private void sort(Integer[] handValue) {
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

    public Integer[] getHandValue() {
        return handValue;
    }

    public void setHandValue(Integer[] handValue) {
        System.out.println();
        this.handValue = handValue;
        sort(handValue);
        for (int i = 0; i < handValue.length; i++) {
            System.out.print(handValue[i] + " ");
        }
    }
}


