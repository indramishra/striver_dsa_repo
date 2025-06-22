package leetDSA;

import java.util.ArrayList;
import java.util.List;

public class CheckSubSequence {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        boolean checkSub = isSubSequence(s, t);
        System.out.println(checkSub);
    }
    public static boolean isSubSequence(String s, String t) {
        char[] charArrSuper = t.toCharArray();
        char[] charArrSub = s.toCharArray();
        List<Integer> checkSubArr = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && charArrSub[j] == charArrSuper[i]) {
                checkSubArr.add(i);
                j++;
            }
        }

        if(charArrSub.length != checkSubArr.size()) {
            return false;
        }
        return checkSorted(checkSubArr);
    }

    public static boolean checkSorted(List<Integer> arr) {
        for(int i=0; i < arr.size(); i++) {
            if(i+1 < arr.size() && arr.get(i) > arr.get(i+1)) {
                return false;
            }
        }
        return true;
    }

}
