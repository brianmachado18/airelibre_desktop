package logica;

import java.time.LocalDate;

import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;


public interface IControladorUsuario {


	public abstract void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException;

	public abstract DtDeportista verInfoDeportista(String nickname)throws UsuarioNoExisteException;

	public abstract DtEntrenador verInfoEntrenador(String nickname)throws UsuarioNoExisteException;

	public abstract void ModUsuario(String nombre, String ap, LocalDate fNac, String pass, boolean tipo) throws UsuarioRepetidoException;

	public abstract DtDeportista[] getDeportistas() throws UsuarioNoExisteException;

	public abstract DtEntrenador[] getEntrenadores() throws UsuarioNoExisteException;
}
