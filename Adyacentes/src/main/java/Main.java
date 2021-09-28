import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }


    public static void showMenu() {
        System.out.println("1- Mostrar pares adyacentes");
        System.out.println("2- Mostrar el mayor valor de producto ");
        System.out.println("3- Salir");
        System.out.println();
    }

    public static void menu() {

        int opcion;
        do {
            showMenu();
            opcion = input(1, 3);

            switch (opcion) {
                case 1:
                    mostrarArreglo(generarArreglo());
                    break;
                case 2:
                    System.out.println();
                    break;
            }
        } while (opcion != 3);
    }

    public static int[] generarArreglo() {
        Random r = new Random();
        int arreglo[] = new int[r.nextInt(9) + 2];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = r.nextInt(1000) - r.nextInt(1000);

        }
        return arreglo;

    }

    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
            System.out.println();
        }
    }

    public static int[] obtenerAdyacentes(int[] arreglo){
        int len=arreglo.length;
        int i=0,temp,prev;
//for sorting
        for(int j=0;j<=len-2;j++){
            for(int k=j+1;j<=len-1;j++){
                if(arreglo[j]>arreglo[k]){
                    temp=arreglo[j];
                    arreglo[j]=arreglo[k];
                    arreglo[k]=temp;
                }
            }
        }
return arreglo;
    }


    public static void mostrarParesAdyacentes () {
    }

    public static int mayorProductoAdyacentes () {
        return 0;
    }


    public static int input ( int bot, int top){
        Scanner intro = new Scanner(System.in);
        return err(intro.next(), bot, top);
    }


    public static int err (String input,int bot, int top){
        int in;
        try (Scanner intro = new Scanner(System.in)) {
            in = 0;
            try {
                in = validInt(Integer.parseInt(input), bot, top);
            } catch (Exception ex) {
                System.out.println("Favor ingresar Dígitos y no carácteres");
                in = err(intro.next(), bot, top);
            }
        }
        return in;
    }

    public static int validInt ( int in, int bot, int top){
        if (in < bot || in > top) {
            System.out.println("Favor ingresar un número entre " + bot + " y " + top);
            in = input(bot, top);
        }
        return in;
    }

}