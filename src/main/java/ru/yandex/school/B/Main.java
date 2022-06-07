package ru.yandex.school.B;

import java.util.Arrays;
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
        int n = scanner.nextInt(); //число открытых вакансий
        scanner.nextLine();

        Vacancy[] vacancies = new Vacancy[n]; //вакансия и максимум претендентов
        int winnerCount = 0;
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(",");
            vacancies[i] = new Vacancy(s[0], winnerCount += Integer.parseInt(s[1]));
        }

        int k = scanner.nextInt(); //число участников
        scanner.nextLine();

        Candidate[] candidates = new Candidate[k];
        for (int i = 0; i < k; i++) {
            String[] s = scanner.nextLine().split(",");
            candidates[i] = new Candidate(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
        }

        Arrays.sort(candidates);

        String[] winners = new String[winnerCount];
        int winnerIndex = 0;
        for (int i = 0; i < n; i++) {
            String vacancy = vacancies[i].name;
            int wanted = vacancies[i].wanted;
            int applicants = 0;
            for (int j = 0; j < k && applicants < wanted; j++) {
                if (vacancy.equals(candidates[j].vacancy)) {
                    winners[winnerIndex] = candidates[j].name;
                    winnerIndex++;
                    applicants++;
                }
            }
        }

        Arrays.sort(winners);

        for (int i = 0; i < winnerCount; i++) {
            System.out.println(winners[i]);
        }
    }
}
