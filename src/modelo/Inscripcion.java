package modelo;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
