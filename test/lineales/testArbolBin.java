package lineales;

import lineales.dinamicas.ArbolBin;
import lineales.dinamicas.Lista;

public class testArbolBin {
    public static void main(String[] args) {
        testFrontera();
    }

    public static void testPatron(){
        Lista listica = new Lista();
        listica.insertar(1, 1);
        listica.insertar(2, 2);
        listica.insertar(3, 3);
        listica.insertar(4, 4);
        listica.insertar(5, 5);
        listica.insertar(8, 6);
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(1, null, true);
        arbol.insertar(2, 1, true);
        arbol.insertar(3, 2, false);
        arbol.insertar(4, 3, false);
        arbol.insertar(5, 4, false);
        arbol.insertar(6, 3, true);
        arbol.insertar(7, 4, true);
        arbol.insertar(8, 7, false);
        System.out.println("TEST DE PATRON");
        System.out.println(arbol.verificarPatron(listica));

    }

    public static void testFrontera(){
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(1, null, true);
        arbol.insertar(2, 1, true);
        arbol.insertar(3, 2, false);
        arbol.insertar(4, 3, false);
        arbol.insertar(5, 4, false);
        arbol.insertar(6, 3, true);
        arbol.insertar(7, 4, true);
        arbol.insertar(8, 7, false);
        Lista list = arbol.frontera();
        System.out.println(list.toString());
    }
}
