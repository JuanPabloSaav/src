package lineales.dinamicas;

public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Object getElemento() {
        return this.elem;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    public void setElemento(Object elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
