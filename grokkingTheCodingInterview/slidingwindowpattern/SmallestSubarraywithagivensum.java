package grokkingTheCodingInterview.slidingwindowpattern;

/**
 * Problem Statement #
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] 
or [1, 1, 6].
 * */

public class SmallestSubarraywithagivensum {

    public static void main(String[] args) {

        System.out.println(getMinArray(7,new int[]{2,1,5,2,3,2}));
        System.out.println(getMinArray(7,new int[]{2,1,5,2,3,2}));
        
    }
    
    public static int getMinArray(int s, int[] arr){
        int windowStart =0;
        int windowSum =0;
        int minLength = Integer.MAX_VALUE;

        for(int windowEnd = 0;windowEnd < arr.length;windowEnd++){
            windowSum +=arr[windowEnd];

            while(windowSum >= s){
                minLength = Math.min(minLength,windowEnd-windowStart + 1);
                windowSum -=arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ?0 :minLength;
    }
}

//Time Complexity
// The outer for loop runs for N elements O(N) . The Inner while loop runs only once for each element so O(N)
//O(N) = O(N+N) = O(2N) = O(N)