package logica;

import java.time.LocalDate;
import java.util.Vector;

import datatype.DtActividad;
import excepciones.ActividadNoExisteException;
import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.Entrenador;
import persistencia.ManejarPersistenia;

public class ControladorActividad implements IControladorActividad {

	ManejarPersistenia m = new ManejarPersistenia();
	
    public ControladorActividad() {
    }
    
	public boolean actividadExiste(String nombre){
		return m.actividadExiste(nombre);
	}
	
	public Vector<String> obtenerVectorActividad(){
		Vector<String> ret = null;
		try {
			ret = m.obtenerVectorActividades();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public Actividad obtenerActividad(String nom) {
		return m.obtenerActividad(nom);
	}


	//AltaActividad
	public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img, Entrenador ent){
		m.AltaActividad(nombre, desc, dHoras, costo, lugar, fAlta, img, ent);
	}
	
	//Retorna un Vector con todos los nombres de las actividades
	public Vector<String> obtenerVectorUsuarios() throws PersistenciaException{
		return m.obtenerVectorActividades();
	}
	
	public Vector<String> obtenerVectorClasesActividad(String nom){
		return m.obtenerVectorClasesActividad(nom);
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