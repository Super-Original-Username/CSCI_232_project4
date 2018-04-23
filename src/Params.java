/*
 * Author: Ethan Fison
 * Date: 4/13/18
 * Overview: Greedy change-making algorithm. Also uses jUnit for tests to make sure it works proper-like
 */


import java.util.ArrayList;


public class Params {
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
        for(int k = 0; k < coins.length;k++){
            if(coins[k] == 0){
                throw new IllegalArgumentException("There cannot be any values less than 1 in the coins array");
            }
        }
        ArrayList coinsUsed = new ArrayList<Integer>(); // ArrayList for dynamically allocated number insertion
        int runningTotal = 0; // Used for checks in the while loop
        int[] output;
        int i = coins.length - 1; // Starts at the end of the coins array to use the largest coin first
        while (runningTotal != init) { // Loops until runningtotal is not equal to the value to be broken down
            if ((runningTotal + coins[i]) <= init) {
                runningTotal += coins[i]; // adds to the runningtotal for future checks
                coinsUsed.add(coins[i]); // Adds the coins to the arraylist
            } else {
                if (i == 0) { // Used only if, for some reason, the last (smallest) coin in the array was not able to be used, but the while loop is still running
                    i = coins.length - 1;
                }
                --i; // Moves to the next smallest coin in the array
            }
        }
        for (int j = 0; j < coinsUsed.size(); j++) { // Iterates through the arraylist to print the values
            if (j == coinsUsed.size() - 1) {
                System.out.println(coinsUsed.get(j));
            } else
                System.out.print(coinsUsed.get(j) + ", ");
        }
        return coinsUsed;
    }
}
