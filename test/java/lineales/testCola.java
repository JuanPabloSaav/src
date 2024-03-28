package lineales;
import java.util.Scanner;
import lineales.dinamicas.Cola;

public class testCola {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion = -1;
        Cola cola = new Cola();
        do {
            if (cola.esVacia()) {
                System.out.println("Cola vacia");
            }else{
                System.out.println("Cola con elementos");
            }
            System.out.println("1. Poner elemento");
            System.out.println("2. Sacar elemento");
            System.out.println("3. Obtener frente");
            System.out.println("4. Es vacia");
            System.out.println("5. Vaciar");
            System.out.println("6. Clonar");
            System.out.println("7. toString");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el elemento a poner");
                    ponerElemento(sc.next(), cola);
                    break;
                case 2:
                    sacarElemento(cola);
                    break;
                case 3:
                    obtenerElemento(cola);
                    break;
                case 4:
                    esVacia(cola);
                    break;
                case 5:
                    vaciar(cola);
                    break;
                case 6:
                    clonar(cola);
                    break;
                case 7: 
                    System.out.println(cola.toString());
                    break;
                case 9:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public static void ponerElemento(Object elem, Cola cola){
        if (cola.poner(elem)) {
            System.out.println("Elemento puesto correctamente");
        } else {
            System.out.println("No se pudo poner el elemento");
        }
    }

    public static void sacarElemento(Cola cola){
        if (cola.sacar()) {
            System.out.println("Elemento sacado correctamente");
        } else {
            System.out.println("No se pudo sacar el elemento");
        }
    }

    public static void obtenerElemento(Cola cola){
        Object elem = cola.obtenerFrente();
        if (elem != null) {
            System.out.println("Elemento en el frente: "+ elem.toString());
        } else {
            System.out.println("No hay elementos en la cola");
        }
    }

    public static void esVacia(Cola cola){
        if (cola.esVacia()) {
            System.out.println("La cola está vacía");
        } else {
            System.out.println("La cola no está vacía");
        }
    }

    public static void vaciar(Cola cola){
        cola.vaciar();
        System.out.println("Cola vaciada");
    }

    public static void clonar(Cola cola){
        Cola clon = cola.clone();
        System.out.println("Cola clonada: "+ clon.toString());
    }
}


