package logica;

import java.time.LocalDate;
import java.util.Vector;

import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;


public interface IControladorUsuario {


	public abstract void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException;

	public abstract Vector<String> obtenerVectorUsuarios() throws PersistenciaException;
	
	public abstract boolean usuarioExiste(String nickname) throws PersistenciaException;
	
	public abstract boolean usuarioExiste(String nickname, String email) throws PersistenciaException;
	
	public abstract boolean esEntrenador(String nickname) throws PersistenciaException;
	
	public abstract DtEntrenador obtenerEntrenador(String nickname) throws PersistenciaException;
	
	public abstract DtDeportista obtenerDeportista(String nickname) throws PersistenciaException;
	
	public abstract void modifiarUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException;
}
