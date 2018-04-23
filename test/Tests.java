import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testIfBothIllegal() { //Checks if the right exception is thrown if both the array and initial value are illegal
        int array[] = {};
        int in = 0;
        Exception e = assertThrows(IllegalArgumentException.class, () -> {DynamicParams.coinChange(array,in);});
        assertEquals("Both coins and init have illegal inputs", e.getMessage());
    }

    @Test
    public void testIfInitLessThanOne(){ // Checks if the program throws the right exception when the input value is less than one
        int[] arr = {1,5,10,25};
        int in = -1;
        Exception e = assertThrows(IllegalArgumentException.class, () -> {DynamicParams.coinChange(arr,in);});
        assertEquals("Init needs to be at least 1", e.getMessage());
    }

    @Test
    public void testEmptyArray(){ // Checks to make sure the program throws the right exception when the array is empty
        int arr[] = {};
        int in = 1;
        Exception e = assertThrows(IllegalArgumentException.class, () -> {DynamicParams.coinChange(arr,in);});
        assertEquals("You need at least one type of coin to be in the array", e.getMessage());
    }

    @Test
    public void testZeroInArray(){ // Checks to make sure the program throws the right exception when the array is empty
        int arr[] = {1,0};
        int in = 1;
        Exception e = assertThrows(IllegalArgumentException.class, () -> {DynamicParams.coinChange(arr,in);});
        assertEquals("There cannot be any values less than 1 in the coins array", e.getMessage());
    }

    @Test
    public void seeIfItWorks(){ // Checks if it does the thing
        int arr[] = {25,10,5,1};
        ArrayList<Integer> toCompare = new ArrayList<Integer>();
        toCompare.add(25);
        toCompare.add(10);
        toCompare.add(5);
        toCompare.add(1);
        toCompare.add(1);
        int in = 26;
        assertEquals(toCompare, DynamicParams.coinChange(arr,in));
    }
}


