package logica;

import java.time.*;
import datatype.*;
import excepciones.*;
import jakarta.persistence.*;
import persistencia.*;
import modelo.Deportista;
import modelo.Entrenador;


public class ControladorUsuario implements IControladorUsuario {

	ManejarPersistenia m = new ManejarPersistenia();
	
	public ControladorUsuario(){

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
