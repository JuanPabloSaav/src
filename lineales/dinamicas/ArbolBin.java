package lineales.dinamicas;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertarPorPosicion(Object elemNuevo, int posPadre){
        boolean exito = true;
        if (posPadre == 0) {
            if (raiz == null) {
                raiz = new NodoArbol(elemNuevo, null, null);
            }else{
                exito = false;
            }
        }else{
            int[] posPadreAux = {posPadre-1};
            NodoArbol nodoPadre = obtenerNodoPorPosicion(posPadreAux, raiz);
            if (nodoPadre != null) {
                if (nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                }else if (nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    exito = false;
                }
            }else{
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodoPorPosicion(int[] posPadre, NodoArbol padre){
        NodoArbol nodo = null;
        if (padre != null && posPadre[0] >= 0) {
            if (posPadre[0] == 0) {
                nodo = padre;
            }else{
                posPadre[0]--;
                nodo = obtenerNodoPorPosicion(posPadre, padre.getIzquierdo());
                if (nodo == null) {
                    nodo = obtenerNodoPorPosicion(posPadre, padre.getDerecho());
                }
            }
        }
        return nodo;
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

    public boolean esVacio(){
        boolean vacio = true;
        if (raiz != null) {
            vacio = false;
        }
        return vacio;
    }

    public int altura(){
        NodoArbol aux = raiz;
        int alturaMax = alturaMax(0, aux);
        return alturaMax;
    }

    /**
     * ojo que esto seguro no funciona!!!!!!!! (Todas las hojas)
     * @param alturaActual
     * @param padre
     * @return
     */
    private int alturaMax(int alturaActual, NodoArbol padre){
        int aux = 0;
        int aux2 = 0;
        if (padre != null) {
            aux = alturaMax(alturaActual+1, padre.getIzquierdo());
            aux2 = alturaMax(alturaActual+1, padre.getDerecho());
            if (aux < aux2) {
                aux = aux2;
            }
        }else{
            aux = alturaActual-1;
        }
        return aux;
    }

    public int nivel(Object elemento){
        NodoArbol aux = raiz;
        int nivelElemento = busquedaNivel(elemento, 0, aux);
        return nivelElemento;
    }

    private int busquedaNivel(Object elemento, int nivelActual, NodoArbol padre){
        int nivel = -1;
        if (padre != null) { 
            if (elemento.toString().equals(padre.getElemento().toString())) {
                nivel = nivelActual;
            }else{
                nivel = busquedaNivel(elemento, nivelActual+1, padre.getIzquierdo());
                if (nivel == -1) {
                    nivel = busquedaNivel(elemento, nivelActual, padre.getDerecho());
                }
            }
        }
        return nivel;
    }

    /**
     * adivina que hace!!!!
     */
    public void vaciar(){
        this.raiz = null;
    }

    public Object padre(Object elemento){
        Object elementoPadre = busquedaHijo(elemento, raiz, false);
        return elementoPadre;
    }

    private Object busquedaHijo(Object elemento, NodoArbol padre, Boolean encontrado){
        Object elemPadre = null;
        if (padre != null) {
            if (padre.getElemento().equals(elemento.toString())) {
                encontrado = true;
            }else{
                elemPadre = busquedaHijo(elemento, padre.getIzquierdo(), encontrado);
                if (elemPadre == null && !encontrado) {
                    elemPadre = busquedaHijo(elemento, padre.getDerecho(), encontrado);
                }
                if (encontrado) {
                    elemPadre = padre.getElemento();
                    encontrado = false;
                }
            }
        }
        return elemPadre;
    }

    public Lista listaPreOrden(){
        Lista listaElementos = new Lista();
        listaElementos.insertar(raiz.getElemento(), 1);
        listaPreOrdenAux(raiz.getIzquierdo(), listaElementos);
        listaPreOrdenAux(raiz.getDerecho(), listaElementos);
        return listaElementos;
    }
    
    private void listaPreOrdenAux(NodoArbol padre, Lista listaElementos){
        if (padre != null) {
            listaElementos.insertar(padre.getElemento(), listaElementos.longitud()+1);
            listaPreOrdenAux(padre.getIzquierdo(), listaElementos);
            listaPreOrdenAux(padre.getDerecho(), listaElementos);
        }
    }

    public Lista listaInOrden(){
        Lista listaElementos = new Lista();
        listaInOrdenAux(raiz, listaElementos);
        return listaElementos;
    }

    private void listaInOrdenAux(NodoArbol padre, Lista listaElementos){
        if (padre != null) {
            listaInOrdenAux(padre.getIzquierdo(), listaElementos);
            listaElementos.insertar(padre.getElemento(), listaElementos.longitud()+1);
            listaInOrdenAux(padre.getDerecho(), listaElementos);
        }
    }

    public Lista listaPosOrden(){
        Lista listaElementos = new Lista();
        listaPosOrdenAux(raiz, listaElementos);
        return listaElementos;
    }

    private void listaPosOrdenAux(NodoArbol padre, Lista listaElementos){
        if (padre != null) {
            listaPosOrdenAux(padre.getIzquierdo(), listaElementos);
            listaPosOrdenAux(padre.getDerecho(), listaElementos);
            listaElementos.insertar(padre.getElemento(), listaElementos.longitud()+1);
        }
    }

    public Lista listaNiveles(){
        Lista listaElementos = new Lista();
        Cola colaAux = new Cola();
        colaAux.poner(raiz);
        while (!colaAux.esVacia()) {
            NodoArbol nodoActual = (NodoArbol) colaAux.obtenerFrente();
            colaAux.sacar();
            listaElementos.insertar(nodoActual.getElemento(), listaElementos.longitud()+1);
            if (nodoActual.getIzquierdo() != null) {
                colaAux.poner(nodoActual.getIzquierdo());
            }
            if (nodoActual.getDerecho() != null) {
                colaAux.poner(nodoActual.getDerecho());
            }
        }
        return listaElementos;
    }

    public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        clon.insertar(cloneAux(raiz), null, true);
        return clon;
    }

    private NodoArbol cloneAux(NodoArbol padre){
        NodoArbol clon = null;
        if (padre != null) {
            clon = new NodoArbol(padre.getElemento(), cloneAux(padre.getIzquierdo()), cloneAux(padre.getDerecho()));
        }
        return clon;
    }

    public String toString(){
        String arbol = toStringAux(raiz);
        return arbol;
    }

    private String toStringAux(NodoArbol padre){
        String arbol = "";
        if (padre != null) {
            arbol += "Nodo: "+padre.getElemento()+"\n";
            arbol += "Hijo Izquierdo: ";
            if (padre.getIzquierdo() != null) {
                arbol += padre.getIzquierdo().getElemento().toString()+" ";
            }
            arbol += "Hijo Derecho: ";
            if (padre.getDerecho() != null){
                arbol += padre.getDerecho().getElemento().toString();
            }
            arbol += "\n";
            arbol += toStringAux(padre.getIzquierdo());
            arbol += toStringAux(padre.getDerecho());
        }
        return arbol;
    }

}
