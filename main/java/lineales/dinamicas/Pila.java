package main.java.lineales.dinamicas;

import main.java.lineales.dinamicas.Nodo;

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
        Pila clon = new Pila();
        if (this.tope != null){
            Nodo temp = this.tope;
            do{
                clon.apilar(temp.getDato());
                temp = temp.getEnlace();
                
            }while(temp != null);
        }
        return clon;
    }

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
