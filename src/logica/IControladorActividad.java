package logica;

import java.time.LocalDate;
import java.util.Vector;

import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.Entrenador;

public interface IControladorActividad {
    
	public abstract boolean actividadExiste(String nombre);
	
	public abstract void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img,  Entrenador ent);
	
	public abstract Vector<String> obtenerVectorActividad();
	
	public abstract Actividad obtenerActividad(String nom); //DtActividad
	
	public abstract Vector<String> obtenerVectorClasesActividad(String nom);
	
	public abstract String[][] obtenerArrRankingActividades();
	
	public abstract Vector<String> obtenerVectorUsuarios() throws PersistenciaException;

}
