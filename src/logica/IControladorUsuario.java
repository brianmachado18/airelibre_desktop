package logica;

import java.time.LocalDate;
import java.util.Vector;

import excepciones.PersistenciaException;
import modelo.Deportista;
import modelo.Entrenador;


public interface IControladorUsuario {


	public abstract void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException;

	public abstract Vector<String> obtenerVectorUsuarios() throws PersistenciaException;
	
	public abstract boolean usuarioExiste(String nickname) throws PersistenciaException;
	
	public abstract boolean usuarioExiste(String nickname, String email) throws PersistenciaException;
	
	public abstract boolean esEntrenador(String nickname) throws PersistenciaException;
	
	public abstract Entrenador obtenerEntrenador(String nickname) throws PersistenciaException; //DtEntrenador
	
	public abstract Deportista obtenerDeportista(String nickname) throws PersistenciaException; //DtDeportista
	
}
