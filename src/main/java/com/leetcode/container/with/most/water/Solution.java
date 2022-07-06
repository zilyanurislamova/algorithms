package com.leetcode.container.with.most.water;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,100,2,100,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int h = Math.min(height[left], height[right]); // min, because the height is limited by shortest vertical line
        int w = right - left; // longest width between first and last element
        int result = h * w; // volume between longest width
        while (left < right) { // two pointers
            if (height[left] <= height[right]) // move from the left if the left height is shorter or equals to right
                left++;
            else
                right--; // otherwise
            h = Math.min(height[left], height[right]); // calculate current height (min)
            w = right - left;
            int current = h * w;
            if (current > result) // update result
                result = current;
        }
        return result;
    }
}
