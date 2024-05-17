package conjuntistas;

public class Heap {
    private Comparable[] array;
    private int tamaño = 20;
    private int ultimo;

    public Heap(){
        this.array = new Comparable[tamaño];
        this.ultimo = 0;
    }

    public boolean insertar(Comparable elem){
        boolean exito = false;
        for (int i = 1; i < this.tamaño; i++) {
            if (array[i] == null) {
                array[i] = elem;
                ultimo = i;
                exito = true;
            }
        }
        return exito;
    }

    public boolean eliminarCima(){
        boolean eliminado = false;
        if (this.ultimo != 0) {
            this.array[1] = this.array[ultimo];
            this.ultimo--;
            bajar(1);
            eliminado = true;
        }
        return eliminado;
    }

    private void bajar(int i){
        int posH;
        boolean salir = false;
        Comparable temp = array[i];

        while (!salir) {
            posH = i*2;
            if (posH <= ultimo) {
                if (posH < ultimo) {
                    if (array[i+1].compareTo(array[i]) < 0) {
                        posH++;
                    }
                }
                if (array[posH].compareTo(temp) < 0) {
                    this.array[i] = this.array[posH];
                    this.array[posH] = temp;
                    i = posH;
                }else{
                    salir = true;
                }
            }else{
                salir = true;
            }
        }
    }

    public Comparable recuperarCima(){
        return array[1];
    }

    public Heap clone(){
        Heap clon = new Heap();
        for (int i = 1; i < ultimo; i++) {
            clon.array[i] = this.array[i];
        }
        return clon;
    }

    public String toString(){
        String cadena = "";
        for (int i = 1; i < ultimo; i++) {
            cadena += "Padre: "+array[i].toString();
            if ((2*i) <= ultimo) {
                cadena += " hijo Izquierdo: "+ array[2*i]; 
            }else{
                cadena += " Sin Hijos";
            }
            if ((2*i)+1 < ultimo) {
                cadena += "Hijo derecho: " + array[(2*i)+1];
            }
            cadena += "\n";
        }
        return cadena;
    }
}
