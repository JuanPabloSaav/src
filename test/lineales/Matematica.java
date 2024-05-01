package lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
public class Matematica {
    public static void main(String[] args) {
        System.out.println("TEST DE VERIFICAR BALANCEO");
        Cola q = new Cola();
        q.poner("{");
        q.poner("[");
        q.poner("(");
        q.poner(")");
        q.poner("[");
        q.poner("]");
        q.poner("]");
        q.poner("}");
        System.out.println(verificarBalanceo(q));

    }

    public static boolean verificarBalanceo(Cola q){
        Pila pilaExpresiones = new Pila();
        boolean balanceada = true;
        while (!q.esVacia()) {
            Object aux = q.obtenerFrente();
            if (aux.toString().equals("{") || aux.toString().equals("[")
            || aux.toString().equals("(")) {
                pilaExpresiones.apilar(aux);
            }
            if (aux.toString().equals("}") || aux.toString().equals("]")
            || aux.toString().equals(")")) {
                String aux2 = pilaExpresiones.obtenerTope().toString();
                switch (aux2) {
                    case "{":
                        aux2 = "}";
                        break;
                    case "[":
                        aux2 = "]";
                        break;
                    case "(":
                        aux2 = ")";
                        break;
                }
                if (!aux2.equals(aux.toString())) {
                    balanceada = false;
                    break;
                }
                pilaExpresiones.desapilar();
            }
            q.sacar();
        }
        return balanceada;
    }
}
