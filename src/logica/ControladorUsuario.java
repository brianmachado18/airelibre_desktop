package logica;

import java.time.*;
import datatype.*;
import excepciones.*;
import jakarta.persistence.*;
import modelo.Deportista;
import modelo.Entrenador;


public class ControladorUsuario implements IControladorUsuario {

	public ControladorUsuario(){

	}

	public boolean usuarioExiste(String nick, String mail){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();

		try {

	        // Consulto si existe el ususario
	        Query buscarNombre = em.createNativeQuery("SELECT COUNT(*) FROM USUARIO WHERE NICKNAME = ?");
	        buscarNombre.setParameter(1, nick);
	        Number countNick = (Number) buscarNombre.getSingleResult();
	        
	        Query buscarMail = em.createNativeQuery("SELECT COUNT(*) FROM USUARIO WHERE MAIL = ?");
	        buscarMail.setParameter(1, mail);
	        Number countMail = (Number) buscarMail.getSingleResult();

	        return countNick.intValue() > 0 || countMail.intValue() > 0;
	        
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}


	//AltaUsuario
	public void AltaUsuario(String nickname, String contrasena, String nombre, String apellido, String email, LocalDate fechaNacimiento, String tipoUsuario, boolean esProfesional, String disciplina, String web){
		
		//Defino conectores db
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			//Inicio conectores db
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();
			
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
				
				//Guardo en db
				em.getTransaction().begin();
				em.persist(nuevoEntrenador);
				em.getTransaction().commit();

			} else { // Si es deportista
				Deportista nuevoDeportista = new Deportista();
				nuevoDeportista.setNickname(nickname);
				nuevoDeportista.setContrasena(contrasena);
				nuevoDeportista.setNombre(nombre);
				nuevoDeportista.setApellido(apellido);
				nuevoDeportista.setMail(email);
				nuevoDeportista.setFechaNacimiento(fechaNacimiento);
				nuevoDeportista.setEsProfesional(esProfesional);
				
				//Guardo en db
				em.getTransaction().begin();
				em.persist(nuevoDeportista);
				em.getTransaction().commit();
			}


		} catch (Exception e) {
			throw new RuntimeException("Error al persistir el usuario: " + e.getMessage(), e);
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
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
