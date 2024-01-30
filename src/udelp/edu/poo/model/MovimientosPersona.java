package udelp.edu.poo.model;

import udelp.edu.poo.ejercicios.Persona;

public class MovimientosPersona {

	public byte calcularIMC(Persona persona) throws Exception {
		if(null== persona.getPeso()||null==persona.getAltura()) {
			throw new Exception("No se puede calcular el peso"); 
		}
		 Double imc = persona.getPeso()/ Math.pow(persona.getAltura(), 2);
		 if (imc>25) {
			 return 1;
		 }
		 return 0;
	}
	
}
