package ru.yandex.intern.A;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int[] volumes = new int[n];
        String[] volumesAsStrings = s.split(" ");
        for (int i = 0; i < volumes.length; i++) {
            volumes[i] = Integer.parseInt(volumesAsStrings[i]);
        }

        boolean isSorted = true;
        for (int i = 0; i < volumes.length - 1; i++) {
            if (volumes[i] > volumes[i + 1]) {
                isSorted = false;
                break;
            }
        }

        if (!isSorted) {
            System.out.println(-1);
            return;
        }

        int maxVolume = volumes[volumes.length - 1];
        int minVolume = volumes[0];
        System.out.println(maxVolume - minVolume);
    }
}
