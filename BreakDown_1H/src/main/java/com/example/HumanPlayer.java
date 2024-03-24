package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class HumanPlayer extends Player {
    private static final CommandLine COMMAND_LINE = new CommandLine();

    public HumanPlayer(int order) {
        setOrder(order);
        nameHimSelf();
    }

    @Override
    protected void nameHimSelf() {
        setName(COMMAND_LINE.typeName(this.getOrder()));
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

        // 2. 是否願意交換，並選擇交換玩家 ----------------------------------------
        if (!isExchanged()) {
            Player exchanger = COMMAND_LINE.selectExchanger(otherPlayers);
            if (exchanger != null) {
                exchangeHand(exchanger, this); // 與玩家交換手牌
                setExchanged(true); // 註記交換權利消失
            }
        }

        // 3. 選擇要出的牌 ------------------------------------------------------
        return COMMAND_LINE.selectHandCard(this);
    }
}
