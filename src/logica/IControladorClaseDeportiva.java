package logica;

import java.time.*;
import java.util.Vector;

import datatype.DtClaseDeportiva;
import datatype.DtInscripcion;
import excepciones.ClaseRepetidoException;
import excepciones.PersistenciaException;
import modelo.Actividad;
import modelo.ClaseDeportiva;
import modelo.Inscripcion;
import excepciones.ClaseNoExisteException;
import excepciones.ActividadNoExisteException;

public interface IControladorClaseDeportiva {
	
	public abstract ClaseDeportiva obtenerClase(String nom);
	
	public abstract Vector<String> obtenerListaInscripciones(String nom);
	
	public abstract boolean DeportistaEstaEnClase(String nombreDep,String NombreCla);
	/**
     * Registra la Clase Deportiva en el sistema.
     * @throws ClaseRepetidoException Si el nombre de la CalseDeportiva ya se encuentra registrada en el sistema.
	 * @throws PersistenciaException 
     */
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, Actividad Act) throws ClaseRepetidoException, PersistenciaException;	
	/**
     * Lista las Clases Deportivas asociadas a una Actividad en el sistema.
     * @throws ActividadNoExisteException Si el nombre de la Actividad no se encuentra registrada en el sistema.
     */
	public abstract DtClaseDeportiva ConsultaClaseDeportiva(String nombreActividad) throws ActividadNoExisteException;
	
	/**
     * Lista las Inscripciones a una Clases Deportivas asociadas a una Actividad en el sistema.
     * @throws ClaseNoExisteException Si el nombre de la Clase Deportiva no se encuentra registrada en el sistema.
     */
	public abstract DtInscripcion ConsultaInscripciones(String nombreClaseDeportiva) throws ClaseNoExisteException;
	
	public abstract  void AltainscripcionAClase(String nomClase, String NomDeportista,int CantidadDesportistas,LocalDate FechaInscripcion) throws ClaseNoExisteException;

	
	public abstract boolean claseExiste(String nombre);
	
	public abstract int CuposDisponiblesEnClase(String nombre);
}
