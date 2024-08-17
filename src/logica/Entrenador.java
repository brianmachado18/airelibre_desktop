package logica;

import java.time.LocalDate;

public class Entrenador extends Usuario{

	private String disciplina;
	private String sitioWeb;

	public Entrenador(String nickname, String nombre, String apellido, String mail, LocalDate fechaNacimiento, String contrasena, String disciplina, String sitioWeb, boolean esAmbos) {
		super(nickname, nombre, apellido, mail, fechaNacimiento, contrasena, esAmbos);
		this.disciplina = disciplina;
		this.sitioWeb = sitioWeb;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

}
