package lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class TestCadenas {
    public static void main(String[] args) {
        System.out.println("TestCadenas");
        Cola c1 = new Cola();
        c1.poner('A');
        c1.poner('B');
        c1.poner('C');
        c1.poner('#');
        c1.poner('D');
        c1.poner('E');
        c1.poner('#');
        c1.poner('F');
        c1.poner('G');
        Cola c3 = generar(c1);
        System.out.println(c3.toString());
    }
    
    public static Cola generar(Cola c1){
        Cola c2 = new Cola();
        Cola colaClon = c1.clone(); 
        while (!colaClon.esVacia()) {
            generarAux(colaClon, c2);
            colaClon.sacar();
        }
        return c2;
    }

    private static void generarAux(Cola clon, Cola c2){
        Cola aux = new Cola();
        Pila pilaAux = new Pila();
        while (!clon.esVacia() &&!clon.obtenerFrente().equals('#') ) {
            aux.poner(clon.obtenerFrente());
            c2.poner(clon.obtenerFrente());
            pilaAux.apilar(clon.obtenerFrente());
            clon.sacar();
        }
        while (!pilaAux.esVacia()) {
            c2.poner(pilaAux.obtenerTope());
            pilaAux.desapilar();
        }
        while (!aux.esVacia()) {
            c2.poner(aux.obtenerFrente());
            aux.sacar();
        }
        if (!clon.esVacia()) {
            c2.poner('#');
        }
        
    }


}
