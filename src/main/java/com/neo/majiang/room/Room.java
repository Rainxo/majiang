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

    private Integer[] card = {
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39};

    private List<GamePlayer> players = new ArrayList<GamePlayer>();

    public Room() {
        randomCard();
        for (int i = 0; i < 4; i++) {
            GamePlayer gp = new GamePlayer();
            Integer[] handValue = new Integer[13];
            System.arraycopy(card, i*13, handValue, 0, 13);
            gp.setHandValue(handValue);
            players.add(gp);
        }

        ArrayUtils.cover(card, 0, 52, -1);
        print();
    }

    /**
     * Ëæ»ú´òÂÒ
     */
    private void randomCard() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Integer r1 = random.nextInt(107);
            Integer r2 = random.nextInt(107);
            Integer temp = card[r1];
            card[r1] = card[r2];
            card[r2] = temp;
        }

        print();
    }

    private  void print() {
        System.out.println();
        for (int i = 0; i < card.length; i++) {
            if (i % 27 == 0) {
                System.out.println();
            }
            System.out.print(card[i] + " ");
        }
    }
    public static void main(String[] args) {
        Room r = new Room();

    }
}
