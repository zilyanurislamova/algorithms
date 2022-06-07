package com.leetcode.the.k.weakest.rows.in.the.matrix;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {0, 0, 0}, {0, 1, 1}};
        System.out.println(Arrays.toString(kWeakestRows(matrix, 3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] ints = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0, count = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    ints[i] = count;
                }
            }
        }
        int[] newInts = Arrays.copyOf(ints, ints.length);
        Arrays.sort(newInts);
        for (int i = 0; i < newInts.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (newInts[i] == ints[j]) {
                    newInts[i] = j;
                    ints[j] = -1;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(newInts, 0, k);
    }
}
