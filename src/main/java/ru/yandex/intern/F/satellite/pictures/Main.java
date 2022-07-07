package ru.yandex.intern.F.satellite.pictures;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<int[]> coordinates = new ArrayList<>();
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            String[] xy = scanner.nextLine().split(" ");
            int x1 = Integer.parseInt(xy[0]);
            int y1 = Integer.parseInt(xy[1]);
            int x2 = Integer.parseInt(xy[2]);
            int y2 = Integer.parseInt(xy[3]);
            coordinates.add(new int[]{x1, y1, x2, y2});
            output[i] = Math.abs((x2 - x1)*(y2 - y1));
            for (int j = 1; j <= i; j++) {
                int[] prevCoordinates = coordinates.get(i - j);
                int x1prev = prevCoordinates[0];
                int y1prev = prevCoordinates[1];
                int x2prev = prevCoordinates[2];
                int y2prev = prevCoordinates[3];
                if (x1 >= x1prev && x2 <= x2prev && y1 >= y1prev && y2 <= y2prev) {
                    output[i - j] -= output[i];
                    x1prev += x1 - x1prev;
                    y1prev += y1 - y1prev;
                    x2prev += x2prev - x2;
                    y2prev = y2 - y1;
                    coordinates.set(i - j, new int[]{x1prev, y1prev, x2prev, y2prev});
                }
                else if (x1 >= x1prev && x2 <= x2prev && y2 <= y2prev) {
                    output[i - j] -= Math.abs((x2 - x1)*(y2 - y1prev));
                }
            }
        }

//        for (int i = 1; i <= n; i++) {
//            int[] xy = coordinates.get(i - 1);
//            for (int y = xy[1]; y <= xy[3]; y++) {
//                for (int x = xy[0]; x <= xy[2]; x++) {
//                    if (y < 0 && x < 0)
//
//                    else if (y < 0 && x > 0)
//
//                    else if (y > 0 && x > 0)
//
//                    else if (y > 0 && x < 0)
//
//                }
//            }
//        }


        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
