package conjuntistas;

public class Avl {
    private NodoAvl raiz;
    
    public Avl(){
        raiz = null;
    }

    public boolean insertar(Comparable elem){

    }

    //TODO: revisar si no causa algun error el no verificar al padre (parametro)
    private int balance(NodoAvl padre){
        int balance = altura(padre.getIzquierdo()) - altura(padre.getDerecho());
        if (balance > 1) {
            int balanceHijo = balance(padre.getIzquierdo());
            if (balanceHijo >= 0) {
                //rotarDerecha
            }else{
                //rotarIzquierda-Derecha
            }
        }else if(balance < 1){
            int balanceHijo = balance(padre.getDerecho());
            if (balanceHijo <= 0) {
                //rotarIzquierda
            }else{
                //rotarDerecha-Izquierda
            }
        }
        return balance;
    }

    private int altura(NodoAvl nodo){
        int altura = 0;
        if (nodo != null) {
           nodo.recalcularAltura(); 
           altura = nodo.getAltura();
        }
        
        return altura;
    }

    //TODO: COMPLETA!!!!!!
    private rotarIzquierda(){

    }

    //TODO: ADIVINA!!!!!!!
    private rotarDerecha(){

    }
}
