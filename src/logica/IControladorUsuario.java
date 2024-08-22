package logica;

import java.time.LocalDate;

import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;


public interface IControladorUsuario {

    /**
     * Registra al usuario en el sistema.
     * @throws UsuarioRepetidoException Si el nickname del usuario se encuentra registrada en el sistema.
     */
    public abstract void AltaUsuario(String nick, String nombre, String ap, String mail, LocalDate fNac, String pass) throws UsuarioRepetidoException;

    /**
     * Retorna true o false dependiendo del tiupo de usuario con el nickname indicado.
     * @throws UsuarioNoExisteException Si el nickname del usuario no está registrada en el sistema.
     */
    public abstract boolean buscarNick(String nickname)throws UsuarioNoExisteException;

    /**
     * Retorna la informacion del usuario especificado con el nick.
     * @throws UsuarioNoExisteException Si el nickname del usuario no está registrada en el sistema.
     */
    public abstract DtDeportista verInfoDeportista(String nickname)throws UsuarioNoExisteException;
    public abstract DtEntrenador verInfoEntrenador(String nickname)throws UsuarioNoExisteException;

    /**
     * Retorna la informacion del usuario especificado con el nick y permite modificar los datos.
     * @throws UsuarioNoExisteException Si el nickname del usuario no está registrada en el sistema.
     */
    public abstract void ModUsuario(String nombre, String ap, LocalDate fNac, String pass, boolean tipo) throws UsuarioRepetidoException;

    /**
     * Retorna la información de todos los usuarios registrados en el sistema.
     * @return Información de los usuarios del sistema.
     * @throws UsuarioNoExisteException Si no existen usuarios registrados en el sistema.
     */
    public abstract DtDeportista[] getDeportistas() throws UsuarioNoExisteException;
    public abstract DtEntrenador[] getEntrenadores() throws UsuarioNoExisteException;
}
