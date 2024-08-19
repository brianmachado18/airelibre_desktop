package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaseDeportiva {
	
	@Id
	private int id;
    @Column(nullable = false, unique = true)
	private String nombre;
	private LocalDate fecha;
	private LocalTime hora;
	private String lugar;
	private String imagen;
	private LocalTime fechaAlta;
	private int cupo;
	@ManyToOne
	@JoinColumn(name = "id")
	private Actividad actividad;
	@OneToMany(mappedBy = "claseDeportiva")
	private List<Inscripcion> inscripciones;

}
