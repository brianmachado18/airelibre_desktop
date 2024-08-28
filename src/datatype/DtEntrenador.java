package datatype;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.Actividad;

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
	private boolean tipo;
	private String disciplina;
	private String sitioWeb;
	private List<Actividad> actividades;

}
