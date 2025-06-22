package leetDSA;

import java.util.Map;

public class RomanToDecimal {

    public static void main(String[] args) {
        String roman = "XIV";
        int decimal = romanToInt(roman);
        System.out.println(decimal);
    }
    public static int romanToInt(String s) {
        int romanToInt = 0;
       Map<String, Integer> romanIntMap = Map.of("I",1,"V",5,"X",10,"L",50,"C",100,"D",500,"M",1000);
       for(int i=0; i < s.length(); i++) {
           String s1 = String.valueOf(s.charAt(i));
           if(i  < (s.length() - 1) && romanIntMap.containsKey(s1) && (romanIntMap.get(String.valueOf(s.charAt(i + 1))) > romanIntMap.get(s1))) {
               romanToInt -= romanIntMap.get(s1);
           } else {
               romanToInt += romanIntMap.get(s1);
           }
       }
        return romanToInt;

    }
}
