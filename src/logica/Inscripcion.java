package logica;

import java.time.*;

public class Inscripcion {

	private LocalDate fechaInscripcion;
	private int CantidadDesportistas;
	private int costo;
	private String nicknameDeportista;
	public Inscripcion(LocalDate fechaInscripcion, int cantidadDesportistas, int costo, String nicknameDeportista) {

		this.fechaInscripcion = fechaInscripcion;
		CantidadDesportistas = cantidadDesportistas;
		this.costo = costo;
		this.nicknameDeportista = nicknameDeportista;
	}
	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public int getCantidadDesportistas() {
		return CantidadDesportistas;
	}
	public void setCantidadDesportistas(int cantidadDesportistas) {
		CantidadDesportistas = cantidadDesportistas;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public String getNicknameDeportista() {
		return nicknameDeportista;
	}
	public void setNicknameDeportista(String nicknameDeportista) {
		this.nicknameDeportista = nicknameDeportista;
	}
}
