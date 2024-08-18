package modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	@Column(unique = true)
	private String nickname;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	private String mail;
	private LocalDate fechaNacimiento;
	private String contrasena;
	private boolean tipo;
}

