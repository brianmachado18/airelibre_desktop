package modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actividades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(nullable = false, unique = true)
	private String nombre;
	private String descripcion;
	private int duracionHoras;
	private int costo;
	private String lugar;
	private LocalDate fechaAlta;
	private String estado;
	private String imagen;
	@ManyToOne
	@JoinColumn(name = "id")
	private Entrenador entrenador;
	@OneToMany(mappedBy = "actividad")
	private List<ClaseDeportiva> clasesDeportivas;

}
