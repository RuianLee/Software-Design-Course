package com.example;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class CommandLine implements Serializable {
    private Scanner sc = new Scanner(System.in);

    /**
     * 給人類玩家輸入玩家名稱
     * 
     * @param order 序號
     * @return 回傳玩家鍵入的玩家名稱
     */
    public String typeName(int order) {
        System.out.print("請輸入玩家" + Integer.toString(order) + "名稱: ");

        return sc.nextLine();
    }

    /**
     * 選擇你要跟誰交換爬
     * 
     * @param otherPlayers 可以交換牌的其他玩家
     * @return 回傳交換的玩家
     */
    public Player selectExchanger(List<Player> otherPlayers) {
        // 1. 判斷是否想要交換牌 -------------------------------------------------
        System.out.print("請問是否想要交換手牌?(Y|N) ");

        if ("N".equals(sc.nextLine())) {
            return null;
        }

        // 2. 想要交換誰的牌 -----------------------------------------------------
        System.out.println("請問是否想要跟誰交換手牌? ");
        for (int i = 0; i < otherPlayers.size(); i++) {
            System.out.println(i + 1 + ": " + otherPlayers.get(i).getName());
        }

        Player exchanger = otherPlayers.get(Integer.parseInt(sc.nextLine()) - 1);
        Game.clearScreen();

        return exchanger;
    }

    /**
     * 回傳手牌中選到的牌
     * 
     * @param hand 手牌
     * @return Card 選到的牌
     */
    public Card selectHandCard(Player player) {
        System.out.println("您目前的手牌有: ------------------------------- ");
        for (int i = 0; i < player.getHands().size(); i++) {
            // 1. 把手牌的印出來，並給予索引選擇 ----------------------------------
            System.out.printf("%d. %s ,%s \t", i + 1, player.getHands().get(i).getSuit().getName(),
                    player.getHands().get(i).getRank().getName());

            // 2. 處理手牌訊息的格式化 -------------------------------------------
            if ((i + 1) % 2 == 0 || i == player.getHands().size() - 1) {
                System.out.println();
            }
        }

        System.out.print("您選擇的牌是: ");
        return player.showHand(Integer.parseInt(sc.nextLine()) - 1);
    }
}
