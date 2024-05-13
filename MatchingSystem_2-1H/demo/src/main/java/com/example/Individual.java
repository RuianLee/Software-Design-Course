package com.example;

import java.util.Arrays;
import java.util.List;

public class Individual {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String intro;
    private String habits;
    private Crood coord;
    private MatchmakingStrategy matchmaker;
    private Individual bestMatch;

    public void match(Individual match) {
        this.bestMatch = match;
    }

    // Constuctor --------------------------------------------------------------
    public Individual(int id, String name, String gender, int age, String intro, String habits, Crood coord) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setId(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public Crood getCoord() {
        return this.coord;
    }

    public void setCoord(Crood coord) {
        this.coord = coord;
    }

    public MatchmakingStrategy getMatchmaker() {
        return this.matchmaker;
    }

    public void setMatchmaker(MatchmakingStrategy matchmaker) {
        this.matchmaker = matchmaker;
    }

    public Individual getBestMatch() {
        return this.bestMatch;
    }

    public void setBestMatch(Individual bestMatch) {
        this.bestMatch = bestMatch;
    }
}
