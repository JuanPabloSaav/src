package conjuntistas;

@SuppressWarnings({"rawtypes", "unchecked"})
public class  Avl {
    private NodoAvl raiz;

    public Avl(){
        raiz = null;
    }

    public boolean insertar(Comparable elem){
        boolean exito = false;
        if (elem != null & raiz != null) {
            exito = insertarAux(elem, this.raiz);
            raiz = reBalanceo(raiz);
        }else if(raiz == null){
            raiz = new NodoAvl(elem);
            exito = true;
        }
        return exito;
    }

    private boolean insertarAux(Comparable elem, NodoAvl nodo){
        boolean exito = false;
        if (nodo != null) {
            if (elem.compareTo(nodo.getElem())>0) {
                if (nodo.getDerecho() != null) {
                    insertarAux(elem, nodo.getDerecho());
                    nodo.setDerecho(reBalanceo(nodo.getDerecho()));
                }else{
                    nodo.setDerecho(new NodoAvl(elem));
                    exito = true;
                }
            }else if (elem.compareTo(nodo.getElem())<0) {
                if (nodo.getIzquierdo() != null) {
                    insertarAux(elem, nodo.getIzquierdo());
                    nodo.setIzquierdo(reBalanceo(nodo.getIzquierdo()));
                }else{
                    nodo.setIzquierdo(new NodoAvl(elem));
                    exito = true;
                }
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elem){
        boolean[] eliminado = {false};
        if (raiz != null) {
            this.raiz = eliminarAux(raiz, elem, eliminado);
            this.raiz = reBalanceo(raiz);
        }
        return eliminado[0];
    }
    
    //TODO: REVISAR
    private NodoAvl eliminarAux(NodoAvl nodo, Comparable elem, boolean[] eliminado){
        if (nodo != null) {
            int comparacion = elem.compareTo(nodo.getElem());
            if (comparacion < 0) {
                nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), elem, eliminado));
                nodo.setIzquierdo(nodo.getDerecho());
            }else if(comparacion > 0){
                nodo.setDerecho(eliminarAux(nodo.getDerecho(), elem, eliminado));
                nodo.setDerecho(reBalanceo(nodo.getDerecho()));
            }else{
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    nodo = null;
                    eliminado[0] = true;
                }else if(nodo.getIzquierdo() != null && nodo.getDerecho() == null){
                    nodo = nodo.getIzquierdo();
                    eliminado[0] = true;
                }else if(nodo.getIzquierdo() == null && nodo.getDerecho() != null){
                    nodo = nodo.getDerecho();
                    eliminado[0] = true;
                }else{
                    NodoAvl reemplazo = buscarReemplazo(nodo.getIzquierdo());
                    nodo.setElem(reemplazo.getElem());
                    nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), reemplazo.getElem(), eliminado));
                    eliminado[0] = true;
                }
            }
        }
        return nodo;
    }

    private NodoAvl buscarReemplazo(NodoAvl nodo){
        NodoAvl reemplazo = nodo;
        if (nodo.getDerecho() != null) {
            reemplazo = buscarReemplazo(nodo.getDerecho());
        }
        return reemplazo;
    }

    //TODO: revisar
    private NodoAvl reBalanceo(NodoAvl nodoHijo){
        int balanceo = balanceo(nodoHijo);
        if (balanceo > 1) {
            int balanceoHijo = balanceo(nodoHijo.getIzquierdo());
            if (balanceoHijo >= 0) {
                nodoHijo = rotarDerecha(nodoHijo);
            }else{
                nodoHijo.setDerecho(rotarIzquierda(nodoHijo.getDerecho()));
                nodoHijo = rotarDerecha(nodoHijo);
            }
        }else if(balanceo < -1){
            int balanceoHijo = balanceo(nodoHijo.getDerecho());
            if (balanceoHijo <= 0) {
                nodoHijo = rotarIzquierda(nodoHijo);
            }else{
                nodoHijo.setIzquierdo(rotarDerecha(nodoHijo.getIzquierdo()));
                nodoHijo = rotarIzquierda(nodoHijo);
            }
        }
        return nodoHijo;
    }

    private int balanceo(NodoAvl nodo){
        int balanceo = 0;
        if (nodo != null) {
            balanceo = altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
        }
        return balanceo;
    }

    private int altura(NodoAvl nodo){
        int altura = -1;
        if (nodo != null) {
           nodo.recalcularAltura(); 
           altura = nodo.getAltura();
        }
        
        return altura;
    }

    private NodoAvl rotarIzquierda(NodoAvl nodo){
        NodoAvl h = nodo.getDerecho();
        NodoAvl hh = h.getIzquierdo();
        h.setIzquierdo(nodo);
        nodo.setDerecho(hh);
        return h;
    }

    private NodoAvl rotarDerecha(NodoAvl nodo){
        NodoAvl h = nodo.getIzquierdo();
        NodoAvl hh = h.getDerecho();
        h.setDerecho(nodo);
        nodo.setIzquierdo(hh);
        return h;
    }
}
