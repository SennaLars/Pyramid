package com.third;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the first sequence: ");
        int longitud1 = scanner.nextInt();
        int[] secuencia1 = new int[longitud1];

        System.out.println("Enter " + longitud1 + " elements for the first sequence:");
        for (int i = 0; i < longitud1; i++) {
            secuencia1[i] = scanner.nextInt();
        }

        System.out.print("Enter the length of the second sequence: ");
        int longitud2 = scanner.nextInt();
        int[] secuencia2 = new int[longitud2];

        System.out.println("Enter " + longitud2 + " elements for the second sequence:");
        for (int i = 0; i < longitud2; i++) {
            secuencia2[i] = scanner.nextInt();
        }

        boolean EsPosible = EsSubsecuencia(secuencia1, secuencia2);
        if (EsPosible) {
            System.out.println("It is possible to get the first sequence from the second sequence.");
        } else {
            System.out.println("It is not possible to get the first sequence from the second sequence.");
        }
    }

    public static boolean EsSubsecuencia(int[] secuencia1, int[] secuencia2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < secuencia1.length && index2 < secuencia2.length) {
            if (secuencia1[index1] == secuencia2[index2]) {
                index1++;
            }
            index2++;
        }

        return index1 == secuencia1.length;
    }
}
