package persistencia;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import excepciones.*;
import jakarta.persistence.*;
import modelo.Actividad;
import modelo.ClaseDeportiva;
import modelo.Deportista;
import modelo.Entrenador;

public class ManejarPersistenia {

	// ===== USURIO ======================================================================================
	
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
	
	// ===== ACTIVIDAD ===================================================================================

	public boolean actividadExiste(String nombre){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();

		try {
	        Query buscarNombre = em.createNativeQuery("SELECT COUNT(*) FROM ACTIVIDAD WHERE NOMBRE = ?");
	        buscarNombre.setParameter(1, nombre);
	        Number countNick = (Number) buscarNombre.getSingleResult();
	        return countNick.intValue() > 0;
		} finally {
			em.close();
			emf.close();
		}
	}

	public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img, Entrenador ent){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		
		Actividad nuevaActividad = new Actividad();
			
		nuevaActividad.setNombre(nombre);
		nuevaActividad.setDescripcion(desc);
		nuevaActividad.setDuracionHoras(dHoras);
		nuevaActividad.setCosto(costo);
		nuevaActividad.setLugar(lugar);
		nuevaActividad.setFechaAlta(fAlta);
		nuevaActividad.setImagen(img);
		nuevaActividad.setEntrenador(ent);
		
		try {
			em.getTransaction().begin();
			em.persist(nuevaActividad);
			em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public Vector<String> obtenerVectorActividades(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		Vector<String> vActividades = new Vector<String>();
		try {
			Query buscarActividades = em.createNativeQuery("SELECT NOMBRE FROM ACTIVIDAD");
			List<String> actividades = buscarActividades.getResultList();
			for (String ac : actividades) {
				vActividades.add(ac);
			}
		} finally {
			em.close();
			emf.close();
		}
		return vActividades;
	}
	
	public Actividad obtenerActividad(String nom) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		Actividad ret = null;
		
		try {
			Query buscarId = em.createNativeQuery("SELECT ID FROM ACTIVIDAD WHERE NOMBRE = ?");
			buscarId.setParameter(1, nom);
	        int ID = (int) buscarId.getSingleResult();
	        ret = em.find(Actividad.class, ID);
		} finally {
			em.close();
			emf.close();
		}
		return ret;
	}
	
	public String[][] obtenerArrRankingActividades(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		String[][] data = null;
		try {
			Query cantActividades = em.createNativeQuery("SELECT COUNT(DISTINCT ID_ACTIVIDAD) FROM CLASEDEPORTIVA;");
			long cant = (long) cantActividades.getSingleResult();
			data = new String[(int) cant][2];
			
			//Buscar las actividades ordenadas e insertarlas al String[x][0]
			Query buscarActividades = em.createNativeQuery("SELECT a.NOMBRE FROM ACTIVIDAD a JOIN CLASEDEPORTIVA c ON a.ID = c.ID_ACTIVIDAD GROUP BY a.NOMBRE ORDER BY COUNT(c.ID) DESC");
			List<String> act = buscarActividades.getResultList();

			Iterator<String> it = act.iterator();
			for (int i=0; i<cant; i++) {
				data[i][0] = it.next();
			}

			//Buscar la cantidad de clases ordenadas e insertarlas al String[x][1]
			Query buscarCantClases = em.createNativeQuery("SELECT COUNT(c.ID_ACTIVIDAD) FROM ACTIVIDAD a JOIN CLASEDEPORTIVA c ON a.ID = c.ID_ACTIVIDAD GROUP BY a.NOMBRE ORDER BY COUNT(c.ID) DESC");
			List<Long> cla = buscarCantClases.getResultList();
			
			Iterator<Long> it2 = cla.iterator();
			for (int i=0; i<cant; i++) {
				data[i][1] = it2.next().toString();
			}
			
		}finally {
			em.close();
			emf.close();
		}
		return data;
	}
	
	// ===== CLASE =======================================================================================
		
	public void persistirClase(ClaseDeportiva cd) throws PersistenciaException {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			
			em.persist(cd);
			em.getTransaction().commit();

		}catch (Exception e) {
			throw new PersistenciaException("Error al persistir la clase");
		}finally {
			
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		
		}
		
	}
	
	public boolean claseExiste(String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();

		try {
	        Query buscarNombre = em.createNativeQuery("SELECT COUNT(*) FROM CLASEDEPORTIVA WHERE NOMBRE = ?");
	        buscarNombre.setParameter(1, nombre);
	        Number countNick = (Number) buscarNombre.getSingleResult();
	        return countNick.intValue() > 0;
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public Vector<String> obtenerVectorClasesActividad(String nom){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		Vector<String> vClases = new Vector<String>();
		
		try {
			Query buscarId = em.createNativeQuery("SELECT ID FROM ACTIVIDAD WHERE NOMBRE = ?");
			buscarId.setParameter(1, nom);
			int id = (int) buscarId.getSingleResult();
			Query buscarClase = em.createNativeQuery("SELECT NOMBRE FROM CLASEDEPORTIVA WHERE ID_ACTIVIDAD = ?");
			buscarClase.setParameter(1, id);
			List<String> clases = buscarClase.getResultList();
			for (String cl : clases) {
				vClases.add(cl);
			}
		}finally {
			em.close();
			emf.close();
		}
		return vClases;
	}
	
	public ClaseDeportiva obtenerClase(String nom) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		ClaseDeportiva ret = null;
		try {
			Query buscarId = em.createNativeQuery("SELECT ID FROM CLASEDEPORTIVA WHERE NOMBRE = ?");
			buscarId.setParameter(1, nom);
			int id = (int) buscarId.getSingleResult();
			ret = em.find(ClaseDeportiva.class, id);
		}finally {
			em.close();
			emf.close();
		}
		return ret;
	}
	
	public Vector<String> obtenerListaInscripciones(String nom){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();
		Vector<String> vInsc = new Vector<String>();
		
		try {
			Query buscarIdClase = em.createNativeQuery("SELECT ID FROM CLASEDEPORTIVA WHERE NOMBRE = ?");
			buscarIdClase.setParameter(1, nom);
			int id = (int) buscarIdClase.getSingleResult();
			
			Query buscarClase = em.createNativeQuery("SELECT ID_DEPORTISTA FROM INSCRIPCION WHERE ID_CLASEDEPORTIVA = ?");
			buscarClase.setParameter(1, id);
			List<Integer> insc = buscarClase.getResultList();
			
			for (Integer i : insc) {
				Query buscarNombre = em.createNativeQuery("SELECT NICKNAME FROM USUARIO WHERE ID = ?");
				buscarNombre.setParameter(1, i);
				vInsc.add(buscarNombre.getSingleResult().toString());
			}
			
		}finally {
			em.close();
			emf.close();
		}
		return vInsc;
	}

	public void modificarDeportista(Deportista dep) throws PersistenciaException {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(dep);
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
	
public void modificarEntrenador(Entrenador ent) throws PersistenciaException {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			
			emf = Persistence.createEntityManagerFactory("airelibre_desk");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(ent);
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
	
}
