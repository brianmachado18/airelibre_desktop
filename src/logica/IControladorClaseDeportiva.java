package logica;

import java.time.*;
import java.util.Vector;

import datatype.DtActividad;
import datatype.DtClaseDeportiva;
import excepciones.PersistenciaException;

public interface IControladorClaseDeportiva {
	
	public abstract DtClaseDeportiva obtenerClase(String nom);
	
	public abstract Vector<String> obtenerListaInscripciones(String nom);
	
	public abstract boolean claseExiste(String nombre);
	
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, DtActividad Act) throws PersistenciaException;
	
}
