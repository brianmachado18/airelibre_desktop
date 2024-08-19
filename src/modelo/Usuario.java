package modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	private int id;
    @Column(nullable = false, unique = true)
	private String nickname;
	private String nombre;
	private String apellido;
    @Column(nullable = false, unique = true)
	private String mail;
	private LocalDate fechaNacimiento;
	private String contrasena;
	private boolean tipo;
}

