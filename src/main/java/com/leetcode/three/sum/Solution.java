package com.leetcode.three.sum;

import java.util.*;

// time limit exceeded on 308th test
public class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int compliment = - nums[i] - nums[j];
                List<Integer> list = new ArrayList<>(List.of(compliment, nums[i], nums[j]));
                Collections.sort(list);
                if (map.containsKey(compliment) && !result.contains(list)){
                    result.add(list);
                }
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
