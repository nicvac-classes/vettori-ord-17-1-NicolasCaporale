import java.util.Scanner;
import java.util.Random;

class Esercizio {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int n = Integer.parseInt(in.nextLine());
        int[] vett1 = new int[n];
        int[] vett2 = new int[n];
        int n1 = 0, n2 = 0;
        int i = 0;

        while (i < n) {
            int r = rnd.nextInt(n * 12);
            if (r % 2 == 0) {
                vett1[n1] = r;
                ++n1;
            } else {
                vett2[n2] = r;
                ++n2;
            }
            ++i;
        }

        bubbleSort(vett1, n1);
        bubbleSort(vett2, n2);

        System.out.println("Vettore dei pari ordinato:");
        visualizzaVettore(vett1, n1);
        System.out.println("Vettore dei dispari ordinato:");
        visualizzaVettore(vett2, n2);

        int[] fusione = new int[n1 + n2];
        int n3 = n1 + n2;
        merge(vett1, n1, vett2, n2, fusione, n3);

        System.out.println("Vettore fuso ordinato:");
        visualizzaVettore(fusione, n3);

        System.out.print("Inserisci un valore da cercare: ");
        int valore = in.nextInt();
        int pos = ricercaBinaria(fusione, n3, valore);
        if (pos != -1) {
            System.out.println("Valore trovato in posizione " + pos);
        } else {
            System.out.println("Valore non trovato");
        }
    }

    static void bubbleSort(int[] v, int n) {
        boolean scambiato = true;
        while (scambiato) {
            scambiato = false;
            for (int i = 0; i < n - 1; ++i) {
                if (v[i] > v[i + 1]) {
                    int temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    scambiato = true;
                }
            }
            --n;
        }
    }

    static void visualizzaVettore(int[] v, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    static void merge(int[] v1, int n1, int[] v2, int n2, int[] v3, int n3) {
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (v1[i] <= v2[j]) {
                v3[k] = v1[i];
                ++i;
            } else {
                v3[k] = v2[j];
                ++j;
            }
            ++k;
        }
        while (i < n1) {
            v3[k] = v1[i];
            ++i;
            ++k;
        }
        while (j < n2) {
            v3[k] = v2[j];
            ++j;
            ++k;
        }
    }

    static int ricercaBinaria(int[] v, int n, int x) {
        int inizio = 0, fine = n - 1;
        while (inizio <= fine) {
            int medio = (inizio + fine) / 2;
            if (v[medio] == x) {
                return medio;
            } else if (v[medio] < x) {
                inizio = medio + 1;
            } else {
                fine = medio - 1;
            }
        }
        return -1;
    }
}
