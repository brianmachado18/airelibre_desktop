package logica;

import java.time.*;
import java.util.Vector;

import datatype.*;
import excepciones.*;
import persistencia.*;
import modelo.Deportista;
import modelo.Entrenador;


public class ControladorUsuario implements IControladorUsuario {

	ManejarPersistenia m = new ManejarPersistenia();
	
	public ControladorUsuario(){

	}

	//True si el usuario existe
	public boolean usuarioExiste(String nickname) throws PersistenciaException{
		return m.usuarioExiste(nickname);
	}
	public boolean usuarioExiste(String nickname, String email) throws PersistenciaException{
		return m.usuarioExiste(nickname, email);
	}
	
	//AltaUsuario
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
	public Entrenador obtenerEntrenador(String nickname) throws PersistenciaException{
		return m.obtenerEntrenador(nickname);
	}
	
	//Retorna un objeto deportista
	public Deportista obtenerDeportista(String nickname) throws PersistenciaException{
		return m.obtenerDeportista(nickname);
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
