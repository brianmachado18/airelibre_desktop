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
	
	public abstract boolean DeportistaEstaEnClase(String nombreDep,String NombreCla);
	/**
     * Registra la Clase Deportiva en el sistema.
     * @throws ClaseRepetidoException Si el nombre de la CalseDeportiva ya se encuentra registrada en el sistema.
	 * @throws PersistenciaException 
     */
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, DtActividad Act) throws PersistenciaException;
	
	public abstract void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta, DtActividad Act) throws ClaseRepetidoException, PersistenciaException;	
	/**
     * Lista las Clases Deportivas asociadas a una Actividad en el sistema.
     * @throws ActividadNoExisteException Si el nombre de la Actividad no se encuentra registrada en el sistema.
     */
	
	public abstract  void AltainscripcionAClase(String nomClase, String NomDeportista,int CantidadDesportistas,LocalDate FechaInscripcion) throws ClaseNoExisteException;
	
	public abstract int CuposDisponiblesEnClase(String nombre);
}
