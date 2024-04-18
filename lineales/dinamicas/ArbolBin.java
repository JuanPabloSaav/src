package lineales.dinamicas;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object elemPadre, boolean hIzquierdo){
        boolean exito = true;

        if (raiz == null) {
            raiz = new NodoArbol(elem, null, null);
        }else{

        }
    }

    private NodoArbol obtenerNodo(Object elem, NodoArbol raiz){
        NodoArbol nodo = null;

        if (raiz != null) {
            if (raiz.getElemento().equals(elem)) {
                nodo = raiz;
            }else{
                nodo = obtenerNodo(elem, raiz.getIzquierdo());
                if (nodo == null) {
                    nodo = obtenerNodo(elem, raiz.getDerecho());
                }
            }
        }
        return nodo;
    }
}
