package logica;

import java.time.LocalDate;
import java.time.LocalTime;

import datatype.DtClaseDeportiva;
import datatype.DtInscripcion;
import excepciones.ActividadNoExisteException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidoException;

public class ControladorClaseDeportiva implements IControladorClaseDeportiva{

	//AltaClaseDeportiva
	public void AltaClaseDeportiva(String nombreClaseDeportiva, LocalDate fecha, LocalTime hora, String lugar, int cupo, LocalDate fAlta) throws ClaseRepetidoException{
		//Agrego throw para que no rompa
		throw new ClaseRepetidoException("La clase" + nombreClaseDeportiva + " ya esta registrada");
		//...
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
	
}
