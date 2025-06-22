package hashing;

import java.util.Map;
import java.util.TreeMap;

public class MostFrequentElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4};
        int k = 5;
        System.out.println("frequency of the most frequent element: "+findMostFrequentElement(arr,k));
    }
    public static int findMostFrequentElement(int[] nums, int k) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0; // Can be initialized to 1 if N >= 1
        for (Map.Entry<Integer, Integer> targetEntry : freqMap.entrySet()) {
            int targetValue = targetEntry.getKey();
            int currentK = k; // Operations budget for this target
            int currentFreq = 0; // Frequency achieved for this target

            // Iterate through elements <= targetValue in decreasing order
            // TreeMap allows navigating keys
            for (Map.Entry<Integer, Integer> currentEntry : freqMap.descendingMap().entrySet()) {
                int currentValue = currentEntry.getKey();
                int currentCount = currentEntry.getValue();

                // We only care about numbers less than or equal to the target
                if (currentValue > targetValue) {
                    continue; // Skip numbers larger than the target
                }

                // Cost to transform one 'currentValue' into 'targetValue'
                int costPerElement = targetValue - currentValue;

                // If the cost is 0, it's the target itself, include all its frequency
                if (costPerElement == 0) {
                    currentFreq += currentCount; // Add all occurrences of the target
                    // We've added the target itself, no cost incurred yet for it
                    continue; // Move to potentially smaller numbers
                }

                // Cost to transform ALL occurrences of 'currentValue' into 'targetValue'
                long totalCostForCurrentValue = (long)costPerElement * currentCount; // Use long to prevent overflow

                // If we can afford to transform all occurrences of 'currentValue'
                if (currentK >= totalCostForCurrentValue) {
                    currentK -= totalCostForCurrentValue;
                    currentFreq += currentCount;
                } else {
                    // We can only afford a portion of the occurrences of 'currentValue'
                    int affordableCount = (int)(currentK / costPerElement);
                    currentFreq += affordableCount;
                    currentK = 0; // Used up remaining k
                    // Since we used up k, we can't transform any more smaller numbers
                    break;
                }
            }
            // Update the maximum frequency found so far
            maxFrequency = Math.max(maxFrequency, currentFreq);
        }
        return maxFrequency;
    }
}
