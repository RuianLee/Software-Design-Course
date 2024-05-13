package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck implements Serializable {
    List<Card> cards = new ArrayList<>();;

    /**
     * 牌堆創建後，會自動將卡片準備好
     */
    public Deck() {
        // 1.準備固定的花色，建立各自 13 張牌 -------------------------------------
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        // 2.進行洗牌 ----------------------------------------------------------
        shuffle();
    }

    /**
     * 遊戲開始前洗牌
     */
    public void shuffle() {
        System.out.println("牌堆開始洗牌，遊戲準備開始~~");
    }

    /**
     * 從牌堆中隨機取出一張牌(不留在牌堆)
     * 
     * @return Card 從牌堆中取出的牌
     */
    public Card drawCard() {
        // 1. 跟著目前擁有的大小，取隨便取一個的數字 ------------------------------
        int index = new Random().nextInt(cards.size());

        // 2. 把牌取出牌堆 -----------------------------------------------------
        Card card = cards.get(index);
        cards.remove(index);

        return card;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
