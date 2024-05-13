package com.example;

import java.util.List;

public interface MatchmakingStrategy {
    /**
     * 配對對象的策略
     * 
     * @param target
     *            配對的目標
     * @param individuals
     *            將被配對的對象們
     * @param reverse
     *            是否作反向配對
     * @return 被配對到的對象
     */
    Individual matchMake(Individual target, List<Individual> individuals, boolean reverse);
}
