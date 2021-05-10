package com.company;

import java.util.HashMap;

public class MicrosoftQuestions {
    //2,4,5,7,8 = 9
    public int[] twoSum(int[] x, int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<x.length; i++){
            int diff = target - x[i];
            if (map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i ;

            }
            map.put(x[i], i);
        }
        return result;
    }


}
