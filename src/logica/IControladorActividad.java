package logica;

import java.time.LocalDate;
import java.util.Vector;

import datatype.DtActividad;
import excepciones.ActividadNoExisteException;
import modelo.Actividad;
import modelo.Entrenador;

public interface IControladorActividad {

    /**
     * Registra la actividad en el sistema.
     * @throws ActividadRepetidoException Si el nombre de la Actividad ya se encuentra registrada en el sistema.
     */
    
	public abstract boolean actividadExiste(String nombre);
	
	public abstract void AltaActividad(String nombre, String desc, int dHoras, int costo, String lugar, LocalDate fAlta, String img,  Entrenador ent);
	
	public abstract Vector<String> obtenerVectorActividad();
	
	public abstract Actividad obtenerActividad(String nom);

    /**
     * Retorna la informacion de todas las Actividades.
     * @throws ActividadNoExisteException Si no hay ninguna Actividad registrada en el sistema.
     */
    public abstract DtActividad ListarActividades() throws ActividadNoExisteException;

    /**
     * Retorna la informacion de la Actividads especificada con nombre.
     * @throws ActividadNoExisteException Si el nombre de la Actividad no se encuentra registrada en el sistema.
     */
    public abstract DtActividad ConsultaActividad(String nombre) throws ActividadNoExisteException;

    /**
     * Retorna la informacion de la actividad especificado y permite modificar sus datos.
     * @throws ActividadNoExisteException Si no hay ninguna Actividad con dicho nombre en el sistema.
     */
    public abstract void ModActividades(String desc, int dHoras, int costo, String lugar, String img) throws ActividadNoExisteException;

}
