package udelp.edu.poo.model;

import java.util.Random;

public class Materia {

	private String nombre;
	private Integer semestre;
	private Carrera carrera;
	private String horario;
	private String id;
	
	public Materia(String nombre, Integer semestre, Carrera carrera, String horario) {
		this.nombre = nombre;
		this.semestre = semestre;
		this.carrera = carrera;
		this.horario = horario;
		this.id=generarID();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	private String generarID() {

		String id = "";
		Random random = new Random();
		do {
			id += String.valueOf(random.nextInt(9) + 1);
		} while (id.length() < 3);
		return id;

	}
	
	
}
