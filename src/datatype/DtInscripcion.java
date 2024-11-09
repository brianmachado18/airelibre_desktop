package datatype;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modelo.ClaseDeportiva;
import modelo.Deportista;
import modelo.Inscripcion;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtInscripcion {

	private int id;
	private LocalDate fechaInscripcion;
	private String fechaInscripcionString;
	private int cantidadDesportistas;
	private int costo;
	private Deportista deportista;
	private ClaseDeportiva claseDeportiva;
	
	public static DtInscripcion toDataType(Inscripcion i) {
		DtInscripcion ret = new DtInscripcion();
		ret.setId(i.getId());
		ret.setFechaInscripcion(i.getFechaInscripcion());
		ret.setCantidadDesportistas(i.getCantidadDesportistas());
		ret.setCosto(i.getCosto());
		ret.setDeportista(i.getDeportista());
		ret.setClaseDeportiva(i.getClaseDeportiva());
		return ret;
	}
	
	public static Inscripcion toObject(DtInscripcion i) {
		Inscripcion ret = new Inscripcion();
		ret.setId(i.getId());
		ret.setFechaInscripcion(i.getFechaInscripcion());
		ret.setCantidadDesportistas(i.getCantidadDesportistas());
		ret.setCosto(i.getCosto());
		ret.setDeportista(i.getDeportista());
		ret.setClaseDeportiva(i.getClaseDeportiva());
		return ret;
	}
	
	public void fechasToString() {
		this.fechaInscripcionString = this.fechaInscripcion.toString();
		this.fechaInscripcion = null;
	}
	
}
