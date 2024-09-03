package logica;

import java.time.LocalDate;
import java.util.Vector;

import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.Entrenador;
import persistencia.ManejarPersistenia;

public class ControladorActividad implements IControladorActividad {

	ManejarPersistenia m = new ManejarPersistenia();
	
    public ControladorActividad(){}
    
    //Retorna true si la actividad 'nom' existe
	public boolean actividadExiste(String nom){
		return m.actividadExiste(nom);
	}
	
	//Retorna un vector con todas las actividades
	public Vector<String> obtenerVectorActividad(){
		return m.obtenerVectorActividades();
	}
	
	//Devuelve un DtActividad de la actividad 'nom'
	public Actividad obtenerActividad(String nom) {
		return m.obtenerActividad(nom);
	}
	
	//Array de dos columnas, la primara con el nombre de una actividad y la segunda con su cantidad de clases
	public String[][] obtenerArrRankingActividades(){
		return m.obtenerArrRankingActividades();
	}

	//Alta de una actividad
	public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img, Entrenador ent){
		m.AltaActividad(nombre, desc, dHoras, costo, lugar, fAlta, img, ent);
	}
	
	//Retorna un Vector con todos los nombres de las actividades
	public Vector<String> obtenerVectorUsuarios() throws PersistenciaException{
		return m.obtenerVectorActividades();
	}
	
	//Retorna un vector con el nombre de todas las clases de una actividad
	public Vector<String> obtenerVectorClasesActividad(String nom){
		return m.obtenerVectorClasesActividad(nom);
	}
    
}