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
                pertenece = perteneceAux(nodo.getIzquierdo(), elem);
            }else if(compare > 0){
                pertenece = perteneceAux(nodo.getDerecho(), elem);
            }
        }
        return pertenece;
    }

    public boolean insertar(Comparable elem){
        boolean exito = false;
        if (this.raiz == null) {
            raiz = new NodoBB(elem);
            exito = true;
        }else{
            exito = insertarAux(this.raiz, elem);
        }
           return exito;
    }

    private boolean insertarAux(NodoBB nodo, Comparable elem){
        boolean insertado = false;
        if (nodo != null) {
            int comparacion = elem.compareTo(nodo.getElemento());
            if (comparacion < 0) {
                if (nodo.getIzquierdo() == null) {
                    nodo.setIzquierdo(new NodoBB(elem));
                    insertado = true;
                }else{
                    insertarAux(nodo.getIzquierdo(), elem);
                }
            }else if(comparacion > 0){
                if (nodo.getDerecho() == null) {
                    nodo.setDerecho(new NodoBB(elem));
                    insertado = true;
                }else{
                    insertarAux(nodo.getDerecho(), elem);
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

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        Lista listaRango = new Lista();
        return listarRangoAux(this.raiz, elemMinimo, elemMaximo, listaRango);
    }

    private Lista listarRangoAux(NodoBB nodo, Comparable elemMinimo, Comparable elemMaximo, Lista listaRango) {
        if (nodo != null) {
            int comparacionMin = elemMinimo.compareTo(nodo.getElemento());
            int comparacionMax = elemMaximo.compareTo(nodo.getElemento());

            if (comparacionMin < 0) {
                listarRangoAux(nodo.getIzquierdo(), elemMinimo, elemMaximo, listaRango);
            }

            if (comparacionMin <= 0 && comparacionMax >= 0) {
                listaRango.insertar(nodo.getElemento(), listaRango.longitud() + 1);
            }

            if (comparacionMax > 0) {
                listarRangoAux(nodo.getDerecho(), elemMinimo, elemMaximo, listaRango);
            }
        }

        return listaRango;
    }

    public boolean eliminar(Comparable elem){
        return eliminarAux(this.raiz, elem);
    }
    
    //TODO: REVISAR
    private boolean eliminarAux(NodoBB nodo, Comparable elem){
        boolean eliminado = false;
        if (nodo != null) {
            int comparacion = elem.compareTo(nodo.getElemento());
            if (comparacion < 0) {
                eliminado = eliminarAux(nodo.getIzquierdo(), elem);
            }else if(comparacion > 0){
                eliminado = eliminarAux(nodo.getDerecho(), elem);
            }else{
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    nodo = null;
                    eliminado = true;
                }else if(nodo.getIzquierdo() != null && nodo.getDerecho() == null){
                    nodo = nodo.getIzquierdo();
                    eliminado = true;
                }else if(nodo.getIzquierdo() == null && nodo.getDerecho() != null){
                    nodo = nodo.getDerecho();
                    eliminado = true;
                }else{
                    NodoBB reemplazo = buscarReemplazo(nodo.getIzquierdo());
                    nodo.setElemento(reemplazo.getElemento());
                    eliminarAux(nodo.getIzquierdo(), reemplazo.getElemento());
                    eliminado = true;
                }
            }
        }
        return eliminado;
    }

    private NodoBB buscarReemplazo(NodoBB nodo){
        NodoBB reemplazo = nodo;
        if (nodo.getDerecho() != null) {
            reemplazo = buscarReemplazo(nodo.getDerecho());
        }
        return reemplazo;
    }

    public void vaciar(){
        this.raiz = null;
    }
}
