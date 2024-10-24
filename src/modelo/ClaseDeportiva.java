package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
public class ClaseDeportiva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(nullable = false, unique = true)
	private String nombre;
	private LocalDate fecha;
	private LocalTime hora;
	private String lugar;
	private String imagen;
	private LocalDate fechaAlta;
	private int cupo;
	@ManyToOne
	@JoinColumn(name = "id_actividad")
	private Actividad actividad;
	@OneToMany(mappedBy = "claseDeportiva")
	private List<Inscripcion> inscripciones;

}
