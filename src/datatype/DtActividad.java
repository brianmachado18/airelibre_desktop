package datatype;

import java.time.LocalDate;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.Actividad;
import modelo.ClaseDeportiva;
import modelo.Entrenador;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class DtActividad {

	private int id;
	private String nombre;
	private String descripcion;
	private int duracionHoras;
	private int costo;
	private String lugar;
	private LocalDate fechaAlta;
	private String fechaAltaString;
	private String estado;
	private String imagen;
	private Entrenador entrenador;
	private List<ClaseDeportiva> clasesDeportivas;
	
	public static DtActividad toDataType(Actividad a) {
		DtActividad ret = new DtActividad();
		ret.setId(a.getId());
		ret.setNombre(a.getNombre());
		ret.setDescripcion(a.getDescripcion());
		ret.setDuracionHoras(a.getDuracionHoras());
		ret.setCosto(a.getCosto());
		ret.setLugar(a.getLugar());
		ret.setFechaAlta(a.getFechaAlta());
		ret.setEstado(a.getEstado());
		ret.setImagen(a.getImagen());
		ret.setEntrenador(a.getEntrenador());
		ret.setClasesDeportivas(a.getClasesDeportivas());
		return ret;
	}
	
	public static Actividad toObject(DtActividad a) {
		Actividad ret = new Actividad();
		ret.setId(a.getId());
		ret.setNombre(a.getNombre());
		ret.setDescripcion(a.getDescripcion());
		ret.setDuracionHoras(a.getDuracionHoras());
		ret.setCosto(a.getCosto());
		ret.setLugar(a.getLugar());
		ret.setFechaAlta(a.getFechaAlta());
		ret.setEstado(a.getEstado());
		ret.setImagen(a.getImagen());
		ret.setEntrenador(a.getEntrenador());
		ret.setClasesDeportivas(a.getClasesDeportivas());
		return ret;
	}
	
	public void fechasToString() {
		this.fechaAltaString = this.fechaAlta.toString();
		this.fechaAlta = null;
	}
	
}
