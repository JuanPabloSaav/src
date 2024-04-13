package lineales;

import java.util.Scanner;

import lineales.dinamicas.Lista;

public class pruebaLista {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion = 0;
        do {
            System.out.println("lol");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("LOL pero concatenado");
                    Lista listaTemp1 = new Lista();
                    listaTemp1.insertar(1,1);
                    listaTemp1.insertar(2,2);
                    listaTemp1.insertar(3,3);
                    Lista listaTemp2 = new Lista();
                    listaTemp2.insertar(4, 1);
                    listaTemp2.insertar(5, 2);
                    listaTemp2.insertar(6, 3);
                    Lista listaConcatenada = concatenar(listaTemp1, listaTemp2);
                    System.out.println("Lista concatenada: "+ listaConcatenada.toString());
                    break;
            
                default:
                    break;
            }
        } while (true);
    }

    public static Lista concatenar(Lista l1, Lista l2){
        Lista listaConcatenada = l1.clone();
        int longitudL2 = l2.longitud();
        int longitudL1 = l1.longitud();
        int i = 1;
        while (i <= longitudL2) {
            listaConcatenada.insertar(l2.recuperar(i), (longitudL1+i));
            i++;
        }
        return listaConcatenada;
    }


}
