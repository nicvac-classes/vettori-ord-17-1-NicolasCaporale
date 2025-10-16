//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().
    public static void main(String args[])
    {
        Scanner in = new Scanner( System.in );
        int n = Integer.parseInt(in.nextLine());
        
        int[] vett1 = new int[n];
        int[] vett2 = new int[n];
        int i = 0;
        int n1(0), n2(0);
        int r;

        while (i < n)
        {
            r = Math.random(n*12);

            if(r % 2 == 0)
            {
                vett1[n1] = r;
                ++n1;
            }else{
                vett2[n2] = r;
                ++n2;
            }
            ++i;
        }
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md