package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HabitBasedMatchMaker implements Matchmaker {
    @Override
    public Individual matchMake(Individual target, List<Individual> individuals) {
        // 先找出興趣符合最多的數量 ----------------------------------------------
        int matchHabits = Collections.max(individuals,
                Comparator.comparingInt(individual -> individual.compareHabbits(target)))
                .compareHabbits(target);

        // 興趣符合最多數量相同時，找 id 更小的 -----------------------------------
        return Collections.min(individuals.stream()
                .filter(individual -> individual.compareHabbits(target) == matchHabits)
                .toList(), Comparator.comparingInt(Individual::getId));
    }

    @Override
    public Individual reverseMatchMake(Individual target, List<Individual> individuals) {
        // 先找出興趣符合最少的數量 ----------------------------------------------
        int matchHabits = Collections.min(individuals,
                Comparator.comparingInt(individual -> individual.compareHabbits(target)))
                .compareHabbits(target);

        // 興趣符合最少數量相同時，找 id 更小的 -----------------------------------
        return Collections.min(individuals.stream()
                .filter(individual -> individual.compareHabbits(target) == matchHabits)
                .toList(), Comparator.comparingInt(Individual::getId));
    }
}
