package logica;

import java.time.LocalDate;

import datatype.DtActividad;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;

public class ControladorActividad implements IControladorActividad {

    public ControladorActividad() {
    }
    
    //AltaActividad
    public void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img) throws ActividadRepetidaException{
    	//Agrego throw para que no rompa
    	throw new ActividadRepetidaException("La actividad" + nombre + " ya esta registrada");
    	//...
    }
    
    //ListarActividades
    public DtActividad ListarActividades() throws ActividadNoExisteException{
    	//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad no existe");
    	//...
    }
    
    //ConsultaActividad
    public DtActividad ConsultaActividad(String nombre) throws ActividadNoExisteException{
    	//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad no existe");
    	//...
    }
    
    //ModActividades
    public void ModActividades(String desc, int dHoras, int costo, String lugar, String img) throws ActividadNoExisteException{
    	//Agrego throw para que no rompa
    	throw new ActividadNoExisteException("La actividad no existe");
    	//...
    }
    
}