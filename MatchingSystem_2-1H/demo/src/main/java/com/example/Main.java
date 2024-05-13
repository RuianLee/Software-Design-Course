package com.example;

import java.util.Arrays;
import java.util.List;

import com.MatchmakingSystem;

public class Main {
    public static void main(String[] args) {
        int id = 1;

        // 1. 多個對象進入系統 ---------------------------------------------------
        List<Individual> individuals = Arrays.asList(
                new Individual(id++, "Brian", "MALE", 23, "My Name is Brian", "打球,看電影,coding", new Crood(10, 10)),
                new Individual(id++, "Jerry", "MALE", 23, "Hi", "打球,看電影,健身", new Crood(10, 9)),
                new Individual(id++, "Sunny", "FEMALE", 23, "How are you?", "看電影,種花,吃美食", new Crood(10, 8)),
                new Individual(id++, "Sam", "MALE", 23, "Make love?", "睡覺,種花,吃美食", new Crood(10, 7)));

        // 2. 進行配對 ----------------------------------------------------------
        MatchmakingSystem system = new MatchmakingSystem();
        system.setStrategy(new HabitBasedMatchStrategy()); // DistanceBasedMatchMaker|HabitBasedMatchMaker
        system.setIndividuals(individuals);

        individuals.forEach((target) -> {
            // 2.1 取得可配對對象們 -------------------------------
            List<Individual> others = individuals.stream().filter((individual) -> {
                return individual.getId() != target.getId();
            }).toList();

            // 2.2 各別與他人進行配對 -----------------------------
            Individual result = system.match(target, others, false);
            System.out.println(target.getName() + "配對到" + result.getName());
        });
    }
}