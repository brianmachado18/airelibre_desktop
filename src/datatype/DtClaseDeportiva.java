package datatype;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.Actividad;
import modelo.ClaseDeportiva;
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
	private LocalDate fechaAlta;
	private int cupo;
	private Actividad actividad;
	private List<Inscripcion> inscripciones;
	
	public static DtClaseDeportiva toDataType(ClaseDeportiva c) {
		DtClaseDeportiva ret = new DtClaseDeportiva();
		ret.setId(c.getId());
		ret.setNombre(c.getNombre());
		ret.setFecha(c.getFecha());
		ret.setHora(c.getHora());
		ret.setLugar(c.getLugar());
		ret.setImagen(c.getImagen());
		ret.setFechaAlta(c.getFechaAlta());
		ret.setCupo(c.getCupo());
		ret.setActividad(c.getActividad());
		ret.setInscripciones(c.getInscripciones());
		return ret;
	}
	
	public static ClaseDeportiva toObject(DtClaseDeportiva c) {
		ClaseDeportiva ret = new ClaseDeportiva();
		ret.setId(c.getId());
		ret.setNombre(c.getNombre());
		ret.setFecha(c.getFecha());
		ret.setHora(c.getHora());
		ret.setLugar(c.getLugar());
		ret.setImagen(c.getImagen());
		ret.setFechaAlta(c.getFechaAlta());
		ret.setCupo(c.getCupo());
		ret.setActividad(c.getActividad());
		ret.setInscripciones(c.getInscripciones());
		return ret;
	}
	
}
