package modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {
	
	@Id
	private int id;
	private LocalDate fechaInscripcion;
	private int cantidadDesportistas;
	private int costo;
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Deportista deportista;
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private ClaseDeportiva claseDeportiva;
}
