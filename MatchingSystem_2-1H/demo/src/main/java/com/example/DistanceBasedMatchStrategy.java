package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceBasedMatchStrategy implements MatchmakingStrategy {
    @Override
    public Individual matchMake(Individual target, List<Individual> individuals, boolean reverse) {
        // 準備計算路徑 -------------------------------------------------------------
        Individual result;

        if (reverse) {
            // 先找出最遠的路徑 ------------------------------------------------------
            result = Collections.max(individuals,
                    Comparator.comparingDouble(individual -> computeDistance(target, individual)));
        } else {
            // 先找出最短的路徑 ------------------------------------------------------
            result = Collections.min(individuals,
                    Comparator.comparingDouble(individual -> computeDistance(target, individual)));
        }

        Double distance = computeDistance(target, result);

        // 若路徑相同，找 id 更小的 --------------------------------------------------
        return Collections.min(individuals.stream()
                .filter(individual -> computeDistance(target, individual).equals(distance))
                .collect(Collectors.toList()), Comparator.comparingInt(Individual::getId));
    }

    /**
     * 計算與對象之間的距離
     * 
     * @param target
     *            要配對的對象
     * @param other
     *            傳入比對的對象
     * @return 與對象之間的距離
     */
    public Double computeDistance(Individual target, Individual other) {
        Double distance = Math.sqrt(Math.pow(target.getCoord().getX() - other.getCoord().getX(), 2)
                + Math.pow(target.getCoord().getY() - other.getCoord().getY(), 2));

        return distance;
    }
}
