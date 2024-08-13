package logica;

import java.time.*;
import java.util.List;

public class ClaseDeportiva {
  
	private LocalDate fecha;
	private LocalTime hora;
	private String lugar;
	private String imagen;
	private LocalTime fechaAlta;
	private int cupo;
	private Actividad actividad;
	private List<Inscripcion> inscripciones;
	
	public ClaseDeportiva(LocalDate fecha, LocalTime hora, String lugar, String imagen, LocalTime fechaAlta, int cupo, Actividad actividad, List<Inscripcion> inscripciones) {

		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.imagen = imagen;
		this.fechaAlta = fechaAlta;
		this.cupo = cupo;
		this.actividad = actividad;
		this.inscripciones = inscripciones;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public LocalTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	
}
