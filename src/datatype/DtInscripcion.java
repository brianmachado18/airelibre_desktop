package datatype;

import java.time.LocalDate;

public class DtInscripcion {

	private LocalDate fechaInscripcion;
	private int cantidadDesportistas;
	private int costo;
	private String nicknameDeportista;
	
	public DtInscripcion() {
		this.fechaInscripcion = null;
		this.cantidadDesportistas = 0;
		this.costo = 0;
		this.nicknameDeportista = new String();
	}
	
	public DtInscripcion(LocalDate fechaInscripcion, int cantidadDesportistas, int costo, String nicknameDeportista) {
		this.fechaInscripcion = fechaInscripcion;
		this.cantidadDesportistas = cantidadDesportistas;
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
		return cantidadDesportistas;
	}
	
	public void setCantidadDesportistas(int cantidadDesportistas) {
		this.cantidadDesportistas = cantidadDesportistas;
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
