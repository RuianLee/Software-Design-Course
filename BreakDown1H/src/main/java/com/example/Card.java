package com.example;

import java.io.Serializable;

public class Card implements Serializable {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * 需要用在 Map 裡面比大小的比較器，所以回傳數字且設為靜態類別
     * 
     * @param preCard  比較的前一張卡
     * @param nextCard 比較的後一張卡
     * @return 比較結果 1: preCard 大於, 2: nextCard 大於
     */
    public static int biggerCard(Card preCard, Card nextCard) {
        if (preCard.rank.compareTo(nextCard.rank) != 0) {
            return preCard.rank.compareTo(nextCard.rank) > 0 ? 1 : -1;
        }

        return preCard.suit.compareTo(nextCard.suit) > 0 ? 1 : -1;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}