package logica;

import java.time.LocalDate;
import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;


public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }
    
    //AltaUsuario
    public void AltaUsuario(String nick, String nombre, String ap, String mail, LocalDate fNac, String pass) throws UsuarioRepetidoException{
    	//Agrego throw para que no rompa
    	throw new UsuarioRepetidoException("El usuario " + nick + " ya esta registrado");
    	//...
    }
    
    //buscarNick
    public boolean buscarNick(String nickname)throws UsuarioNoExisteException{
    	//Agrego throw para que no rompa
    	throw new UsuarioNoExisteException("El usuario " + nickname + " no existe");
    	//...
    }
    
    //verInfoDeportista
    public DtDeportista verInfoDeportista(String nickname)throws UsuarioNoExisteException{
    	//Agrego throw para que no rompa
    	throw new UsuarioNoExisteException("El usuario " + nickname + " no existe");
    	//...
    }
    
    //verInfoEntrenador
    public DtEntrenador verInfoEntrenador(String nickname)throws UsuarioNoExisteException{
    	//Agrego throw para que no rompa
    	throw new UsuarioNoExisteException("El usuario " + nickname + " no existe");
    	//...
    }
    
    //ModUsuario
    public void ModUsuario(String nombre, String ap, LocalDate fNac, String pass, boolean tipo) throws UsuarioRepetidoException{
    	//Agrego throw para que no rompa
    	throw new UsuarioRepetidoException("El usuario " + nombre + " ya esta registrado");
    	//...
    }
    
    //getDeportistas
    public DtDeportista[] getDeportistas() throws UsuarioNoExisteException{
    	//Agrego throw para que no rompa
    	throw new UsuarioNoExisteException("El usuario no existe");
    	//...
    }
    
    //getEntrenadores
    public DtEntrenador[] getEntrenadores() throws UsuarioNoExisteException{
    	//Agrego throw para que no rompa
    	throw new UsuarioNoExisteException("El usuario no existe");
    	//...
    }
    
}
