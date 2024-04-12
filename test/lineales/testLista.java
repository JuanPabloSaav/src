package lineales;
import java.util.Random;

import lineales.dinamicas.Lista;

public class testLista {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        int fase = 1;
        boolean exito = true;
        String testActual = "";
        do {
            switch (fase) {
                case 1:
                    testActual = "Insertar";
                    exito = testInsertar();
                    if (exito) {
                        System.out.println("Test Insertar exitoso");
                    }
                    break;
                case 2:
                    testActual = "Longitud";
                    exito = testLongitud();
                    if (exito) {
                        System.out.println("Test Longitud exitoso");
                    }
                    break;
                case 3:
                    testActual = "Vaciar";
                    exito = testVaciar();
                    if (exito) {
                        System.out.println("Test Vaciar exitoso");
                    }
                    break;
                case 4:
                    testActual = "esVacio";
                    exito = testEsVacio();
                    if (exito) {
                        System.out.println("Test esVacio exitoso");
                    }
                    break;
                case 5:
                    testActual = "Eliminar";
                    exito = testEliminar();
                    if (exito) {
                        System.out.println("Test Eliminar exitoso");
                    }
                    break;
                case 6:
                    testActual = "Localizar";
                    exito = testLocalizar();
                    if (exito) {
                        System.out.println("Test Localizar exitoso");
                    }
                    break;
                case 7:
                    testActual = "Recuperar";
                    exito = testRecupera();
                    if (exito) {
                        System.out.println("Test Recupera exitoso");
                    }
                    break;
                case 8:
                    testActual = "Clone";
                    exito = testClone();
                    if (exito) {
                        System.out.println("Test Clone exitoso");
                    }
                    break;
                case 9:
                    System.out.println("Todos los test han sido ejecutados con exito");
                    break;
                default:
                    System.out.println("Error inesperado");
                    fase = 10;
                    break;
            }
            if (!exito) {
                System.out.println("Ha ocurrido un error en el test " + testActual);
                break;
            }
            fase++;
        } while (exito && fase != 10);
        System.out.println("Cerrando...");
    }

    public static boolean testInsertar(){
        Lista listaTest = new Lista();
        boolean exito = true;
        System.out.println("Pila vacia: "+ listaTest.toString());
        for (int i = 1; i <= 10; i++) {
            if (!listaTest.insertar(i, i)) {
                exito = false;
                System.out.println("Error al insertar el elemento " + i);
                break;
            }
            System.out.println("Lista actual: "+ listaTest.toString());
        }
        return exito;
    }

    public static boolean testLongitud(){
        Lista listaTest = genLista();
        boolean exito = true;
        System.out.println("Se ha generado una lista de 10 elementos");
        if (listaTest.longitud() != 10) {
            exito = false;
        }
        return exito;
    }

    public static boolean testVaciar(){
        boolean exito = true;
        Lista listaTest = genLista();
        System.out.println("Lista antes de vaciar: "+ listaTest.toString());
        listaTest.vaciar();
        System.out.println("Lista despues de vaciar "+ listaTest.toString());
        if (!listaTest.esVacia()) {
            exito = false;
        }
        return exito;
    }

    public static boolean testEsVacio(){
        boolean exito = true;
        Lista listaTest = new Lista();
        if (!listaTest.esVacia()) {
            exito = false;
        }
        return exito;
        
    }

    public static Lista genLista(){
        Lista list = new Lista();
        for (int i = 1; i <=10; i++){
            list.insertar(i, i);
        }
        return list;
    }

    public static boolean testEliminar(){
        Lista listaTest = genLista();
        boolean exito = true;
        System.out.println("Lista antes de eliminar elementos: "+ listaTest.toString());
        while (!listaTest.esVacia()) {
            if (!listaTest.eliminar(1)) {
                exito = false;
                System.out.println("Ha ocurrido un error al eliminar el elemento de la posicion 1");
                break;
            }
            System.out.println("Lista actual: "+ listaTest.toString());
        }
        if (!listaTest.esVacia()) {
            exito = false;
            System.out.println("La lista no pudo eliminar uno o mas elementos");
        }
        return exito;
    }

    public static boolean testLocalizar(){
        boolean exito = true;
        Lista listaTest = genLista();
        Random rand = new Random();
        int elem = rand.nextInt(1, 10);
        System.out.println("Lista actual: "+ listaTest.toString());
        System.out.println("Se buscara el elemento "+ elem);
        if (listaTest.localizar(elem) != elem) {
            System.out.println("El metodo no pudo encontrar el elemento "+ elem
            + " aunque este se encuentre en la lista");
            exito = false;
        }
        return exito;
    }

    public static boolean testRecupera(){
        boolean exito = true;
        Lista listaTest = genLista();
        System.out.println("Lista actual: "+ listaTest.toString());
        System.out.println("Se espera recuperar el elemento 2 en la posicion 2");
        if (listaTest.recuperar(2).toString().equals("2")) {
            exito = false;
            System.out.println("El elemento recuperado no coincide con los esperado");
        }
        return exito;
    }

    public static boolean testClone(){
        boolean exito = true;
        Lista listaTest = genLista();
        System.out.println("Lista original: "+ listaTest.toString());
        Lista clon = listaTest.clone();
        System.out.println("Lista clon: "+ clon.toString());
        if (!clon.toString().equals(listaTest.toString())) {
            exito = false;
            System.out.println("La lista clon no es igual a la lista original");
        }
        return exito;
    }
}
