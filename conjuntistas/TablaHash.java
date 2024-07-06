package conjuntistas;
import lineales.dinamicas.Nodo;
import java.util.Arrays;

public class TablaHash {
    private int tamaño;
    private Nodo[] tabla;
    private int primo;

    public TablaHash(int size){
        tabla = new Nodo[size];
        tamaño = size;
        primo = getPrimoCercano(size);

    }

    public boolean insertar(Comparable elemento){
        boolean exito = false;
        int hash = elemento.hashCode();
        int pos = hash % primo;
        Nodo bucket = tabla[pos];
        if (bucket != null) {
            while (bucket.getEnlace() != null) {
                bucket = bucket.getEnlace();
            }
            bucket.setEnlace(new Nodo(elemento, null));
            exito = true;
        }else{
            tabla[pos] = new Nodo(elemento, null);
            exito = true;
        }

        return exito;
    }

    public boolean eliminar(Comparable elemento){
        boolean exito = false;
        int hash = elemento.hashCode();
        int pos = hash % primo;
        Nodo bucket = tabla[pos];
        Nodo anterior = null;
        while (bucket != null) {
            if (bucket.getDato().equals(elemento)) {
                anterior.setEnlace(bucket.getEnlace());
                exito = true;
            }
            anterior = bucket;
            bucket = bucket.getEnlace();
        }
        return exito;
    }

    public boolean pertenece(Comparable elemento){
        boolean encontrado = false;
        int hash = elemento.hashCode();
        int pos = hash % primo;
        Nodo bucket = tabla[pos];
        while (bucket != null) {
            if (bucket.getDato().equals(elemento)) {
                encontrado = true;
                break;
            }
            bucket = bucket.getEnlace();
        }
        return encontrado;
    }

    public boolean esVacia(){
        boolean vacio = true;
        for (int i = 0; i < tamaño; i++) {
            if (tabla[i] != null) {
                vacio = false;
                break;
            }
        }
        return vacio;
    }

    private boolean[] cribaDeEratostenes(int n){
        boolean[] esPrimo = new boolean[n + 1];
        boolean exito = false;
        Arrays.fill(esPrimo, true);
        int inicio = 2;
        while (!exito) {
            esPrimo[inicio] = false;
            for (int i = 2; i*inicio <= n; i++) {
                if (esPrimo[i*inicio]) {
                    esPrimo[i*inicio] = false;
                }
            }
            if (Math.pow(inicio, 2) < n) {
                inicio++;
            }else{
                exito = true;
            }
        }
        return esPrimo;
    }

    private int getPrimoCercano(int numero){
        boolean[] numeroPrimos = cribaDeEratostenes(numero);
        while (!numeroPrimos[numero] && numero > 2) {
            numero--;
        }
        return numero;
    }
}
