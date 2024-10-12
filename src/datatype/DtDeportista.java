package datatype;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.Deportista;
import modelo.Inscripcion;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtDeportista {

	private int id;
	private String nickname;
	private String nombre;
	private String apellido;
	private String mail;
	private LocalDate fechaNacimiento;
	private String contrasena;
	private String imagen;
	private boolean esProfesional;
	private List<Inscripcion> inscripciones;
	
	public static DtDeportista toDataType(Deportista d) {
		DtDeportista ret = new DtDeportista();
		ret.setId(d.getId());
		ret.setNickname(d.getNickname());
		ret.setNombre(d.getNombre());
		ret.setApellido(d.getApellido());
		ret.setMail(d.getMail());
		ret.setFechaNacimiento(d.getFechaNacimiento());
		ret.setContrasena(d.getContrasena());
		ret.setEsProfesional(d.isEsProfesional());
		ret.setInscripciones(d.getInscripciones());
		ret.setImagen(d.getImagen());
		return ret;
	}
	
	public static Deportista toObject(DtDeportista d) {
		Deportista ret = new Deportista();
		ret.setId(d.getId());
		ret.setNickname(d.getNickname());
		ret.setNombre(d.getNombre());
		ret.setApellido(d.getApellido());
		ret.setMail(d.getMail());
		ret.setFechaNacimiento(d.getFechaNacimiento());
		ret.setContrasena(d.getContrasena());
		ret.setEsProfesional(d.isEsProfesional());
		ret.setInscripciones(d.getInscripciones());
		ret.setImagen(d.getImagen());
		return ret;
	}

}
