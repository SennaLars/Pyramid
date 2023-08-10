package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Define exchange rates (base currency is USD)
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        // Add more exchange rates as needed
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get the user input
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the source currency (USD or EUR): ");
            String DivisaActual = scanner.next().toUpperCase();

            System.out.print("Enter the target currency (USD or EUR): ");
            String DivisaObjetivo = scanner.next().toUpperCase();

            // Perform the conversion
            double CantidadConvertida = convertCurrency(amount, DivisaActual, DivisaObjetivo);

            // Display the result
            System.out.println(amount + " " + DivisaActual + " is equal to " + CantidadConvertida + " " + DivisaObjetivo);

            scanner.close();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static double convertCurrency(double amount, String DivisaActual, String DivisaObjetivo) {
        double sourceRate = exchangeRates.getOrDefault(DivisaActual, 0.0);
        double targetRate = exchangeRates.getOrDefault(DivisaObjetivo, 0.0);

        // Check if both source and target currencies are available in the exchange rates map
        if (sourceRate == 0.0 || targetRate == 0.0) {
            throw new IllegalArgumentException("Invalid source or target currency.");
        }

        // Perform the conversion
        return (amount / sourceRate) * targetRate;
    }
}

