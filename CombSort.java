import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static void combSort(int[] arr) {
        int n = arr.length;
        double factorReduccion = 1.3; 
        int gap = n;
        boolean swap = true;
        // Contador para mostrar la iteración
        int iteration = 1;

        // Mientras gap sea 1 y no haya intercambios
        while (gap > 1 || swap) {
            gap = (int) (gap / factorReduccion);
            if (gap < 1) {
                gap = 1;
            }

            swap = false;

            // Comparacion e intercambios
            for (int i = 0; i + gap < n; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Intercambio de posicion 
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swap = true;
                }
            }

            // El arreglo despues de cada iteracion
            System.out.print("Iteración " + iteration + ":");
            imprimirArreglo(arr);
            iteration++;
        }
    }

    public static void imprimirArreglo(int[] arr) {
        // bucle for-each
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Ingrese la cantidad de números a ordenar: ");
        entrada = bufer.readLine();
        int n = Integer.parseInt(entrada);
        int[] arreglo = new int[n];

        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            entrada = bufer.readLine();
            arreglo[i] = Integer.parseInt(entrada);
        }

        System.out.println("\nArreglo original:");
        imprimirArreglo(arreglo);

        combSort(arreglo);

        System.out.println("\nArreglo ordenado:");
        imprimirArreglo(arreglo);

    }

}