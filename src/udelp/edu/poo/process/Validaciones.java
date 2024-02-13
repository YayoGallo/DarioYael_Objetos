package udelp.edu.poo.process;

import java.time.LocalDate;

public class Validaciones {
	public boolean validarFecha(String fecha) {
		boolean esFecha = false;
		String añoCadena;
		String[] cadena;
		int año;
		if (fecha != null & fecha.length() == 10 & fecha.charAt(2) == '-' & fecha.charAt(5) == '-') {
			cadena = fecha.split("-");
			añoCadena = cadena[2];
			año = validaAño(añoCadena);
			if (año != -1) {
				esFecha = true;
			}
		}
		return esFecha;
	}

	public int validaAño(String año) {
		int esValido;
		try {
			if (Integer.valueOf(año) >= 1900 & Integer.valueOf(año) <= LocalDate.now().getYear()) {
				esValido = Integer.valueOf(año);
			} else {
				esValido = -1;
			}
		} catch (NumberFormatException ex) {
			esValido = -1;
		}
		return esValido;
	}

	public byte esByte(String numero) {

		byte respuesta;
		try {
			respuesta = Byte.parseByte(numero);
		} catch (Exception e) {
			respuesta = -1;
		}
		return respuesta;
	}
	
    public Double validarPeso(String peso) {
        try {
            double aux = Double.parseDouble(peso);
            return (aux > 0) ? aux : null; 
        } catch (Exception e) {
            return null;
        }
    }

    public Double validarEstatura(String estatura) {
        try {
            double aux = Double.parseDouble(estatura);
            return (aux > 0 && aux <= 3) ? aux : null; 
        } catch (Exception e) {
            return null;
        }
    }

    public Integer esInt (String numero) {
    	
    	int respuesta;
		try {
			respuesta = Integer.parseInt(numero);
		} catch (Exception e) {
			respuesta = -1;
		}
		return respuesta;
    	
    }
    
    public String esHorario (String horario) {
		return horario;
    	
    }

}
