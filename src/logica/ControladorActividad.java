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
import persistencia.ManejarPersistenia;

public class ControladorActividad implements IControladorActividad {

	ManejarPersistenia m = new ManejarPersistenia();
	
    public ControladorActividad() {
    }
    
	public boolean actividadExiste(String nombre){
		return m.actividadExiste(nombre);
	}


	//AltaActividad
	public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img, Entrenador ent){
		m.AltaActividad(nombre, desc, dHoras, costo, lugar, fAlta, img, ent);
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