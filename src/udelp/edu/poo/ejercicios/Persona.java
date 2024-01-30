package udelp.edu.poo.ejercicios;

import java.util.Date;

public class Persona {
	
	private String nombre;
	
	private Date fechaNacimiento;
	
	private Integer id;
	
	private Character sexo;
	
	private Double peso;
	
	private Double altura;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, Date fechaNacimiento, Character sexo) {
		
		this.nombre=nombre;
		this.fechaNacimiento=fechaNacimiento;
		this.sexo=sexo;
	}

	public Persona(String nombre, Date fechaNacimiento, Integer id, Character sexo, Double peso, Double altura) {
		
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.id = id;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", id=" + id + ", sexo=" + sexo
				+ ", peso=" + peso + ", altura=" + altura + "]";
	}
	
	
	
}
