package udelp.edu.poo.model;

import java.util.List;

public class Estudiante extends Persona {
	
	private Integer semestre;
	private String generacion;
	private Carrera carrera;
	
	private List<MateriaAlumno> materias;
	
	public Estudiante(String nombre,String fechaNacimiento, Character sexo) {
		
		super(nombre, fechaNacimiento, sexo);
		
	}
	
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public List<MateriaAlumno> getMaterias() {
		return materias;
	}
	public void setMaterias(List<MateriaAlumno> materias) {
		this.materias = materias;
	}
	public String getGeneracion() {
		return generacion;
	}
	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Estudiante [semestre=" + semestre + ", generacion=" + generacion + ", carrera=" + carrera
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
