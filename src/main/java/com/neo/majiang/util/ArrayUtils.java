package com.neo.majiang.util;

/**
 * Created by luoyulin1 on 2018/2/7.
 */
public class ArrayUtils {

    /**
     *
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
}
