package conjuntistas;

import conjuntistas.NodoBB;

public class ArbolBB {
    private NodoBB raiz;

    public ArbolBB(){
        this.raiz = null;
    }

    public boolean pertenece(Comparable elem){
        return perteneceAux(this.raiz, elem);
    }

    private boolean perteneceAux(NodoBB nodo, Comparable elem){
        boolean pertenece = false;
        if (nodo != null) {
            int compare = elem.compareTo(nodo.getElemento());
            if (compare == 0) {
                pertenece = true;
            }else if(compare < 0){
                perteneceAux(nodo.getIzquierdo(), elem);
            }else if(compare > 0){
                perteneceAux(nodo.getDerecho(), elem);
            }
        }
        return pertenece;
    }

    public boolean insertar(Comparable elem){
        return insertarAux(this.raiz, elem);
    }

    private boolean insertarAux(NodoBB nodo, Comparable elem){
        boolean insertado = false;
        if (nodo != null) {
            int comparacion = elem.compareTo(nodo.getElemento());
            if (comparacion == 0) {
                insertado = false;
            }else if(comparacion < 0){
                if (nodo.getIzquierdo() != null) {
                    insertarAux(nodo.getIzquierdo(), elem);
                }else{
                    nodo.setIzquierdo(new NodoBB(elem));
                    insertado = true;
                }
            }
        }
        return insertado;
    }
}
