package main.java.lineales.estaticas;

public class Pila {
    private Object[] array;
    private int tope;
    private static final int TAMANIO = 20;

    public Pila(){
        this.tope = -1;
        this.arreglo = new Object[TAMANIO];
    }

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

    public Object obtenerTope(){
        Object topador;
        if (tope >= 0){
            topador = this.array[tope];
        }else{
            topador = null;
        }
        return topador;
    }

    public boolean esVacia(){
        boolean vacio;
        if (tope <= -1) {
            vacio = true;
        }else{
            vacio = false;
        }
        return vacio;
    }

    public vaciar(){
        if (tope >= 0) {
            this.array = new Object[20];
            this.tope = -1; 
        }
    }

    public Pila clone(){
        int auxTope = this.tope;
        Pila pilaClon = new Pila();
        if (tope >= 0) {
            for (int i = 0; i < tope; i++) {
                pilaClon.apilar(this.array[auxTope]);
                auxTope--;
            }
        }
        return pilaClon;
    
    }
}
