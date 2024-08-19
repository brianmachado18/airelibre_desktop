package datatype;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	private LocalDate fechaNacimineto;
	private String contrasena;
	private boolean tipo;
	private boolean esProfesional;
	private List<Inscripcion> inscripciones;

}
