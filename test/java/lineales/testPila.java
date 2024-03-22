package lineales;

import lineales.dinamicas.Pila;
import java.util.Scanner;

public class testPila {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion;
        Pila pila = new Pila();
        Scanner scanner = new Scanner(System.in);
        do {
            if (pila.esVacia()) {
                System.out.println("Estado de pila: vacía");
            }else{
                System.out.println("Estado de pila: no vacía");
            }
            System.out.println("Menu Test Pila");
            System.out.println("0. Generar pila llena de numeros");
            System.out.println("1. Apilar numeros");
            System.out.println("2. Desapilar");
            System.out.println("3. Obtener tope");
            System.out.println("4. Vaciar pila");
            System.out.println("5. toString de pila");
            System.out.println("6. Clonar pila");
            System.out.println("7. Verificar si una pila llena de numeros es capicua");
            System.out.println("8. generar pila llena de cadenas");
            System.out.println("9. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    genPilaNum(pila);
                    break;
                case 1:
                    System.out.println("Ingrese el elemento a apilar");
                    apilar(pila, scanner.next());
                    break;
                case 2:
                    desapilar(pila);
                    break;
                case 3:
                    obtenerTope(pila);
                    break;
                case 4:
                    vaciar(pila);
                    break;
                case 5:
                    System.out.println(pila.toString());
                    break;
                case 6:
                    clonar(pila);
                    break;
                case 7:
                    Pila tempPila = new Pila();
                    System.out.println("Ingrese el tamaño maximo de la pila");
                    int tamaño = scanner.nextInt();
                    System.out.println("Generando pila llena de numeros no capicua");
                    genPilaNum(tempPila);
                    verificarPilaCapicua(tempPila);
                    System.out.println("Generando pila llena de numeros capicua");
                    tempPila.vaciar();
                    genPilaCapicua(tempPila, tamaño);
                    verificarPilaCapicua(tempPila);
                    break;
                case 8:
                    genPilaCadenas(pila);
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (opcion != 9);
        scanner.close();
    }

    public static void apilar(Pila pila, String elemento){
        Scanner sc = new Scanner(System.in);
        Object elementoFinal;
        int opcion;
        do{
            System.out.println("1. Ingresar elemento como string");
            System.out.println("2. Ingresar el elemento como int");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    elementoFinal = elemento;
                    break;
                case 2:
                    elementoFinal = Integer.parseInt(elemento);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion != 1 && opcion != 2);
        if (pila.apilar(elemento)) {
            System.out.println("Elemento apilado correctamente");
        } else{
            System.out.println("La pila esta llena, no se puede apilar el elemento");
        }
    }

    public static void desapilar(Pila pila){
        if (pila.desapilar()) {
            System.out.println("Elemento desapilado correctamente");
        } else{
            System.out.println("No hay elementos para desapilar");
        }
    }

    public static void  obtenerTope(Pila pila){
        Object tope = pila.obtenerTope();
        if (tope != null) {
            System.out.println("Tope de la pila: " + tope.toString());
        } else{
            System.out.println("La pila está vacía");
        }
    }

    public static void vaciar(Pila pila){
        pila.vaciar();
        System.out.println("Pila vaciada");
    }

    public static void clonar(Pila pila){
        Pila clon = pila.clone();
        System.out.println("Pila clonada: "+ clon.toString());
    }

    public static void genPilaNum(Pila pila){
        int i = 0;
        while(i < 10 && pila.apilar(i)){
            i++;
        }
    }

    public static void verificarPilaCapicua(Pila pila){
        Pila clon = pila.clone();
        Pila pilaInversa = new Pila();
        while (!clon.esVacia()) {
            pilaInversa.apilar(clon.obtenerTope());
            clon.desapilar();
        }
        if (pila.toString().equals(pilaInversa.toString())) {
            System.out.println("La pila es capicua");
        } else {
            System.out.println("La pila no es capicua");
        }
    }

    public static void genPilaCapicua(Pila pila, int tamaño){
        int resto = tamaño%2;
        int tamañoMitad = tamaño/2;
        int i = 0;
        while (i < tamañoMitad) {
            i++;
            pila.apilar(i);
        }
        if (resto != 0) {
            pila.apilar(i+resto);
        }
        while (i > 0) {
            pila.apilar(i);
            i--;
        }
        System.out.println("Pila generada: "+ pila.toString());
    }

    public static void genPilaCadenas(Pila pila){
        int i = 0;
        while(i < 10){
            pila.apilar("cadena"+i);
            i++;
        }
    }
}
