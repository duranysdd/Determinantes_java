package determinantematriz;

public class DeterminanteMatriz {
    

    static void imprimirMatriz(double[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    static double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;

        // Verificar si la matriz es cuadrada
        if (n != matriz[0].length) {
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }

        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j < n; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }

        // Calcular el determinante multiplicando los elementos de la diagonal principal
        double determinante = 1;
        for (int i = 0; i < n; i++) {
            determinante *= matriz[i][i];
        }

        return determinante;
    }

    public static void main(String[] args) {
        // Ejemplo de matriz 3x3
        double[][] matriz = {
            {2, -1, 3},
            {4, 1, -2},
            {1, 5, -3}
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        double determinante = calcularDeterminante(matriz);

        System.out.println("\nDeterminante: " + determinante);
    }
}

