package com.neo.majiang.people;

import java.util.Arrays;

/**
 * Created by luoyulin1 on 2018/3/23.
 */
public class Record {

    private String okCard="";

    private String ficCard="";

    private int index = 0;

    private int fictitiousSize; //虚拟数

    private int surplusSize = 0;//剩余

    private double probability; //概率

    private int[] fictitious; //

    private Integer[] tempHandValue = new Integer[9]; //

    private Integer[] tempPondMatrix = new Integer[9];


    public Record(Integer[] handValue, Integer[] pondMatrix) {
        this.fictitiousSize = 0;
        this.surplusSize = 0;
        tempHandValue =handValue.clone();
        tempPondMatrix = pondMatrix.clone();
    }

    public Record(Record record) {
        this.index = record.getIndex();
        this.fictitiousSize = record.getFictitiousSize();
        this.surplusSize = record.getSurplusSize();
        this.okCard = record.getOkCard();
        tempHandValue = record.getTempHandValue().clone();
        tempPondMatrix = record.getTempPondMatrix().clone();
    }

    public int getCard() {
        return tempHandValue[index];
    }

    public int getCard(int index) {
        return tempHandValue[index];
    }

    public void setCard(int value) {
        tempHandValue[index] = value;
        surplusSize = value;
        if (value == 0) {
            index += 1;
        }
    }
    public void setCard(int index,int value) {
        tempHandValue[index] = value;
        //surplusSize = value;
    }

    public void refreshPond(int index, int value) {
        tempPondMatrix[index] -= value;
        fictitiousSize += value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Integer[] getTempHandValue() {
        return tempHandValue;
    }

    public void setTempHandValue(Integer[] tempHandValue) {
        this.tempHandValue = tempHandValue;
    }

    public Integer[] getTempPondMatrix() {
        return tempPondMatrix;
    }

    public void setTempPondMatrix(Integer[] tempPondMatrix) {
        this.tempPondMatrix = tempPondMatrix;
    }

    public int getFictitiousSize() {
        return fictitiousSize;
    }

    public void setFictitiousSize(int fictitiousSize) {
        this.fictitiousSize = fictitiousSize;
    }

    public int getSurplusSize() {
        return surplusSize;
    }

    public void setSurplusSize(int surplusSize) {
        this.surplusSize = surplusSize;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int findMaxChance() {
        return tempPondMatrix[index];
    }

    public int findMaxChance( int index) {
        return tempPondMatrix[index];
    }

    public void setJiang() {
        int card = 10+(index+1);

        okCard += card+","+card+"  ";
    }

    public void setKan() {
        int card = 10+(index+1);
        okCard += card+","+card+","+card+"  ";
    }

    public void setDa() {
        int card = 10+(index+1);
        okCard += card+","+(card+1)+","+ (card+2)+"  ";
    }
    public void setGang() {
        int card = 10+(index+1);
        okCard += card+","+card+","+card+","+card+"  ";
    }

    public String getOkCard() {
        return okCard;
    }

    public void setOkCard(String okCard) {
        this.okCard = okCard;
    }

}
