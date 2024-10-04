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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(nullable = false, unique = true)
	private String nickname;
	private String nombre;
	private String apellido;
    @Column(nullable = false, unique = true)
	private String mail;
	private LocalDate fechaNacimiento;
	private String contrasena;
	private String imagen;
}

