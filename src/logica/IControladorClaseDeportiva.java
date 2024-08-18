package logica;

import java.time.*;

import datatype.DtClaseDeportiva;
import datatype.DtInscripcion;
import excepciones.ClaseRepetidoException;
import excepciones.ClaseNoExisteException;
import excepciones.ActividadNoExisteException;

public interface IControladorClaseDeportiva {
	
	/**
     * Registra la Clase Deportiva en el sistema.
     * @throws ClaseRepetidoException Si el nombre de la CalseDeportiva ya se encuentra registrada en el sistema.
     */
	public abstract void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta) throws ClaseRepetidoException;
	
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

}
