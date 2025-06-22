package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequency {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,4};
        System.out.println("frequency map "+ getFrequency(arr));
    }
    public static Map<Integer,Integer> getFrequency(int[] arr) {
        Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
        for(int i = 0; i <= arr.length - 1; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0)+1);
        }
        return frequencyMap;
    }
    public static Map<Integer,Integer> getFrequencyOptimized(int[] arr) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num : arr) {
            frequencyMap.merge(num, 1, Integer::sum); // use merge instead of getOrDefault+put
        }
        return frequencyMap;
    }

    // Alternative using Java streams
    public static Map<Integer, Integer> getFrequencyOptimizedWithStream(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                        num -> num,
                        Collectors.summingInt(num -> 1)
                ));
    }
}
