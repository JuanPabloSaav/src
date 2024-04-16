package lineales;

import java.util.Scanner;

import lineales.dinamicas.Lista;

public class pruebaLista {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion = 0;
        do {
            System.out.println("1. Concatenar");
            System.out.println("2. Comprobar");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Iniciando prueba de concatenar...");
                    Lista listaTemp1 = new Lista();
                    System.out.println("ingresar 3 numeros: ");
                    listaTemp1.insertar(sc.nextInt(),1);
                    listaTemp1.insertar(sc.nextInt(),2);
                    listaTemp1.insertar(sc.nextInt(),3);
                    Lista listaTemp2 = new Lista();
                    listaTemp2.insertar(sc.nextInt(), 1);
                    listaTemp2.insertar(sc.nextInt(), 2);
                    listaTemp2.insertar(sc.nextInt(), 3);
                    Lista listaConcatenada = concatenar(listaTemp1, listaTemp2);
                    System.out.println("Lista concatenada: "+ listaConcatenada.toString());
                    listaTemp1.vaciar();
                    listaTemp2.vaciar();
                    break;
                case 2:
                    System.out.println("Iniciando prueba de comprobar...");
                    Lista listaTemp3 = new Lista();
                    System.out.println("Ingresar los elementos de la lista: ");
                    System.out.println("Ingresar -1 para finalizar");
                    int elem = sc.nextInt();
                    int i = 1;
                    while (elem != -1) {
                        listaTemp3.insertar(elem, i);
                        i++;
                        elem = sc.nextInt();
                    }
                    if (comprobar(listaTemp3)) {
                        System.out.println("La lista cumple con las condiciones");
                        
                    }else{
                        System.out.println("La lista no cumple con las condiciones");
                    }
                    break;
                case 3:
                    
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public static Lista concatenar(Lista l1, Lista l2){
        Lista listaConcatenada = l1.clone();
        int longitudL2 = l2.longitud();
        int longitudL1 = l1.longitud();
        int i = 1;
        while (i <= longitudL2) {
            listaConcatenada.insertar(l2.recuperar(i), (longitudL1+i));
            i++;
        }
        return listaConcatenada;
    }

    public static boolean comprobar(Lista l1){
        boolean cumple = true;
        int posInicio = 1;
        String cadena1 = obtenerCadena(l1, posInicio);
        posInicio = (cadena1.length()+2);
        String cadena2 = obtenerCadena(l1, posInicio);
        if (cadena1.equals(cadena2)) {
            posInicio = ((posInicio+posInicio)-1);
            if (!cadena1.equals(obtenerCadenaInvertida(l1, posInicio))) {
                cumple = false;
            }
        }else{
            cumple = false;
        }
        return cumple;
    }

    private static String obtenerCadena(Lista l1, int posInicio){
        int longitud = l1.longitud();
        String cadena = "";
        Object elem = l1.recuperar(posInicio);
        posInicio++;
        while(((int)elem != 0) && (posInicio <= longitud)){
            cadena += elem.toString();
            elem = l1.recuperar(posInicio);
            posInicio++;
        }
        return cadena;
    }

    private static String obtenerCadenaInvertida(Lista l1, int posInicio){
        int i = l1.longitud();
        String cadena = "";
        Object elem = l1.recuperar(i);
        while (i >= posInicio) {
            cadena += elem;
            i--;
            elem = l1.recuperar(i);
        }
        return cadena;
    }

    public static Lista invertir(Lista l1){
        Lista listaInvertida = new Lista();
        int longitud = l1.longitud();
        int j = 1;
        for (int i = longitud; i >= 1; i--) {
            listaInvertida.insertar(l1.recuperar(i), j);
            j++;
        }
        return listaInvertida;
    }
}
