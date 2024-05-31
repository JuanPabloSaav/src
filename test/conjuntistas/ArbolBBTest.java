package conjuntistas;

import lineales.dinamicas.Lista;

public class ArbolBBTest {
    
    public static void main(String[] args) {
        listarRangoTest();
    }

    public static void testPertenece(){
        ArbolBB arbol = new ArbolBB();
        System.out.println(arbol.pertenece(1)); // false
        arbol.insertar(1);
        System.out.println(arbol.pertenece(1)); // true
        System.out.println(arbol.pertenece(2)); // false

        arbol.insertar(2);
        System.out.println(arbol.pertenece(2)); // true

        arbol.insertar(3);
        System.out.println(arbol.pertenece(3)); // true

        arbol.insertar(4);
        System.out.println(arbol.pertenece(4)); // true

        arbol.insertar(5);
        System.out.println(arbol.pertenece(5)); // true

        arbol.insertar(6);
        System.out.println(arbol.pertenece(6)); // true

        arbol.insertar(7);
        System.out.println(arbol.pertenece(7)); // true

        arbol.insertar(8);
        System.out.println(arbol.pertenece(8)); // true
        
        arbol.insertar(9);
        System.out.println(arbol.pertenece(9)); // true

        arbol.insertar(10);
        System.out.println(arbol.pertenece(10)); // true

        arbol.insertar(11);
        System.out.println(arbol.pertenece(11)); // true

    }

    public static void listarTest(){
        ArbolBB arbol = new ArbolBB();
        System.out.println("flopa");
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(4);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.insertar(7);
        arbol.insertar(8);
        Lista lista = arbol.listar();
        for (int i = 1; i <= lista.longitud(); i++) {
            System.out.println(lista.recuperar(i));
        }
    }

    public static void listarRangoTest(){
        ArbolBB arbol = new ArbolBB();
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(6);
        arbol.insertar(8);
        
        Lista lista = arbol.listarRango(3, 7);
        for (int i = 1; i <= lista.longitud(); i++) {
            System.out.println(lista.recuperar(i));
        }
    }
}
