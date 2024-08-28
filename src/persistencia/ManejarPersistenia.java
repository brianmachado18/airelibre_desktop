package persistencia;

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
		}finally 
		{
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

	
}
