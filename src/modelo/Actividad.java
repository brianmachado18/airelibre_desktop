package modelo;

import java.time.LocalDate;
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
	@JoinColumn(name = "id_entrenador")
	private Entrenador entrenador;
	@OneToMany(mappedBy = "actividad")
	private List<ClaseDeportiva> clasesDeportivas;

}
