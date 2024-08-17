package excepciones;

@SuppressWarnings("serial")
/*La advertencia "serial" se genera por el compilador cuando una clase implementa Serializable
 * pero no tiene el campo serialVersionUID. La anotaci�n @SuppressWarnings("serial") se coloca en la clase
 * para indicar al compilador que ignore esta advertencia espec�fica.*/

public class UsuarioRepetidoException extends Exception {

    public UsuarioRepetidoException(String string) {
        super(string);  // Le pasamos al constructor de la clase que esta heredando ese valor a clase padre
                        // Esto agrega informacion adicional y especifica al manejador de excepciones
                        // De otra manera tendria que mandar el programador los mensajes a consola
    }

}
