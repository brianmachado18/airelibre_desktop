package datatype;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.Actividad;
import modelo.Inscripcion;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtClaseDeportiva {

	private int id;
	private String nombre;
	private LocalDate fecha;
	private LocalTime hora;
	private String lugar;
	private String imagen;
	private LocalTime fechaAlta;
	private int cupo;
	private Actividad actividad;
	private List<Inscripcion> inscripciones;
}
