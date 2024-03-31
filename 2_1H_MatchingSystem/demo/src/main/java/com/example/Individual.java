package com.example;

import java.util.Arrays;
import java.util.List;

public class Individual {
    int id;
    String gender;
    int age;
    String intro;
    String habits;
    int[] coord;
    Matchmaker matchmaker;

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

    /**
     * 設置配對器
     * 
     * @param matchmaker 配對器
     */
    public void setMatchmaker(Matchmaker matchmaker) {
        this.matchmaker = matchmaker;
    }

    /**
     * 進行對象的配對
     * 
     * @param individuals 可配對的對象們
     * @return 回傳配對到的對象
     */
    public Individual matchMake(List<Individual> individuals) {
        return matchmaker.matchMake(this, individuals);
    }

    /**
     * 進行對象的反向配對
     * 
     * @param individuals 可配對的對象們
     * @return 回傳配對到的對象
     */
    public Individual reverMatchMake(List<Individual> individuals) {
        return matchmaker.reverseMatchMake(this, individuals);
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
