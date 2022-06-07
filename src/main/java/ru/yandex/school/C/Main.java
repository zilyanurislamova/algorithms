package ru.yandex.school.C;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static final String NAME_CONTAINS = "NAME_CONTAINS";
    public static final String PRICE_GREATER_THAN = "PRICE_GREATER_THAN";
    public static final String PRICE_LESS_THAN = "PRICE_LESS_THAN";
    public static final String DATE_BEFORE = "DATE_BEFORE";
    public static final String DATE_AFTER = "DATE_AFTER";

    public static class Product implements Comparable<Product> {
        public long id;
        public String name;
        public long price;
        public String date;

        public Product(long id, String name, long price, String date) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.date = date;
        }

        @Override
        public int compareTo(Product other) {
            return Long.compare(this.id, other.id);
        }

        @Override
        public String toString() {
            return String.format("{\"id\": %d, \"name\": %s, \"price\": %d, \"date\": %s}", this.id, this.name, this.price, this.date);
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String products = scanner.nextLine();
        HashMap<String, String> filters = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String[] s = scanner.nextLine().split(" ");
            filters.put(s[0], s[1]);
        }

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(products);
        Iterator iterator = jsonArray.iterator();
        ArrayList<Product> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            Product product = new Product((Long) jsonObject.get("id"), jsonObject.get("name").toString(), (Long) jsonObject.get("price"), jsonObject.get("date").toString());
            if (product.name.toLowerCase().contains(filters.get(NAME_CONTAINS).toLowerCase())
                    && product.price >= Integer.parseInt(filters.get(PRICE_GREATER_THAN))
                    && product.price <= Integer.parseInt(filters.get(PRICE_LESS_THAN))
                    && LocalDate.parse(product.date, formatter).isAfter(LocalDate.parse(filters.get(DATE_AFTER), formatter))
                    && LocalDate.parse(product.date, formatter).isBefore(LocalDate.parse(filters.get(DATE_BEFORE), formatter))) {
                list.add(product);
            }
        }

        Collections.sort(list);

        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1)
                System.out.print(list.get(i).toString() + ",");
            else
                System.out.print(list.get(i).toString() + "]");
        }
    }
}
