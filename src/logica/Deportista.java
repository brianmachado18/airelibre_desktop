package logica;

import java.time.*;

public class Deportista extends Usuario{
	
	boolean esProfesional;

	public Deportista(String nickname, String nombre, String apellido, String mail, LocalDate fechaNacimiento,
			String contrasena, boolean esProfesional, boolean esAmbos) {
		super(nickname, nombre, apellido, mail, fechaNacimiento, contrasena, esAmbos);
		this.esProfesional = esProfesional;
	}

	public boolean isEsProfesional() {
		return esProfesional;
	}

	public void setEsProfesional(boolean esProfesional) {
		this.esProfesional = esProfesional;
	}
	
	

}
