package udelp.edu.poo.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Persona {
	
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private String nombre;
	
	private LocalDate fechaNacimiento;
	
	private String id;
	
	private Character sexo;
	
	private Double peso;
	
	private Double altura;
	
	public Persona() {
		
		this.id=generarID();
		
	}
	
	public Persona(String nombre,String fechaNacimiento, Character sexo) {
	
		this.nombre=nombre;
		this.fechaNacimiento=LocalDate.parse(fechaNacimiento, formato);
		this.sexo=sexo;
		this.id=generarID();
		
	}

	public Persona(String nombre, String fechaNacimiento, Character sexo, Double peso, Double altura) {
		
		this.nombre = nombre;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formato);
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.id=generarID();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	private String generarID() {
		
		String id="";
		Random random = new Random();
		do {
			id+=String.valueOf(random.nextInt(9) + 1);
		}while(id.length()<8);
		return id;
		
	}
	
	
}
