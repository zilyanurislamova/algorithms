package com.leetcode.container.with.most.water;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,100,2,100,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int h = Math.min(height[left], height[right]);
        int w = right - left;
        int result = h * w;
        while (w >= 1) {
            int leftH = height[left];
            int rightH = height[right];
            if (height[left] < height[right] && height[left + 1] > height[left]) {
                leftH = height[left + 1];
                left++;
            }
            else if (height[right] < height[left] && height[right - 1] > height[right]) {
                rightH = height[right - 1];
                right--;
            }
            else if (height[left] < height[right]){
                leftH = height[left + 1];
                left++;
            }
            else {
                rightH = height[right - 1];
                right--;
            }
            h = Math.min(leftH, rightH);
            w = right - left;
            int current = h * w;
            if (current > result)
                result = current;
        }
        return result;
    }
}
