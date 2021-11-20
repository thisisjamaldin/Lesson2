package com.company;

import java.util.Random;

public class Main {

    //Игроки
    public static String[] playersName = {"Warrior", "Physical", "Magical", "Doctor"};
    public static int[] playersHealth = {200, 190, 210, 200};
    public static int[] playersAttack = {25, 25, 26, 0};
    //Босс
    public static int bossHealth = 700;
    public static int bossAttack = 50;

    public static void main(String[] args) {
        printStatistics();
        while (!gameOver()) {
            round();
        }
    }

    public static void round() {
        playersHit();
        bossHit();
        heal();
        printStatistics();
    }

    public static void printStatistics() {
        System.out.println("Boss health: " + bossHealth);
        for (int i = 0; i < playersName.length; i++) {
            System.out.println(playersName[i] + " health: " + playersHealth[i]);
        }
        System.out.println("==================");
    }

    public static void playersHit() {
        for (int i = 0; i < playersName.length; i++) {
            bossHealth -= playersAttack[i];
            if (bossHealth < 0) {
                bossHealth = 0;
            }
        }
    }

    public static void heal() {
        for (int i = 0; i < playersName.length; i++) {
            if (playersHealth[i] > 0 && i !=3) {
                int add = ran();
                playersHealth[i] += add;
                System.out.println(playersName[i] + " healed +" + add);
            }
        }
    }

    public static void bossHit() {
        for (int i = 0; i < playersName.length; i++) {
            playersHealth[i] -= bossAttack;
            if (playersHealth[i] < 0) {
                playersHealth[i] = 0;
            }
        }
    }

    public static boolean gameOver() {
        if (bossHealth <= 0) {
            System.out.println("Players Win");
            return true;
        }
        if (playersHealth[0] <= 0 && playersHealth[1] <= 0 && playersHealth[2] <= 0) {
            System.out.println("Boss Wins");
            return true;
        }
        return false;
    }

    public static int ran() {
        Random random = new Random();
        return random.nextInt(25);
    }

}