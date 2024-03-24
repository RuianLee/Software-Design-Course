package com.example;

public class ExchangeHand {
    private Player player;
    private Player exchanger;
    private int counter = 3;

    public ExchangeHand(Player player, Player exchanger) {
        this.player = player;
        this.exchanger = exchanger;
    }

    /**
     * 取得回合倒數比對時，順便將該回合減去
     * 
     * @return 回傳倒數是否結束
     */
    public boolean counterEqualZero() {
        if (counter != 0) {
            counter = counter - 1;
            return false;
        }
        return true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getExchanger() {
        return this.exchanger;
    }

    public void setExchanger(Player exchanger) {
        this.exchanger = exchanger;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
