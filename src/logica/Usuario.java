package logica;

import java.time.LocalDate;

public class Usuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String mail;
	private LocalDate fechaNacimiento;
	private String contrasena;
	private boolean tipo;

	public Usuario(String nickname, String nombre, String apellido, String mail, LocalDate fechaNacimiento, String contrasena, boolean esAmbos) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.tipo = esAmbos;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isEsAmbos() {
		return tipo;
	}

	public void setEsAmbos(boolean esAmbos) {
		this.tipo = esAmbos;
	}

}

