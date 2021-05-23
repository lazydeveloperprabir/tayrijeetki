package grokkingTheCodingInterview.slidingwindowpattern;

import java.util.ArrayList;
import java.util.Arrays;

public class ContigousArrayOfSpecifiedSizeArray {

    //My solution
    private static void getContigousArray(int[] arr,int size) {

        Double sum =0d;
        int count = 0;
        int start = 0;
        int nextIndex = 0;
        ArrayList<Double> respList = new ArrayList<Double>();
        while(start <arr.length-size){
            if(count < size) {
                sum =sum + arr[start];
                count++;
                start++;
            }else{
                respList.add(sum/size);
                sum = 0d;
                count = 0;
                start = nextIndex +1;
                nextIndex++;
            }
            
        }
        System.out.println("The contigous array is :" + respList.toString());
        
    }

    //BruteForce
public static double[] findAverages(int K, int[] arr) {
    double[] result = new double[arr.length - K + 1];
    for (int i = 0; i <= arr.length - K; i++) {
      // find sum of next 'K' elements
      double sum = 0;
      for (int j = i; j < i + K; j++)
        sum += arr[j];
      result[i] = sum / K; // calculate average
    }

    return result;
  }

    public static double[] findAveragesOptimal(int K, int[] arr) {
      double[] result = new double[arr.length - K + 1];
      double windowSum = 0;
      int windowStart = 0;
      for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd]; // add the next element
        // slide the window, we don't need to slide if we've not hit the required window size of 'k'
        if (windowEnd >= K - 1) {
          result[windowStart] = windowSum / K; // calculate the average
          windowSum -= arr[windowStart]; // subtract the element going out
          windowStart++; // slide the window ahead
        }
      }
  
      return result;
    }

    public static void main(String[] args) {
        double[] result = ContigousArrayOfSpecifiedSizeArray.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));

        double[] result1 = ContigousArrayOfSpecifiedSizeArray.findAveragesOptimal(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result1));
    }
}
