package com.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AIPlayer extends Player {

    /**
     * 創建 AIPlayer 會決定好序號並用序號取名
     * 
     * @param order 序號
     */
    public AIPlayer(int order) {
        setOrder(order);
        nameHimSelf();
    }

    @Override
    protected void nameHimSelf() {
        this.setName("AI_" + this.getOrder() + "號");
    }

    @Override
    protected Card takeTurn(List<Player> players) {
        // 0. 查看是否有交換倒數，或是交換倒數是否結束 -----------------------------
        if (this.getExchangeHand() != null && this.getExchangeHand().counterEqualZero()) {
            exchangeHand(this.getExchangeHand().getExchanger(), this.getExchangeHand().getPlayer());
            System.out.printf("%s 與 %s 的手牌換回來囉 \n", this.getExchangeHand().getExchanger().getName(),
                    this.getExchangeHand().getPlayer().getName());
        }

        // 1. 自己以外的其他玩家 -------------------------------------------------
        List<Player> otherPlayers = players.stream().filter(player -> player.getOrder() != this.getOrder())
                .collect(Collectors.toList());

        // 2. 隨機決定是否交換，並隨機選擇交換玩家 --------------------------------
        if (!isExchanged()) {
            Player exchanger = null;
            if (Math.random() < 0.5) {
                exchanger = otherPlayers.get(new Random().nextInt(otherPlayers.size()));

            }
            if (exchanger != null) {
                exchangeHand(exchanger, this); // 交換手牌
                setExchanged(true); // 註記換過了
            }
        }

        // 3. 隨機取出牌堆中的一張牌 ---------------------------------------------
        return this.showHand(new Random().nextInt(this.getHands().size()));
    }
}
