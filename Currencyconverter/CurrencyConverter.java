package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base currency (e.g., USD, INR, EUR): ");
        String from = sc.next().toUpperCase();

        System.out.print("Enter target currency (e.g., USD, INR, EUR): ");
        String to = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        try {
            double rate = getExchangeRate(from, to);
            double converted = amount * rate;

            System.out.println(amount + " " + from + " = " + converted + " " + to);
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate!");
            e.printStackTrace();
        }
    }

    private static double getExchangeRate(String from, String to) throws Exception {
        String urlStr = "https://api.frankfurter.app/latest?from=" + from + "&to=" + to;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        int status = conn.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(
            (status >= 200 && status < 300) ? conn.getInputStream() : conn.getErrorStream()
        ));

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        System.out.println("API Response: " + response.toString());

        JSONObject json = new JSONObject(response.toString());
        return json.getJSONObject("rates").getDouble(to);
    }
}
