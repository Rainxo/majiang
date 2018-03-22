package com.neo.majiang.room;

import com.neo.majiang.people.GamePlayer;
import com.neo.majiang.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by luoyulin1 on 2018/2/7.
 */
public class Room {

    public static final int HAND_LENGTH = 14; //数量

    public static final int PLAYER_SIZE = 1; //

    //private String model = "ABC-ABC-ABC-ABC-AA   AAA-ABC-ABC-ABC-AA   AAA-AAA-ABC-ABC-AA   AAA-AAA-AAA-ABC-AA   AAA-AAA-AAA-AAA-AA   AA-BB-CC-DD-EE-GG-FF   ";

    private int[] card = {
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39};

    private List<GamePlayer> players = new ArrayList<GamePlayer>();

    public Room() {
        randomCard();
        for (int i = 0; i < PLAYER_SIZE; i++) {
            int[] handValue = new int[HAND_LENGTH];
            System.arraycopy(card, i * HAND_LENGTH, handValue, 0, HAND_LENGTH);
            GamePlayer gp = new GamePlayer(handValue);
            players.add(gp);
        }

        ArrayUtils.cover(card, 0, PLAYER_SIZE * HAND_LENGTH, -1);
        print();
    }


    private void randomCard() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Integer r1 = random.nextInt(107);
            Integer r2 = random.nextInt(107);
            Integer temp = card[r1];
            card[r1] = card[r2];
            card[r2] = temp;
        }
        print();
    }

    private void print() {
        System.out.println("剩余数据");
        for (int i = 0; i < card.length; i++) {
            if (i != 0 && i % 27 == 0) {
                System.out.println();
            }
            System.out.print(card[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Room r = new Room();

    }
}
