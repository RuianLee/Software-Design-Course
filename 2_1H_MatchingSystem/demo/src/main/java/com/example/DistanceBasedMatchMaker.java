package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DistanceBasedMatchMaker implements Matchmaker {
    @Override
    public Individual matchMake(Individual target, List<Individual> individuals) {
        // 先找出最短的路徑 -----------------------------------------------------
        Double distance = Collections.min(individuals,
                Comparator.comparingDouble(individual -> individual.computeDistance(target)))
                .computeDistance(target);

        // 最短的路徑若相同，找 id 更小的 ----------------------------------------
        return Collections.min(individuals.stream()
                .filter(individual -> individual.computeDistance(target).equals(distance))
                .toList(), Comparator.comparingInt(Individual::getId));
    }

    @Override
    public Individual reverseMatchMake(Individual target, List<Individual> individuals) {
        // 先找出最遠的路徑 ------------------------------------------------------
        Double distance = Collections.max(individuals,
                Comparator.comparingDouble(individual -> individual.computeDistance(target)))
                .computeDistance(target);

        // 最遠的路徑若相同，找 id 更小的 -----------------------------------------｢
        return Collections.min(individuals.stream()
                .filter(individual -> individual.computeDistance(target).equals(distance))
                .toList(), Comparator.comparingInt(Individual::getId));
    }
}
