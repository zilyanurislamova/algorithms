package com.leetcode.rectangle.overlap;

public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long left = Math.max(rec1[0], rec2[0]);
        long top = Math.min(rec1[3], rec2[3]);
        long right = Math.min(rec1[2], rec2[2]);
        long bottom = Math.max(rec1[1], rec2[1]);
        long width = right - left;
        long height = top - bottom;
        return width > 0 && height > 0;
    }
}
