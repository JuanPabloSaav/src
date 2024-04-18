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
            NodoArbol nodoPadre = obtenerNodo(elemPadre, raiz);
            if (nodoPadre != null) {
                if (hIzquierdo && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elem, null, null));
                }else if (!hIzquierdo && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(elem, null, null));
                }else{
                    exito = false;
                }
            }else{
                exito = false;
            }
        }
        return exito;
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
