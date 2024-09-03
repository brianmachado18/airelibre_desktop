package logica;

import java.time.*;
import java.util.Vector;

import excepciones.ClaseRepetidoException;
import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.ClaseDeportiva;

public interface IControladorClaseDeportiva {
	
	public abstract ClaseDeportiva obtenerClase(String nom); //DtClaseDeportiva
	
	public abstract Vector<String> obtenerListaInscripciones(String nom);
	
	public abstract boolean claseExiste(String nombre);
	
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, Actividad Act) throws ClaseRepetidoException, PersistenciaException;
	
}
