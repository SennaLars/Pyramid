package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the pyramid: ");
        int NumFilas = scanner.nextInt();

        int Numeros = NumFilas * (NumFilas + 1) / 2;
        int[] NumMetidos = new int[Numeros];

        System.out.println("Enter " + Numeros + " numbers separated by spaces:");
        for (int i = 0; i < Numeros; i++) {
            NumMetidos[i] = scanner.nextInt();
        }

        int[][] pyramid = buildOrderedPyramid(NumMetidos, NumFilas);

        for (int i = 0; i < NumFilas; i++) {
            for (int j = 0; j < 2 * NumFilas - 1; j++) {
                if (j >= NumFilas - i - 1 && j <= NumFilas + i - 1) {
                    System.out.printf("%2d ", pyramid[i][j]);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] buildOrderedPyramid(int[] NumMetidos, int NumFilas) {
        int[][] pyramid = new int[NumFilas][2 * NumFilas - 1];

        if (NumMetidos.length != NumFilas * (NumFilas + 1) / 2) {
            throw new CannotBuildPyramidException("Cannot build pyramid with given input numbers");
        }

        Arrays.sort(NumMetidos);

        int index = NumMetidos.length - 1; // Start from the largest value
        for (int i = NumFilas - 1; i >= 0; i--) {
            int start = NumFilas - i - 1;
            int end = NumFilas + i - 1;

            for (int j = start; j <= end; j += 2) {
                pyramid[i][j] = NumMetidos[index];
                index--;
            }
        }

        return pyramid;
    }
}

class CannotBuildPyramidException extends RuntimeException {
    public CannotBuildPyramidException(String message) {
        super(message);
    }
}
