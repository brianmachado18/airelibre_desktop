package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador extends Usuario{

	private String disciplina;
	private String sitioWeb;
	@OneToMany(mappedBy = "entrenador")
	private List<Actividad> actividades;
}
