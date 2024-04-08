package lineales;

import lineales.estaticas.Pila;

/************* Autores ***********
    - Saavedra Juan Pablo, Legajo FAI-3888
    - Gianfranco Gallucci, Legajo FAI-3824
    - Trobbiani Perales Donato, Legajo FAI-4492
*/


public class testPila {
  
    public static void main(String[] args) {
        test();
    }

    /**
     * Metodo test para la clase Pila.<p>
     * Se va a pasar a la clase pila por una serie de tests para 
     * verificar su correcto funcionamiento.
     * En caso de que un test falle, se mostrara un mensaje de error
     * y se detendra el testeo.
     * 
     */
    public static void test(){
        System.out.println("Inicio de test de la clase Pila \n");
        boolean success = true;
        int testActual = 0;
        String testActivo = "";
        /*
         * Para realizar el test se utiliza un bucle do-while que pasa por
         * todas las fases del test de la clase Pila hasta que se encuentre
         * con un error o hasta que se hayan completado todos los tests.
         */
        do{
            testActual++;
            switch (testActual) {

                case 1:
                    testActivo = "apilar";
                    System.out.println("Primer test: apilar");
                    success = testApilar();
                    if (success) {
                        System.out.println("Primer test exitoso");
                    }
                    break;
                case 2:
                    testActivo = "esVacio";
                    System.out.println("Segundo test: esVacio");
                    success = testEsVacio();
                    if (success) {
                        System.out.println("Segundo test exitoso");
                    }
                    break;
                case 3:
                    testActivo = "desapilar";
                    System.out.println("Tercer test: desapilar");
                    success = testDesapilar();
                    if (success) {
                        System.out.println("Tercer test exitoso");
                    }
                    break;
                case 4:
                    testActivo = "vaciar";
                    System.out.println("Cuarto test: vaciar");
                    success = testVaciar();
                    if (success) {
                        System.out.println("Cuarto test exitoso");
                    }
                    break;
                case 5:
                    testActivo = "obtenerTope";
                    System.out.println("Quinto test: obtenerTope");
                    success = testObtenerTope();
                    System.out.println("Quinto test exitoso");
                    break;
                case 6:
                    testActivo = "clonar";
                    System.out.println("Sexto test: clonar");
                    success = testClonar();
                    System.out.println("Sexto test exitoso");
                    break;
                case 7:
                    testActivo = "Pila capicua";
                    System.out.println("Septimo test: pila capicua");
                    System.out.println("Primero se probara con una pila no capicua y despues con una capicua");
                    Pila pilaNormal = new Pila();
                    genPilaNormal(pilaNormal);
                    Pila pilaCapicua = new Pila();
                    genPilaCapicua(pilaCapicua);
                    success = ((!testPilaCapicua(pilaNormal)) && (testPilaCapicua(pilaCapicua)));
                    if (success) {
                        System.out.println("No se encontro error en el test de pila capicua");
                    }else{
                        System.out.println("Error en el test de pila capicua");
                    }
                    break;
                case 8:
                    testActivo = "test finalizados";
                    System.out.println("Todos los test realizados con exito");
                    break;
                default:
                    System.out.println("Ocurrio un error inesperado en el testeo de la clase Pila");
                    break;
            }
            if (!success) {
                System.out.println("Deteniendo testeo debido a un error en el metodo "+testActivo+" de la clase Pila");
                break;
            }
            System.out.println("");
        }while(success && testActual < 8);
        System.out.println("Fin de test de la clase Pila");
    }

    /**
     * Metodo para generar una pila normal de 10 elementos.
     * @param pila de tipo Pila
     */
    public static void genPilaNormal(Pila pila){
        for (int i = 1; i <= 10; i++) {
            pila.apilar(i);
        }
    }

    /**
     * Metodo para generar una pila capicua de 10 elementos.
     * @param pila de tipo Pila
     */
    public static void genPilaCapicua(Pila pila){
        for (int i = 1; i <= 5; i++) {
            pila.apilar(i);
        }
        for (int i = 5; i > 0; i--) {
            pila.apilar(i);
        }
    }

    /**
     * Metodo para testear el metodo apilar de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testApilar(){
        Pila test = new Pila();
        boolean apilado = true;
        System.out.println("Pila sin elementos: "+ test.toString());
        for (int i = 1; i <= 10; i++) {
            if (!test.apilar(i)) {
                System.out.println("Ocurrio un error al intentar apilar el elemento "+ i);
                apilado = false;
                break;
            }
            System.out.println("Pila con "+i+" elementos:"+test.toString());
        }
        if (apilado) {
            System.out.println("Si la Pila es estatica el siguiente valor debe ser false: "+ test.apilar(11));
        }
        return apilado;
    }

    /**
     * Metodo para testear el metodo esVacio de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testEsVacio(){
        Pila test = new Pila();
        boolean exito = true;
        System.out.println("Pila actual: "+test.toString());
        if (!test.esVacia()) {
            System.out.println("La pila esta vacia pero el metodo indica que no lo esta");
            exito = false;
        }
        System.out.println("Llenando pila...");
        genPilaNormal(test);
        System.out.println("Pila actual: "+test.toString());
        if (test.esVacia()) {
            System.out.println("La pila esta llena pero el metodo indica que esta vacia");
            exito = false;
        }
        return exito;
    }

    /**
     * Metodo para testear el metodo desapilar de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testDesapilar(){
        boolean desapilado = true;
        Pila test = new Pila();
        genPilaNormal(test);
        System.out.println("Pila antes de desapilar: "+ test.toString());
        for (int i = 10; i >=1; i--) {
            if (!test.desapilar()) {
                System.out.println("Ocurrio un error al intentar desapilar el elemento numero: "+ i);
                System.out.println("Pila actual: "+test.toString());
                desapilado = false;
                break;
            }
            System.out.println("Pila con "+ (i-1) +" elementos: "+ test.toString());
        }
        if (!test.esVacia()) {
            desapilado = false;
        }
        return desapilado;
    }

    /**
     * Metodo para testear el metodo vaciar de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testVaciar(){
        boolean vaciado = false;
        Pila test = new Pila();
        genPilaNormal(test);
        System.out.println("Pila antes de vaciar: "+test.toString());
        test.vaciar();
        if (!test.esVacia()) {
            System.out.println("Error en el metodo vaciar");
        }else{
            System.out.println("Pila despues de vaciar: "+test.toString());
            vaciado = true;
        }
        return vaciado;
    }

    /**
     * Metodo para testear el metodo obtenerTope de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testObtenerTope(){
        boolean existeTope = true;
        Pila test = new Pila();
        genPilaNormal(test);
        System.out.println("Pila actual: "+ test.toString());
        System.out.println("Se espera el tope 10");
        if (!test.obtenerTope().toString().equals("10")) {
            System.out.println("El tope deberia ser 10 pero es: "+ test.obtenerTope());
            existeTope = false;
        }else{
            System.out.println("El tope es "+ test.obtenerTope() +" como se esperaba");
        }
        return existeTope;
    }

    /**
     * Metodo para testear el metodo clonar de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testClonar(){
        boolean clonado = false;
        Pila test = new Pila();
        genPilaNormal(test);
        Pila clon = test.clone();
        if (test.toString().equals(clon.toString())) {
            clonado = true;
            System.out.println("Pila original: "+ test.toString());
            System.out.println("Pila clon: "+ clon.toString());
        }else{
            System.out.println("La pila clon es distinta a la pila original");
            System.out.println("Pila original: "+ test.toString());
            System.out.println("Pila clon: "+ clon.toString());
        }
        return clonado;
    }

    /**
     * Metodo para testear si una pila es capicua o no.
     * @param test de tipo Pila
     * @return Boolean: true si es capicua, false en caso contrario.
     */
    public static boolean testPilaCapicua(Pila test){
        boolean capicua = false;
        Pila clon = test.clone();
        Pila clonInverso = new Pila();
        while (!clon.esVacia()) {
            clonInverso.apilar(clon.obtenerTope());
            clon.desapilar();
        }
        if (clonInverso.toString().equals(test.toString())) {
            capicua = true;
        }
        System.out.println("Pila original: "+ test.toString());
        System.out.println("Pila invertida: "+ clonInverso.toString());
        return capicua;
    }
}