package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import excepciones.ClaseRepetidoException;
import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.ClaseDeportiva;
import persistencia.ManejarPersistenia;

public class ControladorClaseDeportiva implements IControladorClaseDeportiva{

	ManejarPersistenia m = new ManejarPersistenia();
	
	public ControladorClaseDeportiva(){}

	//Alta de una clase deportiva
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, Actividad Act) throws ClaseRepetidoException, PersistenciaException{
		
		ClaseDeportiva nuevaClaseDeportiva = new ClaseDeportiva();
		try {
			nuevaClaseDeportiva.setActividad(Act);
			nuevaClaseDeportiva.setCupo(cupo);
			nuevaClaseDeportiva.setFecha(fecha);
			nuevaClaseDeportiva.setFechaAlta(fAlta);
			nuevaClaseDeportiva.setHora(hora);
			nuevaClaseDeportiva.setLugar(lugar);
			nuevaClaseDeportiva.setNombre(nombreClaseDeportiva);
			nuevaClaseDeportiva.setImagen(null);
			nuevaClaseDeportiva.setInscripciones(null);
			
			m.persistirClase(nuevaClaseDeportiva);
		} catch (Exception e) {
			throw new ClaseRepetidoException("La clase " + nombreClaseDeportiva + " ya esta registrada");
		}

	}
	
	//Retorna el DtClaseDeportiva de la clase con nombre 'nom'
	public ClaseDeportiva obtenerClase(String nom) {
		return m.obtenerClase(nom);
	}
	
	//Retorna un vector con todas las inscripciones de una clase con nombre 'nom'
	public Vector<String> obtenerListaInscripciones(String nom){
		return m.obtenerListaInscripciones(nom);
	}
	
	//True si la clase 'nom' existe
	public boolean claseExiste(String nombre){
		return m.claseExiste(nombre);
	}
	
}
