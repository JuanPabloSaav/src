package lineales;

import lineales.dinamicas.Pila;

public class testPila {
    public static void main(String[] args) {
        Pila pilita = new Pila();

    }

    public static void apilar(Pila pilita){
        boolean error = false;
        for (int i = 0; i < 10; i++) {
            error = pilita.apilar(i);
            if (!error) {
                System.out.println("Elemento " + i + " no apilado");
                break;
            }
        }
        System.out.println((pilita.apilar(12)?"Elemento 12 apilado.":"Elemento 12 no apilado, pila llena."));
    }

    public static void desapilar(Pila pilita){
        Pila temp = pilita.clone();
        Object element;
        while (!temp.esVacia()) {
            element = temp.obtenerTope();
            temp.desapilar();
            System.out.println("El elemento "+ element.toString() + " fue desapilado");
        }
        if (!temp.desapilar()) {
            System.out.println("No se pudo desapilar el elemento porque la pila esta vacia");
        }
    }

    public static void vaciar(Pila pilita){
        Pila temp = pilita.clone();
        temp.vaciar();
        System.out.println(temp.esVacia()?"La pila esta vacia":"La pila no esta vacia");
    }

    public static void obtenerTopo(Pila pilita){
        Pila temp = pilita.clone();
        System.out.println("El tope es: "+ temp.obtenerTope().toString());
        temp.vaciar();
        System.out.println("El elemento de la pila vacia es: " + temp.obtenerTope());
    }
}