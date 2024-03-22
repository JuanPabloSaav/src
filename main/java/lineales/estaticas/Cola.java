package lineales.estaticas;

public class Cola {
    private int inicio;
    private int fin;
    private Object[] array;
    private int tamaño = 20;
    Cola(){
        this.inicio = 0;
        this.fin = 0;
        this.array = new Object[this.tamaño];
    }

    public boolean poner(Object elem) {
        boolean puesto;
        fin = (fin + 1 ) % tamaño;
        if (array[fin] ==null) {
            
        }
        return puesto;
    }

    public boolean sacar(){

    }
}
