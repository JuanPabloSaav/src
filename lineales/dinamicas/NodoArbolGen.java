package lineales.dinamicas;

public class NodoArbolGen {
    private Object elem;
    private NodoArbolGen izquierdo;
    private NodoArbolGen hermanoDerecho;

    public NodoArbolGen(Object elem, NodoArbolGen izquierdo, NodoArbolGen hermanoDerecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.hermanoDerecho = hermanoDerecho;
    }

    public Object getElemento() {
        return this.elem;
    }

    public NodoArbolGen getIzquierdo() {
        return this.izquierdo;
    }

    public NodoArbolGen getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    public void setElemento(Object elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoArbolGen izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setHermanoDerecho(NodoArbolGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }
}
