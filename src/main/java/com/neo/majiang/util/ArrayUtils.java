package com.neo.majiang.util;

/**
 * Created by luoyulin1 on 2018/2/7.
 */
public class ArrayUtils {

    /**
     *  替换
     * @param src
     * @param startPos
     * @param endPos
     * @param val
     */
    public static void cover(int[] src, int startPos, int endPos,Integer val) {
        if (src.length > endPos && endPos >= startPos) {
            for (int i = startPos; i < endPos; i++) {
                   src[i] = val;
            }
        }
    }

    /**
     * 排序
     * @param handValue
     */
    public static void sort(int[] handValue) {
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
}
