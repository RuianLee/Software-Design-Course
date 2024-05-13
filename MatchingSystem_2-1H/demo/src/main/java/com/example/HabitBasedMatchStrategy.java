package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HabitBasedMatchStrategy implements MatchmakingStrategy {
    @Override
    public Individual matchMake(Individual target, List<Individual> individuals, boolean reverse) {
        // 準備計算興趣數量 -------------------------------------------------------------
        Individual result;

        if (reverse) {
            // 先找出興趣符合最少的數量 ----------------------------------------------
            result = Collections.min(individuals,
                    Comparator.comparingInt(individual -> compareHabbits(target, individual)));
        } else {
            // 先找出興趣符合最多的數量 ----------------------------------------------
            result = Collections.max(individuals,
                    Comparator.comparingInt(individual -> compareHabbits(target, individual)));
        }

        int matchHabits = compareHabbits(target, result);

        // 興趣符合最多數量相同時，找 id 更小的 -----------------------------------
        return Collections.min(individuals.stream()
                .filter(individual -> compareHabbits(target, individual) == matchHabits)
                .collect(Collectors.toList()), Comparator.comparingInt(Individual::getId));
    }

    /**
     * 回傳相符合的興趣數量
     * 
     * @param target
     *            要配對的對象
     * @param other
     *            傳入比對的對象
     * @return 與對象之間相符的興趣數量
     */
    public int compareHabbits(Individual target, Individual other) {
        int count = (int) other.getHabitList().stream().filter(target.getHabitList()::contains).count();

        return count;
    }
}
