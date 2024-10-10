package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import datatype.DtActividad;
import datatype.DtClaseDeportiva;
import datatype.DtInscripcion;
import excepciones.ClaseNoExisteException;
import excepciones.PersistenciaException;
import modelo.ClaseDeportiva;
import persistencia.ManejarPersistenia;

public class ControladorClaseDeportiva implements IControladorClaseDeportiva{

	ManejarPersistenia m = new ManejarPersistenia();
	
	public ControladorClaseDeportiva(){}

	//Alta de una clase deportiva
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, DtActividad Act, String imagen) throws PersistenciaException{
		
		ClaseDeportiva nuevaClaseDeportiva = new ClaseDeportiva();
		try {
			System.out.println(nombreClaseDeportiva);
			nuevaClaseDeportiva.setActividad(DtActividad.toObject(Act));
			nuevaClaseDeportiva.setCupo(cupo);
			nuevaClaseDeportiva.setFecha(fecha);
			nuevaClaseDeportiva.setFechaAlta(fAlta);
			nuevaClaseDeportiva.setHora(hora);
			nuevaClaseDeportiva.setLugar(lugar);
			nuevaClaseDeportiva.setNombre(nombreClaseDeportiva);
			nuevaClaseDeportiva.setImagen(imagen);
			nuevaClaseDeportiva.setInscripciones(null);
			m.persistirClase(nuevaClaseDeportiva);
		} catch (Exception e) {
			throw new PersistenciaException("Error al conectarse a la base de datos");
		}

	}
	
	//Retorna el DtClaseDeportiva de la clase con nombre 'nom'
	public DtClaseDeportiva obtenerClase(String nom) {
		return DtClaseDeportiva.toDataType(m.obtenerClase(nom));
	}
	
	public Vector<String> obtenerVectorClases(){
		return m.obtenerVectorClases();
	}
	
	//Retorna un vector con todas las inscripciones de una clase con nombre 'nom'
	public Vector<String> obtenerListaInscripciones(String nom){
		return m.obtenerListaInscripciones(nom);
	}
	
	//True si la clase 'nom' existe
	public boolean claseExiste(String nombre){
		return m.claseExiste(nombre);
	}
	
	public void AltainscripcionAClase(String nomClase, String NomDeportista,int CantidadDesportistas,LocalDate FechaInscripcion) throws ClaseNoExisteException{
		//Agrego throw para que no rompa
    	//throw new ClaseNoExisteException("La clase" + nomClase + "no existe");
    	m.persistirInscripcion(nomClase, NomDeportista,CantidadDesportistas , FechaInscripcion);
	}
	public  boolean DeportistaEstaEnClase(String nombreDep,String NombreCla) {
	
		return m.DeportistaEnClase(nombreDep, NombreCla);
	};
	
	public  int CuposDisponiblesEnClase(String nomClase){
		//Agrego throw para que no rompa
    	//throw new ClaseNoExisteException("La clase" + nomClase + "no existe");
		return m.CuposDisponiblesEnClase(nomClase);
	};
	
	public Vector<String> obtenerClasesDeportista(String nickname){
		return m.obtenerClasesDeportista(nickname);
	}
	
	public String[][] obtenerInscrpcionesDeportista(String nickname){
		return m.obtenerInscrpcionesDeportista(nickname);
	}
	
}
