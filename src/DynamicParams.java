/*
 * Authors: Ethan Fison (aswordlessninja on github), Alex Salois (asalois), Zan Rost-Montieth (Zan-RostMontieth)
 * Date: 4/23/18
 * Overview: Dynamic change-making algorithm. Also uses jUnit for tests to make sure it works proper-like.
 * Modified version of the greedy change-making algorithm from lab 7
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
        /* We'll be using all values between 1 and init to find the minimum change that can be used, so we need this
         * to iterate through everything */
        int[] minCoins = new int[init + 1];
        // Initializes each element in the array to be the largest possible int value
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        // Base case
        minCoins[0] = 0;
        // Iterates through each value between 1 and init to find the minimum number of coins for each value
        // The actual value for the minimum number of coins to be used will be held at minCoins[init]
        for (int val = 1; val <= init; val++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= val) {
                    int toCompare = minCoins[val - coins[j]];
                    if ((toCompare != Integer.MAX_VALUE) && (toCompare + 1 < minCoins[val])) {
                        minCoins[val] = toCompare + 1;
                    }
                }
            }
        }
        int m = 0;
        while(m < minCoins[init]){

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
