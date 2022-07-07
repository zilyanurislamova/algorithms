package ru.yandex.intern.C.k.min.distances;

import java.util.*;

public class New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(secondLine[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ints[i])) {
                System.out.println(map.get(ints[i]) + " ");
                continue;
            }
            int minDistance = 0;
            int minDistances = 0;
            for (int j = 0, steps = 0; j < n && steps < k; j++) {
                if (i != j && Math.abs(ints[i] - ints[j]) == minDistance) {
                    minDistances += minDistance;
                    steps++;
                }
                if (j == n - 1) {
                    minDistance++;
                    j = -1;
                }
            }
            map.put(ints[i], minDistances);
            System.out.print(minDistances + " ");
        }
    }
}
