package ru.yandex.intern.C;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int[] ints = new int[n];
        int[] unsortedInts = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(secondLine[i]);
            ints[i] = num;
            unsortedInts[i] = num;
        }

        Arrays.sort(ints);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = ints[i];
            if (map.containsKey(current)) {
//                System.out.print(map.get(current) + " ");
                continue;
            }
//            int x = Arrays.binarySearch(ints, current);
            int minDistances = 0;
            int nextIndex = i + 1;
            int prevIndex = i - 1;
            for (int j = 0, next, prev; j < k; j++) {
                try {
                    next = Math.abs(current - ints[nextIndex]);
                    try {
                        prev = Math.abs(current - ints[prevIndex]);
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
                    prev = Math.abs(current - ints[prevIndex]);
                    minDistances += prev;
                    prevIndex--;
                }
            }
            map.put(current, minDistances);
//            System.out.print(minDistances + " ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(map.get(unsortedInts[i]) + " ");
        }
    }
}

//                if (nextIndex < n)
//                    next = Math.abs(current - ints[nextIndex]);
//                else
//                    next = Integer.MAX_VALUE;
//                if (prevIndex >= 0)
//                    prev = Math.abs(current - ints[prevIndex]);
//                else
//                    prev = Integer.MAX_VALUE;
//                if (next <= prev) {
//                    minDistances += next;
//                    nextIndex++;
//                } else {
//                    minDistances += prev;
//                    prevIndex--;
//                }

//                try {
//                    next = Math.abs(ints[x] - ints[nextIndex]);
//                } catch (ArrayIndexOutOfBoundsException ignored){
//                }
//                try {
//                    prev = Math.abs(ints[x] - ints[prevIndex]);
//                } catch (ArrayIndexOutOfBoundsException ignored){
//                }


//                try {
//                    prev = Math.abs(ints[x] - ints[prevIndex]);
//                    next = Math.abs(ints[x] - ints[nextIndex]);
//                    if (next < prev) {
//                        minDistances += next;
//                        nextCount++;
//                    }
//                    else {
//                        minDistances += prev;
//                        prevCount++;
//                    }
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    if (nextIndex >= n) {
//                        minDistances += prev;
//                        prevCount++;
//                    }
//                    else {
//                        next = Math.abs(ints[x] - ints[nextIndex]);
//                        minDistances += next;
//                        nextCount++;
//                    }
//                }