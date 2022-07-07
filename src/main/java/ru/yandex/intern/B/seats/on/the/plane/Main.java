package ru.yandex.intern.B.seats.on.the.plane;

import java.util.*;

public class Main {
    public static int num;
    public static String side;
    public static String position;
    public static String success = "Passengers can take seats: ";
    public static String fail = "Cannot fulfill passengers requirements";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] rows = new String[n];
        for (int i = 0; i < n; i++) {
            rows[i] = scanner.nextLine();
        }

        int m = scanner.nextInt();
        scanner.nextLine();
        String[] seats = new String[m];
        ArrayList<String[]> rowsAfterGroupSat = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] groupDetails = scanner.nextLine().split(" ");
            num = Integer.parseInt(groupDetails[0]);
            side = groupDetails[1];
            position = groupDetails[2];

            for (int r = 0; r < rows.length; r++) {
                if (rows[r].contains("X"))
                    rows[r] = rows[r].replaceAll("X", "#");
            }

            for (int j = 0; j < rows.length; j++) {
                if (num == 1) {
                    if (side.equals("left") && position.equals("window") && rows[j].startsWith(".")) {
                        seats[i] = j + 1 + "A";
                        rows[j] = rows[j].replaceFirst(".", "X");
                        break;
                    }
                    else if (side.equals("left") && position.equals("aisle") && rows[j].contains("._")) {
                        seats[i] = j + 1 + "C";
                        rows[j] = rows[j].replace("._", "X_");
                        break;
                    }
                    else if (side.equals("right") && position.equals("window") && rows[j].endsWith(".")) {
                        seats[i] = j + 1 + "F";
                        rows[j] = rows[j].substring(0, 6) + "X";
                        break;
                    }
                    else if (side.equals("right") && position.equals("aisle") && rows[j].contains("_.")) {
                        seats[i] = j + 1 + "D";
                        rows[j] = rows[j].replace("_.", "_X");
                        break;
                    }
                }

                else if (num == 2) {
                    if (side.equals("left") && position.equals("window") && rows[j].startsWith("..")) {
                        seats[i] = (j + 1) + "A" + " " + (j + 1) + "B";
                        rows[j] = rows[j].replaceFirst("..", "XX");
                        break;
                    }
                    else if (side.equals("right") && position.equals("window") && rows[j].endsWith("..")) {
                        seats[i] = (j + 1) + "E" + " " + (j + 1) + "F";
                        rows[j] = rows[j].substring(0, 5) + "XX";
                        break;
                    }
                    else if (side.equals("left") && position.equals("aisle") && rows[j].contains(".._")) {
                        seats[i] = (j + 1) + "B" + " " + (j + 1) + "C";
                        rows[j] = rows[j].replace(".._", "XX_");
                        break;
                    }
                    else if (side.equals("right") && position.equals("aisle") && rows[j].contains("_..")) {
                        seats[i] = (j + 1) + "D" + " " + (j + 1) + "E";
                        rows[j] = rows[j].replace("_..", "_XX");
                        break;
                    }
                }

                else if (num == 3) {
                    if (side.equals("left") && rows[j].contains("..._")) {
                        seats[i] = (j + 1) + "A" + " " + (j + 1) + "B" + " " + (j + 1) + "C";
                        rows[j] = rows[j].replace("..._", "XXX_");
                        break;
                    }
                    else if (side.equals("right") && rows[j].contains("_...")) {
                        seats[i] = (j + 1) + "D" + " " + (j + 1) + "E" + " " + (j + 1) + "F";
                        rows[j] = rows[j].replace("_...", "_XXX");
                        break;
                    }
                }
            }
            rowsAfterGroupSat.add(Arrays.copyOf(rows, rows.length));
        }

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null)
                System.out.println(fail);
            else {
                System.out.println(success + seats[i]);
                for (int j = 0; j < rowsAfterGroupSat.get(i).length; j++) {
                    System.out.println(rowsAfterGroupSat.get(i)[j]);
                }
            }
        }
    }
}
