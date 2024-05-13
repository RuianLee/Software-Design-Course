package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int id = 1;
        // 1. 建立多個對象 (Individual)------------------------------------------
        Individual Brian = new Individual(id++, "MALE", 23, "My Name is Brian", "打球,看電影,coding", new int[] { 10, 10 });
        Individual Jerry = new Individual(id++, "MALE", 23, "Hi", "打球,看電影,健身", new int[] { 10, 9 });
        Individual Sunny = new Individual(id++, "FEMALE", 23, "How are you?", "看電影,種花,吃美食", new int[] { 10, 8 });
        Individual Sam = new Individual(id++, "MALE", 23, "Make love?", "睡覺,種花,吃美食", new int[] { 10, 7 });

        // 2. 進行配對 ----------------------------------------------------------
        Individual target = Sunny.matchMake(Arrays.asList(Jerry, Brian, Sam), "DISTANCE");

        // 3. 觀察配對結果 ------------------------------------------------------
        System.out.println(target.getId());
    }
}