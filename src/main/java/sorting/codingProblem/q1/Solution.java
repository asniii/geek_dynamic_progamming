package sorting.codingProblem.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringJoiner;

public class Solution {

    public static void main(String args[]){
        int arr[] = {2,3,4,3,4,5,6,7,2,3,4};

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
            } else{
                map.put(arr[i],1);
            }
        }

        StringJoiner stringJoiner = new StringJoiner(",");
        ArrayList<Item> list = new ArrayList<>();
        for(Integer i: map.keySet()){
            list.add(new Item(i,map.get(i)));
        }

        Collections.sort(list,(o1, o2) -> {
            return o2.freq - o1.freq;
        });

        for(Item i : list){
            for(int j = 0;j<i.freq;j++){
                stringJoiner.add(Integer.toString(i.data));
            }
        }
        System.out.println(stringJoiner.toString());
    }
}
