package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game implements Serializable {
    // 參與遊戲的玩家 -----------------------------------------------------------
    private static List<Player> players = new ArrayList<Player>();;
    private static Deck deck = new Deck();;

    /**
     * 開始遊戲流程
     */
    public static void start() {
        // 1. 開始遊戲，由玩家輸入人類玩家人數 ------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.print("請選擇玩家人數，最多4人: ");

        int count = Integer.parseInt(sc.nextLine());

        // 2. 產生4位玩家，各自命名 ----------------1------------------------------
        for (int i = 1; i <= 4; i++) {
            if (i <= count) {
                players.add(new HumanPlayer(i));
                continue;
            }
            players.add(new AIPlayer(i));
        } ;

        clearScreen();

        // 3. 遊戲中有牌堆，各玩家從中取出 13 張卡片 ------------------------------
        for (int i = 0; i < 13; i++) {
            for (Player player : players) {
                player.addHand(deck.drawCard());
            }
        }

        // 4.抽完牌後，在接下來的 13 回合中，每一回合依序執行以下 -------------------
        for (int i = 1; i < 6; i++) {

            // 4.1 建立牌桌存取玩家出的對應的牌 -----------------------------------
            Map<Player, Card> table = new HashMap<>();
            System.out.printf("第%d回合 \n", i);

            // 4.2 玩家選擇是否交換，並出一張牌 -----------------------------------
            for (Player player : players) {
                table.put(player, player.takeTurn(players));
                clearScreen();
            }

            System.out.println("目前牌桌戰況 ------------------------------------");
            table.forEach((player, card) -> {
                System.out
                        .println(player.getName() + ": " + card.getSuit().getName() + ", " + card.getRank().getName());
            });

            // 4.3 比對牌桌上牌最大的玩家 ----------------------------------------
            Player winner = Collections
                    .max(table.entrySet(), (card1, card2) -> Card.biggerCard(card1.getValue(), card2.getValue()))
                    .getKey();

            // 4.4 幫牌最大的玩家加分 --------------------------------------------
            System.out.println("恭喜這回合由" + winner.getName() + "獲得勝利 --------------------");
            System.out.println("");
            winner.setPoint(winner.getPoint() + 1);

        }

        // 5.將最後得分最大的玩家 Show 出來 --------------------------------------
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getPoint());
        }

        // 6.貼出遊戲最後獲勝者 -------------------------------------------------
        System.out.println(new StringBuffer().append("\n恭喜~~~")
                .append(Collections.max(players, (p1, p2) -> Integer.compare(p1.getPoint(), p2.getPoint())).getName())
                .append("獲得勝利").toString());

        sc.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
