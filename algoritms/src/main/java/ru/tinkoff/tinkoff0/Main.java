package ru.tinkoff.tinkoff0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String s1 = br.readLine();
            String s2 = br.readLine();
            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);
            int sum = i1 + i2;
            System.out.println(sum);
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
}
