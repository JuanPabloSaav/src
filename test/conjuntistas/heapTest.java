package conjuntistas;

public class heapTest {
    public static void main(String[] args) {
        eliminarTest();
    }

    public static void eliminarTest(){
        Heap heap = new Heap();
        heap.insertar(1);
        heap.insertar(2);
        heap.insertar(3);
        heap.insertar(4);
        heap.insertar(5);
        heap.eliminarCima();

    }
}
