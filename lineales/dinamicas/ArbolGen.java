package lineales.dinamicas;

public class ArbolGen {
    private NodoArbolGen raiz;
    
    public ArbolGen(){
        raiz = null;
    }
    
    public boolean insertar(Object elem, Object elemPadre){
        boolean exito = false;
        if (elemPadre == null) {
            raiz = new NodoArbolGen(elemPadre, raiz.getIzquierdo(), null);
            exito = true;
        }else{
            NodoArbolGen nodoPadre = buscarNodo(elemPadre, this.raiz); 
            if (nodoPadre.getIzquierdo() == null) {
                nodoPadre.setIzquierdo(new NodoArbolGen(elemPadre, null, null));
                exito = true;
            }else{
                NodoArbolGen aux = nodoPadre.getHermanoDerecho();
                while (aux != null) {
                    aux = aux.getHermanoDerecho();
                }
                //TODO: revisar porque seguro el null no es una referencia
                aux = new NodoArbolGen(elemPadre, null, null);
                exito = true;
            }
        }
        return exito;
    }

    public NodoArbolGen buscarNodo(Object elemPadre, NodoArbolGen nodo){
        NodoArbolGen aux = null;
        if (nodo != null) {
            if (nodo.getElemento().toString().equals(elemPadre.toString())) {
                aux = nodo;
            }else{
                aux = buscarNodo(elemPadre, nodo.getIzquierdo());
                if (aux == null) {
                    aux = buscarNodo(elemPadre, nodo.getHermanoDerecho());
                }
            }
        }
        return aux;
    }

    public boolean insertarPorPosicion(Object elem, int posPadre){
        boolean exito = false;
        if (posPadre == 0) {
            if (this.raiz == null) {
                raiz = new NodoArbolGen(elem, null, null);
            }
        }else{
            int[] posPadreAux = new int[1];
            posPadreAux[0] = posPadre;
            NodoArbolGen nodoPadre = buscarNodoPorPos(posPadreAux, this.raiz);
            if (nodoPadre.getIzquierdo() != null) {
                nodoPadre.setIzquierdo(new NodoArbolGen(elem, null, null));
                exito = true;
            }else{
                NodoArbolGen aux = nodoPadre;
                while (aux != null) {
                    aux = aux.getHermanoDerecho();
                }
                //TODO: revisar porque seguro que el null no es una referencia
                aux = new NodoArbolGen(elem, null, null);
                exito = true;
            }
        }
        return exito;
    }

    public NodoArbolGen buscarNodoPorPos(int[] posPadre, NodoArbolGen nodo){
        NodoArbolGen aux = null;
        if (nodo != null) {
            if (posPadre[0] == 1) {
                aux = nodo;
            }else{
                aux = buscarNodoPorPos(posPadre, nodo.getIzquierdo());
                if (aux == null) {
                    aux = buscarNodoPorPos(posPadre, nodo.getHermanoDerecho());
                }
            }
        }
        return aux;
    }
}
