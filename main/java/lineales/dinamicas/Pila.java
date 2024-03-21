package main.java.lineales.dinamicas;

public class Pila {
    private Nodo tope;
    /**sexo */
    public Pila(){
        this.tope = null;
    }

    public boolean apilar(Object elemento){
        Nodo nuevo = new Nodo(elemento, this.tope);
        this.tope = nuevo;
        return true;
    }

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

    public Object obtenerTope(){
        Object topador;
        if (this.tope != null){
            topador = this.tope.getDato();
        }else{
            topador = null;
        }
        return topador;
    }

    public boolean esVacia(){
        boolean vacio;
        if (this.tope == null){
            vacio = true;
        }else{
            vacio = false;
        }
        return vacio;
    }

    public void vaciar(){
        this.tope = null;
    }

    public Pila clone(){
        
    }
}
