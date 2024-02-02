package udelp.edu.poo.process;

import java.time.LocalDate;

import udelp.edu.poo.model.Persona;

public class MovimientosPersona {

	public byte calcularIMC(Persona persona) throws Exception {

		if (null == persona.getPeso() || null == persona.getAltura()) {
			throw new Exception("No se puede calcular el peso");
		}

		Double imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);
		
		if (imc < 20) {
			return -1; // Por debajo del peso ideal
		} else if (imc >= 20 && imc <= 25) {
			return 0; // En peso ideal
		}
		
		return 1; // Con sobrepeso
	}

	public int calcularEdad(Persona persona) throws Exception {

		if (null == persona.getFechaNacimiento()) {
			throw new Exception("No puede calcularse la edad");
		}

		LocalDate fechaActual = LocalDate.now();

		int edad = fechaActual.getYear() - persona.getFechaNacimiento().getYear();

		if (fechaActual.isBefore(persona.getFechaNacimiento().plusYears(edad))) {
			edad--;
		}
		return edad;
	}
	
	public boolean esMayorDeEdad(Persona persona) throws Exception{
		
		if (null == persona.getFechaNacimiento()) {
			throw new Exception("No puede calcularse la edad");
		}
		
		boolean respuesta=false;
		
		if (calcularEdad(persona)>18) {
			respuesta=true;
		}
		
		return respuesta;
		
	}
	
	

}
