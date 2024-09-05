package logica;

import java.time.LocalDate;
import java.util.Vector;

import datatype.DtActividad;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;

public interface IControladorActividad {
    
	public abstract boolean actividadExiste(String nombre);
	
	public abstract void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img,  DtEntrenador ent);
	
	public abstract Vector<String> obtenerVectorActividad();
	
	public abstract DtActividad obtenerActividad(String nom);
	
	public abstract Vector<String> obtenerVectorClasesActividad(String nom);
	
	public abstract String[][] obtenerArrRankingActividades();
	
	public abstract Vector<String> obtenerVectorUsuarios() throws PersistenciaException;

}
