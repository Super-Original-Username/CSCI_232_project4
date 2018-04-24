/*
 * Authors: Ethan Fison (aswordlessninja on github), Alex Salois (asalois), Zan Rost-Montieth (Zan-RostMontieth)
 * Date: 4/23/18
 * Overview: Dynamic change-making algorithm. Also uses jUnit for tests to make sure it works proper-like.
 * Modified version of the greedy change-making algorithm from lab 7
 * Uses JUNIT 5 for all tests
 */

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicParams {


    public static ArrayList<Integer> coinChange(int[] coins, int init) {
        // These are exception throws for the tests, to make sure that the inputs are correct before running
        if (coins.length == 0 && init <= 0) {
            throw new IllegalArgumentException("Both coins and init have illegal inputs");
        } else {
            if (coins.length == 0) {
                throw new IllegalArgumentException("You need at least one type of coin to be in the array");
            }
            if (init <= 0) {
                throw new IllegalArgumentException("Init needs to be at least 1");
            }
        }
        for (int k = 0; k < coins.length; k++) {
            if (coins[k] == 0) {
                throw new IllegalArgumentException("There cannot be any values less than 1 in the coins array");
            }
        }

        // The arraylist is used so we don't need to resize arrays if the number of coins exceeds the original size
        ArrayList coinsUsed = new ArrayList<Integer>();
        int[] totalCoins = new int[init+1];
        /* We'll be using all values between 1 and init to find the minimum change that can be used, so we need this
         * to iterate through everything */
        int[] minCoins = new int[init + 1];
        // Initializes each element in the array to be the largest possible int value
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        // Base case
        minCoins[0] = 0;
        // Iterates through each value between 1 and init to find the minimum number of coins for each value
        // The actual value for the minimum number of coins to be used will be held at minCoins[init]
        // Simultaneously finds all coins used and places them into the coinsUsed array at an index relative to the inital
        // value added + the new number.(sorry if I explained that poorly, if you want to see what I mean, enter an
        // init that will have different results from the current expected case in the test cases)
        for (int val = 0; val <= init; val++) {
            int count = val;
            int n = coins[coins.length - 1];
            for (int c = 0; c < coins.length; c++) {
                if (coins[c] <= val) {
                    int j = coins[c];
                    if (minCoins[val - j] + 1 < count) {
                        count = minCoins[val - j] + 1;
                        n = j;
                    }
                    minCoins[val] = count;
                    totalCoins[val] = n;
                }
            }
        }
        int temp = init;
        while(temp > 0){
            int thisCoin = totalCoins[temp];
            coinsUsed.add(thisCoin);
            temp = temp - thisCoin;
        }

        // Iterates through the arraylist to print the values
        for (int j = 0; j < coinsUsed.size(); j++) {
            if (j == coinsUsed.size() - 1) {
                System.out.println(coinsUsed.get(j));
            } else
                System.out.print(coinsUsed.get(j) + ", ");
        }
        return coinsUsed;
    }
}



