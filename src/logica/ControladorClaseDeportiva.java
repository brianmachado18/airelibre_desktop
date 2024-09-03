package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import datatype.DtClaseDeportiva;
import datatype.DtInscripcion;
import excepciones.ActividadNoExisteException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidoException;
import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.ClaseDeportiva;
import persistencia.ManejarPersistenia;

public class ControladorClaseDeportiva implements IControladorClaseDeportiva{

	ManejarPersistenia m = new ManejarPersistenia();

	//AltaClaseDeportiva
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
	
	public ClaseDeportiva obtenerClase(String nom) {
		return m.obtenerClase(nom);
	}
	
	public Vector<String> obtenerListaInscripciones(String nom){
		return m.obtenerListaInscripciones(nom);
	}

	//ConsultaClaseDeportiva
	public DtClaseDeportiva ConsultaClaseDeportiva(String nombreActividad) throws ActividadNoExisteException{
		//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad" + nombreActividad + "no existe");
    	//...
	}
	
	//ConsultaInscripciones
	public DtInscripcion ConsultaInscripciones(String nombreClaseDeportiva) throws ClaseNoExisteException{
		//Agrego throw para que no rompa
    	throw new ClaseNoExisteException("La clase" + nombreClaseDeportiva + "no existe");
    	//...
	}
	
	public boolean claseExiste(String nombre){
		return m.claseExiste(nombre);
	}
	
}
