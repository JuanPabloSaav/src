package conjuntistas;

import lineales.dinamicas.Lista;
@SuppressWarnings({"rawtypes", "unchecked"})
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
        boolean[] eliminado = {false};
        if (raiz != null) {
            this.raiz = eliminarAux(raiz, elem, eliminado);
        }
        return eliminado[0];
    }
    
    //TODO: REVISAR
    private NodoBB eliminarAux(NodoBB nodo, Comparable elem, boolean[] eliminado){
        if (nodo != null) {
            int comparacion = elem.compareTo(nodo.getElemento());
            if (comparacion < 0) {
                nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), elem, eliminado));
            }else if(comparacion > 0){
                nodo.setDerecho(eliminarAux(nodo.getDerecho(), elem, eliminado));
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
                    NodoBB reemplazo = buscarReemplazo(nodo.getIzquierdo());
                    nodo.setElemento(reemplazo.getElemento());
                    nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), reemplazo.getElemento(), eliminado));
                    eliminado[0] = true;
                }
            }
        }
        return nodo;
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

    //simulacro 2

    public void eliminarMinimo(){
        if(raiz != null){
            if (raiz.getIzquierdo() == null) {
                raiz = raiz.getDerecho();
            }else{
                NodoBB padreMin = buscarPadreNodoMin(raiz);
                NodoBB min = padreMin.getIzquierdo();
                if (min.getDerecho() != null) {
                    min = min.getDerecho();
                    padreMin.setIzquierdo(min);
                }
            }
        }
    }

    private NodoBB buscarPadreNodoMin(NodoBB padre){
        //obtiene el hijo del padre
        NodoBB hijo = padre.getIzquierdo();
        /*
        * si el hijo tiene un hijo izquierdo quiere decir que no es el minimo
        * por lo tanto se lo usa para seguir buscando
        */
        if (hijo.getIzquierdo() != null) {
            padre = buscarPadreNodoMin(hijo);
        }

        //si es el minimo se devuelve el padre
        return padre;
    }

    public ArbolBB clonarParteInvertida(Comparable elem){
        ArbolBB clonInvertido = new ArbolBB();
        clonarParteInvertidaAux(elem, this.raiz, clonInvertido);
        return clonInvertido;
    }

    private void clonarParteInvertidaAux(Comparable elem, NodoBB nodo, ArbolBB clonInvertido){
        if (nodo != null) {
            int compare = elem.compareTo(nodo.getElemento());
            if (compare == 0) {
                clonInvertido.raiz = new NodoBB(nodo.getElemento());
                invertirSubArbol(nodo, clonInvertido.raiz);
            }else if(compare < 0 && nodo.getIzquierdo() != null){
                clonarParteInvertidaAux(elem, nodo.getIzquierdo(), clonInvertido);
            }else if (nodo.getDerecho() != null){
                clonarParteInvertidaAux(elem, nodo.getDerecho(), clonInvertido);
            }
        }
    }

    private void invertirSubArbol(NodoBB nodo, NodoBB nodoClon){
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                nodoClon.setDerecho(nodo.getIzquierdo());
                invertirSubArbol(nodo.getIzquierdo(), nodoClon.getDerecho());
            }
            if (nodo.getDerecho() != null) {
                nodoClon.setIzquierdo(nodo.getDerecho());
                invertirSubArbol(nodo.getDerecho(), nodoClon.getIzquierdo());
            }
        }
    }


}
