package modelo;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate fechaInscripcion;
	private int cantidadDesportistas;
	private int costo;
	@OneToOne
	@JoinColumn(name = "id_deportista")
	private Deportista deportista;
	@OneToOne
	@JoinColumn(name = "id_ClaseDeportiva")
	private ClaseDeportiva claseDeportiva;
}
