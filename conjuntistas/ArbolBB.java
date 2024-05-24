package conjuntistas;

import lineales.dinamicas.Lista;

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

    public Lista listar(){
        Lista lista = new Lista();
        return listarAux(lista, this.raiz);
    }

    private Lista listarAux(Lista lista, NodoBB nodo){
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                listarAux(lista, nodo.getIzquierdo());
            }
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            if (nodo.getDerecho() != null) {
                listarAux(lista, nodo.getDerecho());
            }
        }
        return lista;
    }

    public boolean esVacio(){
        return this.raiz == null;
    }

    public Lista listarRango(Comparable min, Comparable max){
        Lista rango = new Lista();
        if (this.raiz != null && min != null && max != null) {
            if (raiz.getElemento().compareTo(min) < 0) {
                listarMin(min, raiz.getIzquierdo(), rango);
            }else if(raiz.getElemento().compareTo(min) > 0){
                listarMin(min, raiz, rango);
            }
        }  
    }

    private void listarMin(Comparable min, NodoBB nodo, Lista rango){
        if (nodo != null) {
            int comparacion = min.compareTo(nodo.getElemento());
            if (comparacion == 0) {
                rango.insertar(nodo.getElemento(), rango.longitud());
            }else if(comparacion < 0){
                listarMin(min, nodo.getIzquierdo(), rango);
            }else if(comparacion > 0){
                listarMin(min, nodo.getDerecho(), rango);
            }
        }
    }
}
