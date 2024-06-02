package conjuntistas;
@SuppressWarnings({"rawtypes"})
public class NodoBB {
    private Comparable elem;
    private NodoBB izquierdo;
    private NodoBB derecho;
    
    public NodoBB(Comparable elem, NodoBB izquierdo, NodoBB derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public NodoBB(Comparable elem){
        this.elem = elem;
        this.izquierdo = null;
        this.derecho = null;
    }

    public void setElemento(Comparable elem){
        this.elem = elem;
    }

    public void setIzquierdo(NodoBB izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoBB derecho){
        this.derecho = derecho;
    }

    public Comparable getElemento(){
        return this.elem;
    }

    public NodoBB getIzquierdo(){
        return this.izquierdo;
    }

    public NodoBB getDerecho(){
        return this.derecho;
    }
}
