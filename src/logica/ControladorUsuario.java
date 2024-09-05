package logica;

import java.time.*;
import java.util.Vector;

import datatype.DtDeportista;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;
import modelo.Deportista;
import modelo.Entrenador;
import persistencia.ManejarPersistenia;


public class ControladorUsuario implements IControladorUsuario {

	ManejarPersistenia m = new ManejarPersistenia();
	
	public ControladorUsuario(){}

	//True si el usuario existe
	public boolean usuarioExiste(String nickname) throws PersistenciaException{
		return m.usuarioExiste(nickname);
	}
	
	//True si el nickname o el email existe
	public boolean usuarioExiste(String nickname, String email) throws PersistenciaException{
		return m.usuarioExiste(nickname, email);
	}
	
	//Alta del usuario
	public void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web) throws PersistenciaException{
		
		try {	
			if (tipoUsuario == "Entrenador") { // Si es entrenador
				Entrenador nuevoEntrenador = new Entrenador();
				nuevoEntrenador.setNickname(nickname);
				nuevoEntrenador.setContrasena(contrasena);
				nuevoEntrenador.setNombre(nombre);
				nuevoEntrenador.setApellido(apellido);
				nuevoEntrenador.setMail(email);
				nuevoEntrenador.setFechaNacimiento(fechaNacimiento);
				nuevoEntrenador.setDisciplina(disciplina);
				nuevoEntrenador.setSitioWeb(web);

				m.persistirEntrenador(nuevoEntrenador);

			} else { // Si es deportista
				Deportista nuevoDeportista = new Deportista();
				nuevoDeportista.setNickname(nickname);
				nuevoDeportista.setContrasena(contrasena);
				nuevoDeportista.setNombre(nombre);
				nuevoDeportista.setApellido(apellido);
				nuevoDeportista.setMail(email);
				nuevoDeportista.setFechaNacimiento(fechaNacimiento);
				nuevoDeportista.setEsProfesional(esProfesional);
				
				m.persistirDeportista(nuevoDeportista);
			}
		}catch (Exception e) {
			throw new PersistenciaException("Error al persistir el usuario");
		}
	}
	
	//Retorna un Vector con todos los nicknames de los usuarios
	public Vector<String> obtenerVectorUsuarios() throws PersistenciaException{
		return m.obtenerVectorUsuarios();
	}
	
	//True si es entrenador
	public boolean esEntrenador(String nickname) throws PersistenciaException{
		return m.esEntrenador(nickname);
	}
	
	//Retorna un objeto entrenador
	public DtEntrenador obtenerEntrenador(String nickname) throws PersistenciaException{
		return DtEntrenador.toDataType(m.obtenerEntrenador(nickname));
	}
	
	//Retorna un objeto deportista
	public DtDeportista obtenerDeportista(String nickname) throws PersistenciaException{
		return DtDeportista.toDataType(m.obtenerDeportista(nickname));
	}
	
	public void modifiarUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web)throws PersistenciaException{
		try {	
			if (tipoUsuario == "Entrenador") { // Si es entrenador
				Entrenador nuevoEntrenador = new Entrenador();
				nuevoEntrenador.setNickname(nickname);
				nuevoEntrenador.setContrasena(contrasena);
				nuevoEntrenador.setNombre(nombre);
				nuevoEntrenador.setApellido(apellido);
				nuevoEntrenador.setMail(email);
				nuevoEntrenador.setFechaNacimiento(fechaNacimiento);
				nuevoEntrenador.setDisciplina(disciplina);
				nuevoEntrenador.setSitioWeb(web);

				m.modificarEntrenador(nuevoEntrenador);

			} else { // Si es deportista
				Deportista nuevoDeportista = new Deportista();
				nuevoDeportista.setNickname(nickname);
				nuevoDeportista.setContrasena(contrasena);
				nuevoDeportista.setNombre(nombre);
				nuevoDeportista.setApellido(apellido);
				nuevoDeportista.setMail(email);
				nuevoDeportista.setFechaNacimiento(fechaNacimiento);
				nuevoDeportista.setEsProfesional(esProfesional);
				
				m.modificarDeportista(nuevoDeportista);
			}
		}catch (Exception e) {
			throw new PersistenciaException("Error al persistir el usuario");
		}
	}

}
