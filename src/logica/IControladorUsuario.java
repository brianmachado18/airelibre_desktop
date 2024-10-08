package logica;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;


public interface IControladorUsuario {

	public abstract String obtenerNickname(String mail) throws PersistenciaException;
	
	public abstract boolean traerPass(String nickname, String mail, String pass) throws PersistenciaException;
	
	public abstract void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web, String imagen)throws PersistenciaException;

	public abstract Vector<String> obtenerVectorUsuarios() throws PersistenciaException;
	
	public abstract List<String> obtenerListaEntrenadores() throws PersistenciaException;
	
	public abstract boolean usuarioExiste(String nickname) throws PersistenciaException;
	
	public abstract boolean usuarioExiste(String nickname, String email) throws PersistenciaException;
	
	public abstract boolean esEntrenador(String nickname) throws PersistenciaException;
	
	public abstract DtEntrenador obtenerEntrenador(String nickname) throws PersistenciaException;
	
	public abstract DtDeportista obtenerDeportista(String nickname) throws PersistenciaException;
	
	public abstract Vector<String> obtenerVectorDeportistas() throws PersistenciaException;
	
	public abstract void modifiarUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException;
}
