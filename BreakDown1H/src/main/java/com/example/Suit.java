package com.example;

public enum Suit {
    Club(0, "梅花"), Diamond(1, "磚塊"), Heart(2, "紅心"), Spade(3, "黑桃");

    // 1. 為列舉新增屬性 --------------------------------------------------------
    private final int order;
    private final String name;

    // 2. 讓列舉自動將上方初始化 -------------------------------------------------
    Suit(int order, String name) {
        this.order = order;
        this.name = name;
    }

    // 3. 提供列舉對應取值的方法 -------------------------------------------------
    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }
}
