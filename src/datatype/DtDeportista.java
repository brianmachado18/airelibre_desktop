package datatype;

import java.time.LocalDate;

public class DtDeportista {

	private String nickname;
	private String nombre;
	private String apellido;
	private String mail;
	private LocalDate fechaNacimineto;
	private String contrasena;
	private boolean tipo;
	private boolean esProfesional;

	public DtDeportista() {
		this.nickname = new String();
		this.nombre = new String();
		this.apellido = new String();
		this.mail = new String();
		this.fechaNacimineto = null;
		this.contrasena = new String();
	}

	public DtDeportista(String nickname, String nombre, String apellido, String mail, LocalDate fechaNacimineto,
			String contrasena, boolean tipo, boolean esProfesional) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.fechaNacimineto = fechaNacimineto;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.esProfesional = esProfesional;
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

	public LocalDate getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(LocalDate fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public boolean isEsProfesional() {
		return esProfesional;
	}

	public void setEsProfesional(boolean esProfesional) {
		this.esProfesional = esProfesional;
	}

}
