package datatype;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.ClaseDeportiva;
import modelo.Entrenador;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtActividad {

	private int id;
	private String nombre;
	private String descripcion;
	private int duracionHoras;
	private int costo;
	private String lugar;
	private LocalDate fechaAlta;
	private String estado;
	private String imagen;
	private Entrenador entrenador;
	private List<ClaseDeportiva> clasesDeportivas;
}
