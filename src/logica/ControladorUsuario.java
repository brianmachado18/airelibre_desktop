package logica;

import java.time.*;
import java.util.List;
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

	public Vector<String> obtenerVectorDeportistas() throws PersistenciaException{
		return m.obtenerVectorDeportistas();
	}
	
	//True si el usuario existe
	public boolean usuarioExiste(String nickname) throws PersistenciaException{
		return m.usuarioExiste(nickname);
	}
	
	//True si el nickname o el email existe
	public boolean usuarioExiste(String nickname, String email) throws PersistenciaException{
		return m.usuarioExiste(nickname, email);
	}
	
	//Alta del usuario
	public void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web, String imagen) throws PersistenciaException{
		
		try {	
			if ("Entrenador".equals(tipoUsuario.trim())) { // Si es entrenador
				Entrenador nuevoEntrenador = new Entrenador();
				nuevoEntrenador.setNickname(nickname);
				nuevoEntrenador.setContrasena(contrasena);
				nuevoEntrenador.setNombre(nombre);
				nuevoEntrenador.setApellido(apellido);
				nuevoEntrenador.setMail(email);
				nuevoEntrenador.setFechaNacimiento(fechaNacimiento);
				nuevoEntrenador.setDisciplina(disciplina);
				nuevoEntrenador.setSitioWeb(web);
				nuevoEntrenador.setImagen(imagen);

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
				nuevoDeportista.setImagen(imagen);
				
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
	
	//Retorn un Vector con todos los nicknames de entrenadores 
	public List<String> obtenerListaEntrenadores() throws PersistenciaException{
		return m.obtenerVectorEntrenadores();
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
			if (tipoUsuario.compareTo("Entrenador")==0) { // Si es entrenador
				m.modificarEntrenador(nickname, contrasena, nombre, apellido, email, fechaNacimiento, disciplina, web);
			} else { // Si es deportista
				m.modificarDeportista(nickname, contrasena, nombre, apellido, email, fechaNacimiento, esProfesional);
			}
		}catch (Exception e) {
			throw new PersistenciaException("Error al modificar el usuario");
		}
	}

}
