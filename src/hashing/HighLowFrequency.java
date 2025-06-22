package hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


public class HighLowFrequency {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,6,5,3,7,3,8,3};
        Arrays.stream(highLowfrequency(arr)).forEach(System.out::println);
    }
    public static int[] highLowfrequency(int[] arr) {
        Map<Integer,Integer> freqMap = new TreeMap<>();
        for(int num:arr) {
            freqMap.merge(num,1, Integer::sum);
        }
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int highFreqElem = -1;
        int lowestFreqElem = -1;
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            int elem = entry.getKey();
            if(freq > maxFreq) {
                maxFreq = freq;
                highFreqElem = elem;
            }

            if(freq < minFreq) {
                minFreq = freq;
                lowestFreqElem = elem;
            }
        }
        return new int[]{highFreqElem,lowestFreqElem};
    }
}
