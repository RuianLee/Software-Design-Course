package com;

import java.util.List;

import com.example.Individual;
import com.example.MatchmakingStrategy;

public class MatchmakingSystem {
    MatchmakingStrategy strategy;
    List<Individual> individuals;

    public Individual match(Individual target, List<Individual> others, boolean reverse) {
        return strategy.matchMake(target, others, reverse);
    }

    public MatchmakingStrategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(MatchmakingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Individual> getIndividuals() {
        return this.individuals;
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
    }

}
