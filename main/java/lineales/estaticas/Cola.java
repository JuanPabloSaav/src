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
        if (inicio == (fin+1%tamaño)) {
            puesto = false;
        } else {
            this.array[fin] = elem;
            fin = (fin+1)%tamaño;
            puesto = true;
        }
        return puesto;
    }

    public boolean sacar(){
        boolean sacado;
        if (this.esVacia()) {
            sacado = false;
        } else {
            this.array[inicio] = null;
            inicio = (inicio+1)%tamaño;
            sacado = true;
        }
        return sacado;
    }

    public Object obtenerFrente(){
        Object frente;
        if (this.esVacia()) {
            frente = null;
        } else {
            frente = this.array[inicio];
        }
        return frente;
    }

    public boolean esVacia(){
        return inicio == fin;
    }

    public void vaciar(){
        this.inicio = 0;
        this.fin = 0;
        this.array = new Object[this.tamaño];
    }

    public Cola clone(){
        Cola clon = new Cola();
        for (int i = 0; i < this.tamaño; i++) {
            clon.poner(this.array[i]);
        }
        return clon;
    }

    public String toString(){
        String cadena = "";
        for (int i = 0; i < this.tamaño; i++) {
            cadena += this.array[i].toString() + " ";
        }
        return cadena;
    }
}
