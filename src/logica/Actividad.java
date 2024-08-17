package logica;

import java.time.LocalDate;
import java.util.List;

public class Actividad {

	private String nombre;
	private String descripcion;
	private int duracionHoras;
	private int costo;
	private String lugar;
	private LocalDate fechaAlta;
	private String estado;
	private String imagen;
	private Entrenador entrenador;
	private List<ClaseDeportiva> clasesDeportivas;

	public Actividad(String nombre, String descripcion, int duracionHoras, int costo, String lugar, LocalDate fechaAlta,
			String estado, String imagen, Entrenador entrenador, List<ClaseDeportiva> clasesDeportivas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionHoras = duracionHoras;
		this.costo = costo;
		this.lugar = lugar;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		this.imagen = imagen;
		this.entrenador = entrenador;
		this.clasesDeportivas = clasesDeportivas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<ClaseDeportiva> getClasesDeportivas() {
		return clasesDeportivas;
	}

	public void setClasesDeportivas(List<ClaseDeportiva> clasesDeportivas) {
		this.clasesDeportivas = clasesDeportivas;
	}

}
