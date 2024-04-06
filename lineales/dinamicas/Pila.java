package lineales.dinamicas;

/************* Autores ***********
    - Saavedra Juan Pablo, Legajo FAI-3888
    - Gianfranco Gallucci, Legajo FAI-3824
    - Trobbiani Perales Donato, Legajo FAI-4492
*/

/**
 * La clase Pila implementa una estructura de datos de tipo pila.
 * La pila es una estructura LIFO (Last In, First Out), lo que significa que el último elemento que se añade es el primero en ser eliminado.
 * Esta implementación de Pila es dinámica, lo que significa que no tiene un tamaño fijo.
 */
public class Pila {
    private Nodo tope;
    
    public Pila(){
        this.tope = null;
    }

    /**
     * Este metodo recibe un elemento y lo apila en la pila
     * 
     * @param elemento El elemento de tipo Object.
     * @return true si el elemento fue apilado, false en caso contrario.
     */
    public boolean apilar(Object elemento){
        Nodo nuevo = new Nodo(elemento, this.tope);
        this.tope = nuevo;
        return true;
    }

    /**
     * Este metodo desapila el elemento que se encuentra en el tope de la pila.
     * @return
     * true si el elemento fue desapilado, false en caso contrario.
     */
    public boolean desapilar(){
        boolean desapilado;
        if (this.tope != null){
            this.tope = this.tope.getEnlace();
            desapilado = true;
        }else{
            desapilado = false;
        }
        return desapilado;
    }

    /**
     * Este metodo devuelve el elemento que se encuentra en el tope de la pila.
     * @return
     * El elemento que se encuentra en el tope de la pila.
     */
    public Object obtenerTope(){
        Object topador;
        if (this.tope != null){
            topador = this.tope.getDato();
        }else{
            topador = null;
        }
        return topador;
    }

    /**
     * Este metodo verifica si la pila está vacía.
     * @return
     * true si la pila está vacía, false en caso contrario.
     */
    public boolean esVacia(){
        boolean vacio;
        if (this.tope == null){
            vacio = true;
        }else{
            vacio = false;
        }
        return vacio;
    }

    /**
     * Este metodo vacía la pila.
     */
    public void vaciar(){
        this.tope = null;
    }

    /**
     * Copia la pila actual y devuelve una nueva pila con los mismos elementos.
     * @return 
     * Una nueva pila con los mismos elementos que la pila actual.
     */
    public Pila clone(){
        Pila clon = new Pila();
        if (this.tope != null) {
            // Crear un nodo temporal para recorrer la pila original
            Nodo temp = this.tope;
            // Crear una pila auxiliar para mantener el orden de los elementos
            Pila aux = new Pila();
            // Recorrer la pila original y apilar los elementos en la pila auxiliar
            while (temp != null) {
                aux.apilar(temp.getDato());
                temp = temp.getEnlace();
            }
            // Recorrer la pila auxiliar y apilar los elementos en la pila clon
            while (!aux.esVacia()) {
                clon.apilar(aux.obtenerTope());
                aux.desapilar();
            }
        }
        return clon;
    }
    
    /**
     * Metodo toString de la clase Pila para test
     * @return
     * Devuelve un String con los elementos de la pila.
     */
    public String toString(){
        String cadena = "";
        if (this.tope != null) {
            Nodo temp = this.tope;
            do{
                cadena += temp.getDato().toString()+",";
                temp = temp.getEnlace();
            }while(temp != null);
        }
        return cadena;
    }
}
