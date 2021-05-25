package grokkingTheCodingInterview.slidingwindowpattern;

/*
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
*/

public class MaximumSumSubarrayofSizeK {

    public static void main(String[] args) {
        System.out.println("The max sum of the Array is : " +maxSumSubArrayOfSizeK(new int[]{2,3,4,1,5},2));
        System.out.println("The max sum of the Array is : " +findMaxSumSubArray(2,new int[]{2,3,4,1,5}));   
    }

    //My Solution
    private static int maxSumSubArrayOfSizeK(int[] arr,int k) {
        if(arr.length < k){
            return -1;
        }

        int maxSum = 0;
        int startIndex = 0;
        int endIndex = k-1;

        while(endIndex < arr.length){
            int sum =0;
            for(int i = startIndex;i<=endIndex;i++){
                sum +=arr[i];
            }

            maxSum = sum > maxSum ? sum :maxSum;
            startIndex++;
            endIndex++;
        }

        return maxSum;
        
    }

    //best solution

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
          windowSum += arr[windowEnd]; // add the next element
          // slide the window, we don't need to slide if we've not hit the required window size of 'k'
          if (windowEnd >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= arr[windowStart]; // subtract the element going out
            windowStart++; // slide the window ahead
          }
        }
    
        return maxSum;
      }
    
}
