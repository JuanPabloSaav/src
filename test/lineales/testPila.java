package lineales;

import lineales.estaticas.Pila;

/************* Autores ***********
    - Saavedra Juan Pablo, Legajo FAI-3888
    - Gianfranco Gallucci, Legajo FAI-3824
    - Trobbiani Perales Donato, Legajo FAI-4492
*/


public class testPila {
    /**
     * Metodo main para testear la clase Pila.
     * 
     * Se va a pasar a la clase pila por una serie de tests para 
     * verificar su correcto funcionamiento.
     * En caso de que un test falle, se mostrara un mensaje de error
     * y se detendra el testeo.
     */
    public static void main(String[] args) {
        System.out.println("Inicio de test de la clase Pila");
        boolean success = true;
        int testActual = 0;
        /*
         * Para realizar el test se utiliza un bucle do-while que pasa por
         * todas las fases del test de la clase Pila hasta que se encuentre
         * con un error o hasta que se hayan completado todos los tests.
         */
        do{
            testActual++;
            switch (testActual) {
                case 1:
                    System.out.println("Primer test: apilar");
                    success = testApilar();
                    break;
                case 2:
                    System.out.println("Segundo test: desapilar");
                    success = testDesapilar();
                    break;
                case 3:
                    System.out.println("Tercer test: vaciar");
                    success = testVaciar();
                    break;
                case 4:
                    System.out.println("Cuarto test: obtenerTope");
                    success = testObtenerTope();
                    break;
                case 5:
                    System.out.println("Quinto test: clonar");
                    success = testClonar();
                    break;
                case 6:
                    System.out.println("Sexto test: pila capicua");
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
                case 7:
                    System.out.println("Todos los test realizados con exito");
                    break;
                default:
                    System.out.println("Ocurrio un error inesperado en el testeo de la clase Pila");
                    break;
            }
            if (!success) {
                System.out.println("Deteniendo testeo debido a un error en la clase Pila");
                break;
            }
        }while(success && testActual < 7);
        System.out.println("Fin de test de la clase Pila");
    }
    
    /**
     * Metodo para generar una pila normal de 10 elementos.
     * @param pila de tipo Pila
     */
    public static void genPilaNormal(Pila pila){
        for (int i = 0; i < 10; i++) {
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
        boolean apilado = false;
        apilado = test.apilar(1);
        if (!apilado) {
            System.out.println("Error en el metodo apilar");
        }else{
            if (test.obtenerTope().toString().equals("1")) {
                System.out.println("No se encontro error en el metodo apilar");
                System.out.println("Pila resultante: "+test.toString());
            }else{
                System.out.println("Error en el metodo apilar");
                apilado = false;
            }
        }
        return apilado;
    }

    /**
     * Metodo para testear el metodo desapilar de la clase Pila.
     * @return Boolean: true si el test fue exitoso, false en caso contrario.
     */
    public static boolean testDesapilar(){
        boolean desapilado = false;
        Pila test = new Pila();
        test.apilar(1);
        System.out.println("Pila antes de desapilar: "+test.toString());
        if (test.desapilar()) {
            System.out.println("Pila despues de desapilar: "+test.toString());
            desapilado = true;
        }else{
            System.out.println("Error en el metodo desapilar");
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
        if (test.obtenerTope() != null) {
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
        boolean existeTope = false;
        Pila test = new Pila();
        test.apilar(1);
        if (test.obtenerTope().toString().equals("1")) {
            System.out.println("No se encontro error en el metodo obtenerTope");
            existeTope = true;
            
        }else{
            System.out.println("Error en el metodo obtenerTope");
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
            System.out.println("No se encontro error en el metodo clonar");
        }else{
            System.out.println("Error en el metodo clonar");
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
        return capicua;
    }
}