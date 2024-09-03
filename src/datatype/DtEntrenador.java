package datatype;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.Actividad;
import modelo.Deportista;
import modelo.Entrenador;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtEntrenador {

	private int id;
	private String nickname;
	private String nombre;
	private String apellido;
	private String mail;
	private LocalDate fechaNacimiento;
	private String contrasena;
	private String disciplina;
	private String sitioWeb;
	private List<Actividad> actividades;
	
	public static DtEntrenador toDataType(Entrenador e) {
		DtEntrenador ret = new DtEntrenador();
		ret.setId(e.getId());
		ret.setNickname(e.getNickname());
		ret.setNombre(e.getNombre());
		ret.setApellido(e.getApellido());
		ret.setMail(e.getMail());
		ret.setFechaNacimiento(e.getFechaNacimiento());
		ret.setContrasena(e.getContrasena());
		ret.setDisciplina(e.getDisciplina());
		ret.setSitioWeb(e.getSitioWeb());
		ret.setActividades(e.getActividades());
		return ret;
	}
	
	public static Entrenador toObject(DtEntrenador e) {
		Entrenador ret = new Entrenador();
		ret.setId(e.getId());
		ret.setNickname(e.getNickname());
		ret.setNombre(e.getNombre());
		ret.setApellido(e.getApellido());
		ret.setMail(e.getMail());
		ret.setFechaNacimiento(e.getFechaNacimiento());
		ret.setContrasena(e.getContrasena());
		ret.setDisciplina(e.getDisciplina());
		ret.setSitioWeb(e.getSitioWeb());
		ret.setActividades(e.getActividades());
		return ret;
	}

}
