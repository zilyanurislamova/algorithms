package com.leetcode.rectangle.area;

public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int width1 = ax2 - ax1;
        int height1 = ay2 - ay1;
        int width2 = bx2 - bx1;
        int height2 = by2 - by1;
        int left = Math.max(ax1, bx1);
        int top = Math.min(ay2, by2);
        int right = Math.min(ax2, bx2);
        int bottom = Math.max(ay1, by1);
        int width = right - left;
        int height = top - bottom;
        int s1;
        if (width1 <= 0 || height1 <= 0)
            s1 = 0;
        else
            s1 = width1 * height1;
        int s2;
        if (width2 <= 0 || height2 <= 0)
            s2 = 0;
        else
            s2 = width2 * height2;
        int s;
        if (width <= 0 || height <= 0)
            s = 0;
        else
            s = width * height;
        return  s1 + s2 - s;
    }
}
