package test.lineales;

import lineales.dinamicas.ArbolBin;

public class testArbolBin {
    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        System.out.println("Insertar 1 en raiz: " + arbol.insertarPorPosicion(1, 0));
        System.out.println("Insertar 2 en raiz: " + arbol.insertarPorPosicion(2, 0));
        System.out.println("Insertar 3 en raiz: " + arbol.insertarPorPosicion(3, 0));
        System.out.println("Insertar 4 en 2: " + arbol.insertarPorPosicion(4, 1));
        System.out.println("Insertar 5 en 2: " + arbol.insertarPorPosicion(5, 1));
        System.out.println("Insertar 6 en 3: " + arbol.insertarPorPosicion(6, 2));
        System.out.println("Insertar 7 en 3: " + arbol.insertarPorPosicion(7, 2));
        System.out.println("\n");
        System.out.println(arbol.toString());
    }
}
