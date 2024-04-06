package lineales.estaticas;

/************* Autores ***********
    - Saavedra Juan Pablo, Legajo FAI-3888
    - Gianfranco Gallucci, Legajo FAI-3824
    - Trobbiani Perales Donato, Legajo FAI-4492
*/

/**
 * La clase Pila implementa una estructura de datos de tipo pila.
 * La pila es una estructura LIFO (Last In, First Out), lo que significa que el último elemento que se añade es el primero en ser eliminado.
 * Esta implementación de Pila es estática, lo que significa que tiene un tamaño fijo que se establece en el momento de la creación.
 */

public class Pila {
    private Object[] array;
    private int tope;
    private int TAMANIO = 10;

    public Pila(){
        this.tope = -1;
        this.array = new Object[this.TAMANIO];
    }
    /**
     * Este metodo recibe un elemento y lo apila en la pila
     * 
     * @param elemento El elemento de tipo Object.
     * @return true si el elemento fue apilado, false en caso contrario.
     */
    public boolean apilar(Object elemento){
        boolean apilado;

        if (this.tope+1 >= TAMANIO) {
            apilado = false;
        }else{
            this.tope++;
            this.array[tope] = elemento;
            apilado = true;
        }

        return apilado;
    }

    /**
     * Este metodo desapila el elemento que se encuentra en el tope de la pila.
     * @return
     * true si el elemento fue desapilado, false en caso contrario.
     */
    public boolean desapilar(){
        boolean desapilado;
        
        if (this.tope <= -1) {
            desapilado = false;
        }else{
            this.array[tope] = null;
            tope--;
            desapilado = true;
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
        if (tope >= 0){
            topador = this.array[tope];
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
        if (tope <= -1) {
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
        if (tope >= 0) {
            this.array = new Object[this.TAMANIO];
            this.tope = -1; 
        }
    }

    /**
     * Copia la pila actual y devuelve una nueva pila con los mismos elementos.
     * @return 
     * Una nueva pila con los mismos elementos que la pila actual.
     */
    public Pila clone(){
        Pila pilaClon = new Pila();
        if (tope >= 0) {
            for (int i = 0; i <= tope; i++) {
                pilaClon.apilar(this.array[i]);
            }
        }
        return pilaClon;
    }

    /**
     * Metodo toString de la clase Pila para test
     * @return
     * Devuelve un String con los elementos de la pila.
     */
    public String toString(){
        String cadena = "";
        if (tope >= 0) {
            for (int i = tope; i >= 0; i--) {
                cadena += this.array[i].toString() + " ";
            }
        }else{
            cadena = "Pila vacía";
        }
        return cadena;
    }
}
