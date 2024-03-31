package com.example;

import java.util.List;

public interface Matchmaker {
    /**
     * 配對對象的方法
     * 
     * @param target      配對的目標
     * @param individuals 將被配對的對象們
     * @return 被配對到的對象
     */
    public Individual matchMake(Individual target, List<Individual> individuals);

    /**
     * reverse version 配對對象的方法
     * 
     * @param target      配對的目標
     * @param individuals 將被配對的對象們
     * @return 被配對到的對象
     */
    public Individual reverseMatchMake(Individual target, List<Individual> individuals);
}
