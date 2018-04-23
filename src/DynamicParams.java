/*
 * Authors: Ethan Fison (aswordlessninja on github), Alex Salois (asalois), Zan Rost-Montieth (Zan-RostMontieth)
 * Date: 4/23/18
 * Overview: Dynamic change-making algorithm. Also uses jUnit for tests to make sure it works proper-like
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
        ArrayList coinsUsed = new ArrayList<Integer>(); // ArrayList so we don't need to adjust the size of an array for the coins
        /* We'll be using all values between 1 and init to find the minimum change that can be used, so we need this
         * to iterate through everything */
        int[] minCoins = new int[init + 1];
        Arrays.fill(minCoins, 0); // Initializes each element in the array to be 0
        // Iterates through each value between 1 and init to find the minimum number of coins for each value
        for(int val = 1; val <= init; val++){
            for(int j = 0; j<coins.length; j++){
                if(coins[j]<=val){
                    if(minCoins[val-coins[j]]!=0 && minCoins[val-coins[j]] + 1 < minCoins[val])
                        minCoins[val] = minCoins[val-coins[j]] + 1;
                }
            }
        }
        while(int m < )
        for (int j = 0; j < coinsUsed.size(); j++) { // Iterates through the arraylist to print the values
            if (j == coinsUsed.size() - 1) {
                System.out.println(coinsUsed.get(j));
            } else
                System.out.print(coinsUsed.get(j) + ", ");
        }
        return coinsUsed;
    }


}
