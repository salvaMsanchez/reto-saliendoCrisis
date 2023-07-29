package salva.saliendoCrisis;

import java.util.ArrayList;

public class Main {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {

        in = new java.util.Scanner(System.in);

        int numMuestras = -1;
        Boolean rangoMuestras = false;
        do {
            int numMuestrasInterno = in.nextInt();
            if (0 < numMuestrasInterno && numMuestrasInterno <= 100) {
                rangoMuestras = true;
                numMuestras = numMuestrasInterno;
            } else if (numMuestrasInterno == 0) {
                rangoMuestras = true;
                numMuestras = numMuestrasInterno;
            }
        } while (!rangoMuestras);

        if (numMuestras == 0) {
            return false;
        } else {
            ArrayList<Integer> valoresEconomicos = new ArrayList<>();
            for (int i = 0; i < numMuestras; i++) {

                Boolean numNegativo = false;
                while (!numNegativo) {
                    int valorEconomico = in.nextInt();
                    if (valorEconomico >= 0 && valorEconomico <= 10000000) {
                        numNegativo = true;
                        valoresEconomicos.add(valorEconomico);
                    }
                }

            }

            Boolean indicadorCrisis = comprobarAscendencia(valoresEconomicos);
            if (indicadorCrisis) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            return true;
        }
    }

    // Método para comprobar que los valores económicos del ArrayList sean ascendentes en cantidad.
    private static boolean comprobarAscendencia(ArrayList<Integer> valoresEconomicos) {

        Boolean elementosIguales = comprobarRepeticionValores(valoresEconomicos);
        if (elementosIguales) {
            return false;
        }

        for (int i = 0; i < valoresEconomicos.size(); i++) {
            if (i == valoresEconomicos.size() - 1) {
                return true;
            } else if (valoresEconomicos.get(i) > valoresEconomicos.get(i + 1)) {
                return false;
            }
        }

        return true;

    }

    // Método para comprobar si todos los elementos son iguales dentro del ArrayList de valores económicos.
    private static boolean comprobarRepeticionValores(ArrayList<Integer> valoresEconomicos) {
        int primerElemento = valoresEconomicos.get(0);
        for (int i = 1; i < valoresEconomicos.size(); i++) {
            if (valoresEconomicos.get(i) != primerElemento) {
                return false; // En cuanto se encuentra un elemento diferente, se devuelve false
            }
        }
        return true; // Si el bucle termina sin encontrar elementos diferentes, todos son iguales
    }

    public static void main(String args[]) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

}