package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Serializable {

    private int order; // 順序
    private int point; // 獲得分數
    private String name; // 玩家名稱
    private boolean isExchanged = false; // 是否
    private ExchangeHand exchangeHand;
    private List<Card> hands = new ArrayList<Card>();

    /**
     * 命名玩家名稱 => 人類玩家與AI玩家實作不同
     */
    protected abstract void nameHimSelf();

    /**
     * 一回合玩家會做的操作
     * 
     * @param players 除了自己以外的玩家
     */
    protected abstract Card takeTurn(List<Player> players);

    /**
     * 將兩邊玩家的手牌互換
     * 
     * @param exchanger 選擇被換的人
     * @param player    選擇換的人
     */
    public void exchangeHand(Player exchanger, Player player) {
        exchangeHand = new ExchangeHand(exchanger, player);
        List<Card> playerHands = player.getHands();
        player.setHands(exchanger.getHands());
        exchanger.setHands(playerHands);
    }

    /**
     * 手牌增加一張牌
     * 
     * @param card 新增的牌
     */
    public void addHand(Card card) {
        hands.add(card);
    }

    /**
     * 手牌出一張牌(不留在手牌內)
     * 
     * @return card 抽出的牌
     */
    public Card showHand(int order) {
        Card card = hands.get(order);
        hands.remove(order);

        return card;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExchangeHand getExchangeHand() {
        return this.exchangeHand;
    }

    public void setExchangeHand(ExchangeHand exchangeHand) {
        this.exchangeHand = exchangeHand;
    }

    public List<Card> getHands() {
        return hands;
    }

    public void setHands(List<Card> hands) {
        this.hands = hands;
    }

    public boolean isExchanged() {
        return isExchanged;
    }

    public void setExchanged(boolean isExchanged) {
        this.isExchanged = isExchanged;
    }
}
