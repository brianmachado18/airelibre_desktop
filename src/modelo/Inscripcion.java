package modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
