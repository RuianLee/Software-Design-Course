package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Individual {
    int id;
    String gender;
    int age;
    String intro;
    String habits;
    int[] coord;

    /**
     * 計算與對象之間的距離
     * 
     * @param target 傳入比對的對象
     * @return 與對象之間的距離
     */
    public Double computeDistance(Individual target) {

        return Math.sqrt(Math.pow(target.coord[1] - this.coord[1], 2)
                - Math.pow(target.coord[0] - this.coord[0], 2));
    }

    /**
     * 回傳相符合的興趣數量
     * 
     * @param target 傳入比對的對象
     * @return 與對象之間相符的興趣數量
     */
    public int compareHabbits(Individual target) {

        return (int) this.getHabitList().stream().filter(target.getHabitList()::contains).count();
    }

    public Individual matchMake(List<Individual> individuals, String matchType) {
        switch (matchType) {
            case "DISTANCE":
                // 先找出最短的路徑 ---------------------------------------------
                Double distance = Collections.min(individuals,
                        Comparator.comparingDouble(individual -> individual.computeDistance(this)))
                        .computeDistance(this);

                // 最短的路徑若相同，找 id 更小的 --------------------------------
                return Collections.min(individuals.stream()
                        .filter(individual -> individual.computeDistance(this).equals(distance))
                        .toList(), Comparator.comparingInt(Individual::getId));

            case "HABIT":
                // 先找出興趣符合最多的數量 --------------------------------------
                int matchHabits = Collections.max(individuals,
                        Comparator.comparingInt(individual -> individual.compareHabbits(this)))
                        .compareHabbits(this);

                // 興趣符合最多數量相同時，找 id 更小的 ---------------------------
                return Collections.min(individuals.stream()
                        .filter(individual -> individual.compareHabbits(this) == matchHabits)
                        .toList(), Comparator.comparingInt(Individual::getId));
            default:
                System.out.println("沒有任何符合的對象");
        }
        return null;
    }

    // Constuctor --------------------------------------------------------------
    public Individual(int id, String gender, int age, String intro, String habits, int[] coord) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.intro = intro;
        this.habits = habits;
        this.coord = coord;
    }

    // Getter and Setter -------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            System.out.println("id number must be positive");
            return;
        }

        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!Arrays.asList(new String[] { "MALE", "FEMALE" }).contains(gender)) {
            System.out.println("only MALE or FEMALE");
            return;
        }

        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            System.out.println("Age under 18 please leave");
            return;
        }

        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        if (intro.length() > 200) {
            System.out.println("You intro must under 200 words");
            return;
        }

        this.intro = intro;
    }

    public String getHabits() {
        return habits;
    }

    public List<String> getHabitList() {
        return Arrays.asList(this.habits.split(","));
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public int[] getCoord() {
        return coord;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }
}
