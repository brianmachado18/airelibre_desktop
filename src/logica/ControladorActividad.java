package logica;

import java.time.LocalDate;
import java.util.Vector;

import datatype.DtActividad;
import datatype.DtEntrenador;
import excepciones.PersistenciaException;
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
	public DtActividad obtenerActividad(String nom) {
		return DtActividad.toDataType(m.obtenerActividad(nom));
	}
	
	//Array de dos columnas, la primara con el nombre de una actividad y la segunda con su cantidad de clases
	public String[][] obtenerArrRankingActividades(){
		return m.obtenerArrRankingActividades();
	}

	//Alta de una actividad
	public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img, DtEntrenador ent){
		m.AltaActividad(nombre, desc, dHoras, costo, lugar, fAlta, img, DtEntrenador.toObject(ent));
	}
	
	//Retorna un Vector con todos los nombres de las actividades
	public Vector<String> obtenerVectorActividades() throws PersistenciaException{
		return m.obtenerVectorActividades();
	}
	
	public Vector<String> obtenerVectorActividadesAceptadas() throws PersistenciaException{
		return m.obtenerVectorActividadesAceptadas();
	}
	
	public Vector<String> obtenerVectorActividadesPendientes() throws PersistenciaException{
		return m.obtenerVectorActividadesPendientes();
	}
	
	//Retorna un vector con el nombre de todas las clases de una actividad
	public Vector<String> obtenerVectorClasesActividad(String nom){
		return m.obtenerVectorClasesActividad(nom);
	}
	
	public void modificarActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img,  DtEntrenador ent) {
		m.modificarActividad(nombre, desc, dHoras, costo, lugar, fAlta, img, DtEntrenador.toObject(ent));
	}
	
	public void actualizarEstado(boolean estado, String nombre) {
		m.actualizarEstado(estado, nombre);
	}
	
	public String[][] obtenerVectorActividadesAceptadasEntrenador(String nickname){
		return m.obtenerVectorActividadesAceptadasEntrenador(nickname);
	}
	
	public String[][] obtenerVectorActividadesEntrenador(String nickname){
		return m.obtenerVectorActividadesEntrenador(nickname);
	}
    
}