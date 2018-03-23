package com.neo.majiang.people;

import com.neo.majiang.room.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luoyulin1 on 2018/2/7.
 */
public class GamePlayer {


    private int[] handValue = new int[Room.HAND_LENGTH];

    private static final int DIE = -999; //死牌标识

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
        Integer[] matrix = {2,1,1,1,1,1,3,1,1,};
        Integer[] pondMatrix = {4,4,4,4,4,4,4,4,4};

        //Record record = new Record(matrix[0],pondMatrix[0]);
        Record record = new Record(matrix,pondMatrix);
        opt(0, record);
        //opt(1, 0, matrix[1], "", 0);
        // opt(2, 0, matrix[2], "", 0);
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
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    int min = Integer.MAX_VALUE;
    List<String> re = new ArrayList<>();

    private void opt(int row, Record record) {
        if (record.getFictitiousSize() > 3) {
            return;
        }
        if (record.getIndex() > 8) {
            System.out.println(record.getOkCard());
            System.out.println(Arrays.toString(record.getTempHandValue()));
            return;
        }

        Record fj = findjiang(row, record);
        if (null != fj) {
            opt(row, fj);
        }

        Record fd = findDa(row, record);
        if (null != fd) {
            opt(row, fd);
        }

        Record fk = findKan(row, record);
        if (null != fk) {
            opt(row, fk);
        }
        Record fg = findGang(row, record);
        if (null != fg) {
            opt(row, fg);
        }
        Record guo = guo(row, record);
        if (null != guo) {
            opt(row, guo);
        }
    }

    private Record findjiang(int row, Record oRecord) {
        Record record = new Record(oRecord);

        int maxChance = record.findMaxChance(row);
        int card = record.getCard() - 2;
        if (card >= 0) {
            record.setJiang();
            record.setCard(card);
            return record;
        } else {
            if (maxChance >= (Math.abs(card))) {
                record.refreshPond(record.getIndex(), Math.abs(card));
                record.setIndex(record.getIndex()+1);
                return record;
            }
            return null;
        }
    }


    private Record findDa(int row, Record oRecord) {
        int index = oRecord.getIndex();
        if (index > 6) {
            return null;
        }
        Record record = new Record(oRecord);

        int maxChance1 = record.findMaxChance(index);
        int maxChance2 = record.findMaxChance(index + 1);
        int maxChance3 = record.findMaxChance(index + 2);

        int card1 = record.getCard() - 1;
        int card2 = record.getCard(index + 1) - 1;
        int card3 = record.getCard(index + 2) - 1;

        if (card1 < 0 && maxChance1 < Math.abs(card1)) {
            return null;
        }
        if (card2 < 0 && maxChance2 < Math.abs(card2)) {
            return null;
        }
        if (card3 < 0 && maxChance3 < Math.abs(card3)) {
            return null;
        }

        if (card1 >= 0 && card2 >= 0 && card3 >= 0) {
            record.setDa();
            record.setCard(card1);
            record.setCard(index + 1, card2);
            record.setCard(index + 2, card3);
            return record;
        }else{
            if (card1 < 0) {
                record.refreshPond(index, Math.abs(card1));
                record.setIndex(record.getIndex() + 1);
            } else {
                record.setCard(card1);
            }
            if (card2 < 0) {
                record.refreshPond(index + 1, Math.abs(card2));
                record.setCard(index + 1, 0);
            } else {
                record.setCard(index + 1, card2);
            }
            if (card3 < 0) {
                record.refreshPond(index + 2, Math.abs(card3));
                record.setCard(index + 2, 0);
            } else {
                record.setCard(index + 2, card3);
            }
            return record;
        }
    }


    private Record findKan(int row, Record oRecord) {
        Record record = new Record(oRecord);

        int maxChance = record.findMaxChance(row);
        int card = record.getCard() - 3;
        if (card >= 0) {
            record.setKan();
            record.setCard(card);
            return record;
        } else {
            if (maxChance >= (Math.abs(card))) {
                record.refreshPond( record.getIndex(), Math.abs(card));
                record.setIndex(record.getIndex() + 1);
                return record;
            }
            return null;
        }
    }

    private Record findGang(int row, Record oRecord) {
        Record record = new Record(oRecord);

        int maxChance = record.findMaxChance(row);
        int card = record.getCard() - 4;
        if (card >= 0) {
            record.setGang();
            record.setCard(card);
            return record;
        } else {
            if (maxChance >= (Math.abs(card))) {
                record.refreshPond(record.getIndex(), Math.abs(card));
                record.setIndex(record.getIndex()+1);
                return record;
            }
            return null;
        }
    }

    private Record guo(int row, Record oRecord) {
        Record record = new Record(oRecord);

        if (record.getCard() == 0) {
            record.setCard(0);
            return record;
        }
        return null;
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


