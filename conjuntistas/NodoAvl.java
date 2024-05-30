package conjuntistas;

public class NodoAvl {
    private Comparable elem;
    private int altura;
    private NodoAvl izquierdo;
    private NodoAvl derecho;

    public NodoAvl(Comparable elem){
        this.elem = elem;
        izquierdo = null;
        derecho = null;
        recalcularAltura();
    }

    public NodoAvl(Comparable elem, NodoAvl izquierdo, NodoAvl derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        recalcularAltura();
        //TODO: flopa
    }

    public Comparable getElem(){
        return this.elem;
    }

    public NodoAvl getIzquierdo(){
        return this.izquierdo;
    }

    public NodoAvl getDerecho(){
        return this.derecho;
    }

    public int getAltura(){
        return this.altura;
    }

    public void setElem(Comparable elem){
        this.elem = elem;
    }

    public void setIzquierdo(NodoAvl izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoAvl derecho){
        this.derecho = derecho;
    }

    public void recalcularAltura(){
        int alturaIzquierdo = 0, alturaDerecho = 0;
        if (izquierdo != null) {
            alturaIzquierdo = recalcularAlturaAux(izquierdo, alturaIzquierdo);
        }
        if (derecho != null) {
            alturaDerecho = recalcularAlturaAux(derecho, alturaDerecho);
        }
        if (alturaIzquierdo > alturaDerecho) {
            this.altura = alturaIzquierdo;
        }else{
            this.altura = alturaDerecho;
        }
    }

    private int recalcularAlturaAux(NodoAvl nodo, int alturaActual){
        if (nodo != null) {
            int alturaDerecho = 0, alturaIzquierdo = 0;
            if (nodo.izquierdo != null) {
                alturaIzquierdo = recalcularAlturaAux(nodo.izquierdo, alturaActual+1);
            }
            if (nodo.derecho != null) {
                alturaDerecho = recalcularAlturaAux(nodo.derecho, alturaActual+1);
            }
            if (alturaIzquierdo > alturaDerecho) {
                alturaActual = alturaIzquierdo;
            }else{
                alturaActual = alturaDerecho;
            }
        }
        return alturaActual;
    }

    public String toString(){
        String cadena = "Padre: "+elem.toString() + "-> hijo izquierdo: ";
        if (izquierdo != null) {
            cadena += izquierdo.getElem().toString() + " ";
        }
        cadena += "hijo derecho: ";
        if (derecho != null) {
            cadena += derecho.getElem().toString() + " ";
        }
        return cadena;
    }
}
