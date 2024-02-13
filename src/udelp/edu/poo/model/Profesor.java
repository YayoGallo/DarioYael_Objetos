package udelp.edu.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {

	private LocalDate fechaDeIngreso;
	private List<Materia> materias;
	
	public Profesor(String nombre,String fechaNacimiento, Character sexo) {
		
		super(nombre, fechaNacimiento, sexo);
		
	}
	
	public Profesor() {
		this.materias =new ArrayList<Materia>();
	}
	
	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	public void addMateria (Materia materia) {
		this.materias.add(materia);
	}


	
	
}
