package modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deportista extends Usuario{

	boolean esProfesional;
	@OneToMany(mappedBy = "deportista")
	private List<Inscripcion> inscripciones;
	
	
}
