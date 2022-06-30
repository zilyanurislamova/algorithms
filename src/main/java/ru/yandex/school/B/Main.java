package ru.yandex.school.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static class Vacancy {
        public String name;
        public int wanted;

        public Vacancy (String name, int wanted) {
            this.name = name;
            this.wanted = wanted;
        }
    }

    public static class Candidate implements Comparable<Candidate> {
        public String name;
        public String vacancy;
        public int rating;
        public int fine;

        public Candidate(String name, String vacancy, int rating, int fine) {
            this.name = name;
            this.vacancy = vacancy;
            this.rating = rating;
            this.fine = fine;
        }

        @Override
        public int compareTo(Candidate other) {
            if (this.rating == other.rating)
                return Integer.compare(this.fine, other.fine);
            return -1 * Integer.compare(this.rating, other.rating);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //число вакансий
        scanner.nextLine();

        Vacancy[] vacancies = new Vacancy[n]; //вакансия и максимум претендентов
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(",");
            vacancies[i] = new Vacancy(s[0], Integer.parseInt(s[1]));
        }

        int k = scanner.nextInt(); //число участников
        scanner.nextLine();

        Candidate[] candidates = new Candidate[k];
        for (int i = 0; i < k; i++) {
            String[] s = scanner.nextLine().split(",");
            candidates[i] = new Candidate(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
        }

        Arrays.sort(candidates);

        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String vacancy = vacancies[i].name;
            int wanted = vacancies[i].wanted;
            int applicants = 0;
            for (int j = 0; j < k && applicants < wanted; j++) {
                if (vacancy.equals(candidates[j].vacancy)) {
                    winners.add(candidates[j].name);
                    applicants++;
                }
            }
        }

        Collections.sort(winners);

        for (int i = 0; i < winners.size(); i++) {
            System.out.println(winners.get(i));
        }
    }
}
