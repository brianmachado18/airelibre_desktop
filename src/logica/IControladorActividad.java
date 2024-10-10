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
	
	public abstract Vector<String> obtenerVectorActividades() throws PersistenciaException;

	public abstract Vector<String> obtenerVectorActividadesAceptadas() throws PersistenciaException;
	
	public abstract Vector<String> obtenerVectorActividadesPendientes() throws PersistenciaException;
	
	public abstract void modificarActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img,  DtEntrenador ent);
	
	public abstract void actualizarEstado(boolean estado, String nombre);
	
	public abstract String[][] obtenerArrayActividadesAceptadasEntrenador(String nickname);
	
	public abstract String[][] obtenerArrayActividadesEntrenador(String nickname);
    
	public abstract Vector<String> obtenerVectorActividadesAceptadasEntrenador(String nickname);

}
