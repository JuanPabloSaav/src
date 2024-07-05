package lineales.dinamicas;

public class ArbolGen {
    private NodoArbolGen raiz;
    
    public ArbolGen(){
        raiz = null;
    }
    
    public boolean insertar(Object elem, Object elemPadre){
        boolean exito = false;
        if (elemPadre == null) {
            this.raiz = new NodoArbolGen(elem, null, null);
            exito = true;
        }else if(this.raiz != null){
            NodoArbolGen nodoPadre = buscarNodo(elemPadre, this.raiz); 
            if (nodoPadre != null) {
                if (nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbolGen(elem, null, null));
                    exito = true;
                }else{
                    NodoArbolGen hIPadre = nodoPadre.getIzquierdo();
                    while (hIPadre.getHermanoDerecho() != null) {
                        hIPadre = hIPadre.getHermanoDerecho();
                    }
                    hIPadre.setHermanoDerecho(new NodoArbolGen(elem, null, null));
                    exito = true;
                }
            }
        }
        return exito;
    }

    private NodoArbolGen buscarNodo(Object elemPadre, NodoArbolGen nodo){
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
                NodoArbolGen hIPadre = nodoPadre.getIzquierdo();
                while (hIPadre.getHermanoDerecho() != null) {
                    hIPadre = hIPadre.getHermanoDerecho();
                }
                hIPadre.setHermanoDerecho(new NodoArbolGen(elem, null, null));
                exito = true;
            }
        }
        return exito;
    }

    private NodoArbolGen buscarNodoPorPos(int[] posPadre, NodoArbolGen nodo){
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

    public boolean pertenece(Object elem){
        boolean pertenece = false;
        if (this.raiz != null) {
            pertenece = perteneceAux(elem, this.raiz);
        }
        return pertenece;
    }
    
    private boolean perteneceAux(Object elem, NodoArbolGen nodo){
        boolean pertenece = false;
        if (nodo != null) {
            if (nodo.getElemento().toString().equals(elem.toString())) {
                pertenece = true;
            }else{
                pertenece = perteneceAux(elem, nodo.getIzquierdo());
                if (!pertenece) {
                    pertenece = perteneceAux(elem, nodo.getHermanoDerecho());
                }
            }
        }
        return pertenece;
    }

    public Lista ancestros(Object elem){
        Lista lista = new Lista();
        if (this.raiz != null) {
            ancestrosAux(elem, this.raiz, lista);
        }
        return lista;
    }

    private boolean ancestrosAux(Object elem, NodoArbolGen nodo, Lista lista){
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElemento().toString().equals(elem.toString())) {
                encontrado = true;
                lista.insertar(nodo.getElemento(), 1);
            }
            if (!encontrado) {
                if (nodo.getIzquierdo() != null) {
                    encontrado = ancestrosAux(elem, nodo.getIzquierdo(), lista);
                }
                if (!encontrado) {
                    NodoArbolGen aux = nodo.getHermanoDerecho();
                    while (aux != null) {
                       encontrado = ancestrosAux(elem, aux, lista);
                        if (encontrado) {
                            break;
                        }
                        aux = aux.getHermanoDerecho();
                    }
                }else{
                    lista.insertar(nodo.getElemento(), 1);
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio(){
        boolean vacio = false;
        if (raiz == null) {
            vacio = true;
        }
        return vacio;
    }

    public int altura(){
        int altura = -1;
        altura = alturaAux(this.raiz, altura);
        return altura;
    }

    private int alturaAux(NodoArbolGen nodo, int alturaActual){
        if (nodo != null) {
            alturaActual++;
            int alturaAux = 0, alturaAux2 = 0;
            if (nodo.getIzquierdo() != null) {
                alturaAux = alturaAux(nodo.getIzquierdo(), alturaActual);
            }
            if (nodo.getHermanoDerecho()!= null) {
                alturaAux2 = alturaAux(nodo.getHermanoDerecho(), alturaActual-1);
            }
            if (alturaAux > alturaAux2) {
                alturaActual = alturaAux;
            }else if(alturaAux2 > alturaAux){
                alturaActual = alturaAux2;
            }
        }
        return alturaActual;
    }

    public int nivel(Object elem){
        int nivel = 0;
        nivel = nivelAux(elem, this.raiz, new boolean[]{false});
        return nivel;
    }

    /*
     * totalmente inutil
     */
    /* private int nivelAux(Object elem, NodoArbolGen nodo, int nivel){
        boolean encontrado = false;
        int aux = -1;
        if (nodo != null) {
            nivel++;
            if (nodo.getIzquierdo() != null) {
               aux = nivelAux(elem, nodo.getIzquierdo(), nivel);
            }
            if(aux == -1){
                NodoArbolGen temp = nodo;
                while (!encontrado && temp != null) {
                    if (temp.getElemento().toString().equals(elem.toString())) {
                        encontrado = true;
                        break;
                    }
                    temp = temp.getHermanoDerecho();
                }
            }
            if (encontrado) {
                
            }
        }
    } */

    private int nivelAux(Object elem, NodoArbolGen nodo, boolean[] encontrado){
        int nivel = -1;
        if (nodo != null) {
            NodoArbolGen temp = nodo;
            while (temp != null) {
                if (temp.getElemento().toString().equals(elem.toString())) {
                    encontrado[0] = true;
                    break;
                }
                nivel = nivelAux(elem, temp.getIzquierdo(), encontrado);
                if (encontrado[0]) {
                    break;
                }
                temp = temp.getHermanoDerecho();
            }
            if (encontrado[0]) {
                nivel++;
            }

        }
        return nivel;
    }

    public Object padre(Object hijo){
        Object padre = null;
        if (hijo != null && !hijo.toString().equals(this.raiz.toString())) {
            padre = padreAux(hijo, this.raiz);
        }
        return padre;
    }

    private Object padreAux(Object hijo, NodoArbolGen nodo){
        Object elemPadre = null;
        if (nodo != null) {
            NodoArbolGen aux = nodo.getIzquierdo();
            while (aux != null) {
                elemPadre = padreAux(hijo, aux);
                if (aux.getElemento().toString().equals(hijo.toString())) {
                    elemPadre = nodo.getElemento();
                    break;
                }else if(elemPadre != null){
                    break;
                }
                aux = aux.getHermanoDerecho();
            }
        }
        return elemPadre;
    }

    public Lista listarPreOrden(){
        Lista lista = new Lista();
        listarPreOrdenAux(raiz, lista);
        return lista;
    }

    private void listarPreOrdenAux(NodoArbolGen nodo, Lista lista){
        if (nodo != null) {
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            NodoArbolGen hijo = nodo.getIzquierdo();
            while (hijo != null) {
                listarPreOrdenAux(hijo, lista);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInOrden(){
        Lista lista = new Lista();
        listarInOrdenAux(this.raiz, lista);
        return lista;
    }

    private void listarInOrdenAux(NodoArbolGen nodo, Lista lista){
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                listarInOrdenAux(nodo.getIzquierdo(), lista);
            }
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            if (nodo.getIzquierdo() != null) {
                NodoArbolGen hijo = nodo.getIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInOrdenAux(hijo, lista);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosOrden(){
        Lista lista = new Lista();
        listarPosOrdenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosOrdenAux(NodoArbolGen nodo, Lista lista){
        if (nodo != null) {
            listarInOrdenAux(nodo.getIzquierdo(), lista);
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            NodoArbolGen hijo = nodo.getHermanoDerecho();
            while (hijo != null) {
                listarInOrdenAux(hijo, lista);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public void vaciar(){
        this.raiz = null;
    }

    public Lista listarPorNiveles(){
        Lista lista = new Lista();
        Cola colaNodos = new Cola();
        colaNodos.poner(this.raiz);
        listarPorNivelesAux(colaNodos, lista);
        return lista;
    }

    private void listarPorNivelesAux(Cola nodos, Lista lista){
        if(!nodos.esVacia()){
            Cola colaAux = new Cola();
            while (!nodos.esVacia()) {
                NodoArbolGen nodoAux = (NodoArbolGen) nodos.obtenerFrente();
                while (nodoAux != null) {
                    lista.insertar(nodoAux.getElemento().toString(), lista.longitud()+1);
                    if (nodoAux.getIzquierdo() != null) {
                        colaAux.poner(nodoAux.getIzquierdo());
                    }
                    nodoAux = nodoAux.getHermanoDerecho();
                }
                nodos.sacar();
            }
            listarPorNivelesAux(colaAux, lista);
        }
    }

    public ArbolGen clon(){
        ArbolGen clon = new ArbolGen();
        if (raiz != null) {
            clon.raiz = new NodoArbolGen(raiz.getElemento(), null, null);
            cloneAux(raiz, clon.raiz);
        }
        return clon;
    }

    private void cloneAux(NodoArbolGen nodo, NodoArbolGen clon){
        if (nodo != null) {
            NodoArbolGen aux = nodo.getIzquierdo();
            NodoArbolGen clonAux = clon;
            if (aux != null) {
                clonAux.setIzquierdo(new NodoArbolGen(aux.getElemento(), null, null));
                clonAux = clonAux.getIzquierdo();
                aux = aux.getHermanoDerecho();
                while (aux != null) {
                    clonAux.setHermanoDerecho(new NodoArbolGen(aux.getElemento(), null, null));
                    clonAux = clonAux.getHermanoDerecho();
                    aux = aux.getHermanoDerecho();
                }
                aux = nodo.getIzquierdo();
                clonAux = clon.getIzquierdo();
                while (aux != null) {
                    cloneAux(aux, clonAux);
                    aux = aux.getHermanoDerecho();
                    clonAux = clonAux.getHermanoDerecho();
                }
            }
        }
    }

    /**
     * Metodo toString que recorre el arbol en preOrden
     * @return String cadena: contiene una cadena conformada por todos
     * los elementos del arbol
     */
    public String toString(){
        
        return auxToString(this.raiz);
    }

    private String auxToString(NodoArbolGen nodo){
        String cadena = "";
        if(nodo != null){
            cadena += nodo.getElemento().toString() + " -> ";
            NodoArbolGen hijo = nodo.getIzquierdo();
            while (hijo != null) {
                cadena += hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            hijo = nodo.getIzquierdo();
            while (hijo != null) {
                cadena += "\n" + auxToString(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return cadena;
    }


    //SIMULACRO 2 


    public boolean verificarCamino(Lista lista){
        boolean exito = false;
        exito = verificarCaminoAux(lista, this.raiz, 1);
        return exito;
    }

    private boolean verificarCaminoAux(Lista lista, NodoArbolGen nodo, int posElemActual){
        boolean exito = false;
        if (nodo != null) {
            NodoArbolGen aux = nodo;
            while (aux != null && !exito) {
                if (aux.getElemento().equals(lista.recuperar(posElemActual))) {
                    if (lista.longitud() == posElemActual) {
                        exito = true;
                    }else{
                        exito = verificarCaminoAux(lista, aux.getIzquierdo(), posElemActual+1);
                    }
                }
                aux = aux.getHermanoDerecho();
            }
        }
        return exito;
    }

    public Lista listarEntreNiveles(int niv1, int niv2){
        Lista lista = new Lista();
        Lista nodos = new Lista();
        nodos.insertar(this.raiz, 1);
        listarEntreNivelesAux(niv1, niv2, nodos, 0, lista);
        return lista;
    }

    private void listarEntreNivelesAux(int niv1, int niv2, Lista nodos, int nivelActual, Lista lista){
        if (nivelActual <= niv2 && !nodos.esVacia()) {
            Lista temp = new Lista();
            while (!nodos.esVacia()) {
                NodoArbolGen aux = (NodoArbolGen) nodos.recuperar(1);
                if (nivelActual >= niv1) {
                    lista.insertar(aux.getElemento(), lista.longitud()+1);
                }
                aux = aux.getIzquierdo();
                while (aux != null && nivelActual+1 <= niv2) {
                    temp.insertar(aux, temp.longitud()+1);
                    aux.getHermanoDerecho();
                }
                nodos.eliminar(1);
            }
            listarEntreNivelesAux(niv1, niv2, temp, nivelActual+1, lista);
        }
    }

    //Promocion


    //ejercicio 1 parcial 2
    public boolean jerarquizar(Object elem){
        boolean exito = false;
        if (this.raiz != null && raiz.getIzquierdo() != null) {
            exito = jerarquizarAux(elem, raiz.getIzquierdo(), null);            
        }
        return exito;
    }

    private boolean jerarquizarAux(Object elem, NodoArbolGen nodo, NodoArbolGen padre){
        boolean exito = false;
        NodoArbolGen hAnterior = null;
        while (nodo != null && !exito) {
            if (nodo.getElemento().equals(elem)) {
                if (hAnterior != null) {
                    hAnterior.setHermanoDerecho(nodo.getHermanoDerecho());
                    nodo.setHermanoDerecho(padre.getHermanoDerecho());
                    padre.setHermanoDerecho(nodo);
                    exito = true;
                }else{
                    padre.setIzquierdo(nodo.getHermanoDerecho());
                    nodo.setHermanoDerecho(padre.getHermanoDerecho());
                    padre.setHermanoDerecho(nodo);
                    exito = true;
                }
            }else{
                if (nodo.getIzquierdo() != null) {
                    exito = jerarquizarAux(elem, nodo.getIzquierdo(), nodo);                    
                }
            }
            hAnterior = nodo;
            nodo = nodo.getHermanoDerecho();
        }
        return exito;
        
    }


    
}
