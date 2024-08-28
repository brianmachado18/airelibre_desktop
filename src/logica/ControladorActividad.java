package logica;

import java.time.LocalDate;

import datatype.DtActividad;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.UsuarioNoExisteException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.Actividad;
import modelo.Deportista;
import modelo.Entrenador;

public class ControladorActividad implements IControladorActividad {

    public ControladorActividad() {
    }
    
	public boolean actividadExiste(String nombre){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
		EntityManager em = emf.createEntityManager();

		try {

	        // Consulto si existe la Actividad
	        Query buscarNombre = em.createNativeQuery("SELECT COUNT(*) FROM ACTIVIDAD WHERE NOMBRE = ?");
	        buscarNombre.setParameter(1, nombre);
	        Number countNick = (Number) buscarNombre.getSingleResult();
	        
	        return countNick.intValue() > 0;
	        
		}finally{
			em.close();
			emf.close();
		}
	}


	//AltaActividad
	public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img, Entrenador ent){
		
		//Defino conectores db
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
			
			
			//Guardo en db
			em.getTransaction().begin();
			em.persist(nuevaActividad);
			em.getTransaction().commit();


			boolean a = actividadExiste(nombre);
			if(a == true){
				//throw new ActividadRepetidaException("La actividad " + ci + " no existe");
			}	
		
				em.close();
				emf.close();
		
	}
    
    //ListarActividades
    public DtActividad ListarActividades() throws ActividadNoExisteException{
    	//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad no existe");
    	//...
    }
    
    //ConsultaActividad
    public DtActividad ConsultaActividad(String nombre) throws ActividadNoExisteException{
    	//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad no existe");
    	//...
    }
    
    //ModActividades
    public void ModActividades(String desc, int dHoras, int costo, String lugar, String img) throws ActividadNoExisteException{
    	//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad no existe");
    	//...
    }
    
}