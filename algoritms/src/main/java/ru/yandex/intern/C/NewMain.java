package ru.yandex.intern.C;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NewMain {
    public static class Pair implements Comparable<Pair> {
        public final int index;
        public final int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            //multiplied to -1 as the author need descending sort order
            return Integer.valueOf(this.value).compareTo(other.value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, Integer.parseInt(secondLine[i]));
        }

        Arrays.sort(pairs);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = pairs[i].value;
            if (map.containsKey(current)) {
                System.out.print(map.get(current) + " ");
                continue;
            }
//            int x = i;
            int minDistances = 0;
            int nextIndex = i + 1;
            int prevIndex = i - 1;
            for (int j = 0, next, prev; j < k; j++) {
                try {
                    next = Math.abs(current - pairs[nextIndex].value);
                    try {
                        prev = Math.abs(current - pairs[prevIndex].value);
                        if (next <= prev) {
                            minDistances += next;
                            nextIndex++;
                        } else {
                            minDistances += prev;
                            prevIndex--;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        minDistances += next;
                        nextIndex++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    prev = Math.abs(current - pairs[prevIndex].value);
                    minDistances += prev;
                    prevIndex--;
                }
            }
            map.put(current, minDistances);
            System.out.print(minDistances + " ");
        }
    }
}
