package persistencia;

import java.util.List;
import java.util.Vector;

import excepciones.*;
import jakarta.persistence.*;
import modelo.Deportista;
import modelo.Entrenador;

public class ManejarPersistenia {
	
	public void persistirEntrenador(Entrenador ent) throws PersistenciaException {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(ent);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			throw new PersistenciaException("Error al persistir el usuario");
		}finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
		
	}
	
	public void persistirDeportista(Deportista dep) throws PersistenciaException {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(dep);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			throw new PersistenciaException("Error al persistir el usuario");
		}finally {
			
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		
		}
		
	}
	
	public boolean usuarioExiste(String nick, String mail) throws PersistenciaException{

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();
			
	        // Consulto si existe el ususario
	        Query buscarNombre = em.createNativeQuery("SELECT COUNT(*) FROM USUARIO WHERE NICKNAME = ?");
	        buscarNombre.setParameter(1, nick);
	        Number countNick = (Number) buscarNombre.getSingleResult();
	        
	        Query buscarMail = em.createNativeQuery("SELECT COUNT(*) FROM USUARIO WHERE MAIL = ?");
	        buscarMail.setParameter(1, mail);
	        Number countMail = (Number) buscarMail.getSingleResult();

	        return countNick.intValue() > 0 || countMail.intValue() > 0;
	        
		}catch (Exception e) {
			throw new PersistenciaException("Error al conectarse a la base de datos");
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
	
	public boolean usuarioExiste(String nick) throws PersistenciaException{
	
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();
			
	        // Consulto si existe el ususario
	        Query buscarNombre = em.createNativeQuery("SELECT COUNT(*) FROM USUARIO WHERE NICKNAME = ?");
	        buscarNombre.setParameter(1, nick);
	        Number countNick = (Number) buscarNombre.getSingleResult();

	        return countNick.intValue() > 0;
	        
		}catch (Exception e) {
			throw new PersistenciaException("Error al conectarse a la base de datos");
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
	
	public Vector<String> obtenerVectorUsuarios() throws PersistenciaException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		
		Vector<String> vUsuarios = new Vector<String>();
		
		try {
			Query buscarUsuario = em.createNativeQuery("SELECT NICKNAME FROM USUARIO");
			List<String> usuarios = buscarUsuario.getResultList();

			for (String us : usuarios) {
				vUsuarios.add(us);
			}
		}finally {
			em.close();
			emf.close();
		}
		return vUsuarios;
	}
	
	public boolean esEntrenador(String nick) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		boolean ret;
		
		try {
			Query buscarUsuario = em.createNativeQuery("SELECT DTYPE FROM USUARIO WHERE NICKNAME = ?");
			buscarUsuario.setParameter(1, nick);
			ret = buscarUsuario.getSingleResult().equals("Entrenador");
		}finally {
			em.close();
			emf.close();
		}
		return ret;
	}
	
	public Entrenador obtenerEntrenador(String nick) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		Entrenador ret = null;
		
		try {
			Query buscarId = em.createNativeQuery("SELECT ID FROM USUARIO WHERE NICKNAME = ?");
			buscarId.setParameter(1, nick);
	        int ID = (int) buscarId.getSingleResult();
	        ret = em.find(Entrenador.class, ID);
		}finally {
			em.close();
			emf.close();
		}
		return ret;
	}
	
	public Deportista obtenerDeportista(String nick) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		Deportista ret = null;
		
		try {
			Query buscarId = em.createNativeQuery("SELECT ID FROM USUARIO WHERE NICKNAME = ?");
			buscarId.setParameter(1, nick);
	        int ID = (int) buscarId.getSingleResult();
	        ret = em.find(Deportista.class, ID);
		}finally {
			em.close();
			emf.close();
		}
		return ret;
	}
	
}
