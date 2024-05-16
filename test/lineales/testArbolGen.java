package lineales;

import lineales.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

public class testArbolGen {
    public static void main(String[] args) {
        testClone();
    }

    public static void testInsertar(){
        ArbolGen arbol = new ArbolGen();
        System.out.println(arbol.insertar("flopa", null));
        System.out.println("flopeando");
        System.out.println(arbol.insertar("unflopa", "flopa"));
        System.out.println("flopeando pero el hijo de flopa");
        System.out.println(arbol.insertar("otroflopa", "flopa"));
        System.out.println("flopeando pero el hermano de unflopa");
        System.out.println(arbol.insertar("otroflopa2", "flopa"));
        System.out.println("flopeando pero el hijo de unflopa");
        System.out.println(arbol.insertar("otroflopa3", "unflopa"));
        System.out.println("flopeando pero el hermano de otroflopa3");
        System.out.println(arbol.insertar("otroflopa4", "unflopa"));
        System.out.println("flopeando pero el hijo de otroflopa3");
        System.out.println(arbol.insertar("otroflopa5", "otroflopa3"));
        System.out.println("flopatrackeo a otroflopa3");
        System.out.println(arbol.pertenece("otroflopa3"));
        System.out.println("flopatrackeo a otroflopa5");
        System.out.println(arbol.pertenece("otroflopa5"));
        System.out.println("flopatrackeo a otroflopa4");
        System.out.println(arbol.pertenece("otroflopa4"));
        System.out.println("flopatrackeo a otroflopa2");
        System.out.println(arbol.pertenece("otroflopa2"));
        System.out.println("flopatrackeo a otroflopa");
        System.out.println(arbol.pertenece("otroflopa"));
        System.out.println("flopatrackeo a unflopa");
        System.out.println(arbol.pertenece("unflopa"));
        System.out.println("flopatrackeo a unflpa");
        System.out.println(arbol.pertenece("unflpa"));
    }

    public static void testAncestro(){
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("flopa", null);
        arbol.insertar("unflopa", "flopa");
        arbol.insertar("otroFlopa", "flopa");
        arbol.insertar("otroflopa2", "unflopa");
        System.out.println("buscando otroflopa2");
        Lista flopa = arbol.ancestros("otroflopa2");
        System.out.println("Mostrando lista:");
        for (int i = 1; i <= flopa.longitud(); i++) {
            System.out.println(flopa.recuperar(i).toString() + " pos: "+ i);
        }
        System.out.println("Mostrando todos los elementos en preOrden");
        System.out.println(arbol.toString());
    }

    public static void testAltura(){
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("flopa", null);
        arbol.insertar("unflopa", "flopa");
        arbol.insertar("otroFlopa", "flopa");
        arbol.insertar("otroflopa2", "unflopa");
        System.out.println("calculando altura");
        System.out.println("Altura real: 2 \nAltura Arbol: "+ arbol.altura());
    }

    public static void testNivel() {
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("flopa", null);
        arbol.insertar("unflopa", "flopa");
        arbol.insertar("otroFlopa", "flopa");
        arbol.insertar("algunflopa", "unflopa");
        arbol.insertar("otroflopa2", "algunflopa");
        System.out.println("buscando otroflopa2");
        System.out.println("Nivel esperado: 2 \nNivel arbol: "+ arbol.nivel("otroflopa2"));
    }

    public static void testPadre(){
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("flopa", null);
        arbol.insertar("unflopa", "flopa");
        arbol.insertar("otroFlopa", "flopa");
        arbol.insertar("algunflopa", "unflopa");
        arbol.insertar("otroflopa2", "unflopa");
        System.out.println("buscando unflopa desde otroflopa2");
        System.out.println(arbol.padre("otroflopa2").toString());
    }

    public static void testNiveles(){
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("flopa", null);
        arbol.insertar("unflopa", "flopa");
        arbol.insertar("otroFlopa", "flopa");
        arbol.insertar("algunflopa", "unflopa");
        arbol.insertar("otroflopa2", "unflopa");
        Lista lista = arbol.listarPorNiveles();
        for (int i = 1; i < lista.longitud(); i++) {
            System.out.println(lista.recuperar(i));
        }
        System.out.println("La lista deberia ser: \nflopa, unflopa, otroFlopa, algunflopa, otroflopa2");
    }

    public static void testClone(){
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("flopa", null);
        arbol.insertar("unflopa", "flopa");
        arbol.insertar("otroFlopa", "flopa");
        arbol.insertar("algunflopa", "unflopa");
        arbol.insertar("otroflopa2", "unflopa");
        ArbolGen clon = arbol.clon();
        System.out.println("Arbol original: " + arbol.toString());
        System.out.println("Arbol clon: " + clon.toString());
        System.out.println("peru!");
    }
}
