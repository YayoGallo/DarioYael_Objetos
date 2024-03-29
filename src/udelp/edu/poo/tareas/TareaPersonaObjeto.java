package udelp.edu.poo.tareas;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import udelp.edu.poo.model.Persona;
import udelp.edu.poo.process.MovimientosPersona;
import udelp.edu.poo.process.Validaciones;

public class TareaPersonaObjeto {

	public static void main(String[] args) throws Exception {
		boolean termino = false, encontrada = false;
		byte opcion;
		Scanner leer = new Scanner(System.in);
		List<Persona> personas = new LinkedList<Persona>();
		String nombre = "", fechaNacimiento = "", id = "", auxIMC = "", auxMayor = "";
		char sexo = 0;
		double peso, altura;
		MovimientosPersona movimientos = new MovimientosPersona();
		Validaciones valida = new Validaciones();

		do {

			System.out.println(
					"Menu Personas\n1)Agregar persona\n2)Ver personas\n3)Buscar persona(Obtener IMC/Edad/Si es mayor de edad)\n4)Salir\nElige una opcion");
			opcion = valida.esByte(leer.nextLine());

			switch (opcion) {

			case 1:

				if (null == personas || personas.size() < 10) {

					System.out.println(
							"1)Agregar sin datos\n2)Agregar con nombre, fecha de nacimiento y sexo\n3)Agregar con todos los datos\nCualquier otro)Cancelar\nElige una opcion");
					opcion = valida.esByte(leer.nextLine());

					switch (opcion) {

					case 1:

						Persona persona = new Persona();
						personas.add(persona);

						break;

					case 2:
						try {
							System.out.println("Ingresa el nombre");
							nombre = leer.nextLine();
							System.out.println("Ingresa la fecha de nacimiento con el formato DD-MM-YYYY");
							fechaNacimiento = leer.nextLine();
							if (valida.validarFecha(fechaNacimiento)) {
								System.out.println("Ingresa el sexo 1)H/Otro)M");
								opcion = valida.esByte(leer.nextLine());
								sexo = opcion == 1 ? 'H' : 'M';
								Persona persona1 = new Persona(nombre, fechaNacimiento, sexo);
								personas.add(persona1);
							}else {
								System.out.println("Dato invalido, intentalo de nuevo");
							}
						} catch (Exception e) {
							System.out.println("Dato invalido, intentalo de nuevo");
						}
						break;

					case 3:
						try {
							System.out.println("Ingresa el nombre");
							nombre = leer.nextLine();
							System.out.println("Ingresa la fecha de nacimiento con el formato DD-MM-YYYY");
							fechaNacimiento = leer.nextLine();
							if (valida.validarFecha(fechaNacimiento)) {
								System.out.println("Ingresa el sexo 1)H/Otro)M");
								opcion = valida.esByte(leer.nextLine());
								sexo = opcion == 1 ? 'H' : 'M';
								System.out.println("Ingresa el peso");
								peso = valida.validarPeso(leer.nextLine());
								System.out.println("Ingresa la estatura");
								altura = valida.validarEstatura(leer.nextLine());
								Persona persona2 = new Persona(nombre, fechaNacimiento, sexo, peso, altura);
								personas.add(persona2);
							}else {
								System.out.println("Dato invalido, intentalo de nuevo");
							}

						} catch (Exception e) {
							System.out.println("Dato invalido, intentalo de nuevo");
						}
						break;

					default:
						break;
					}

					termino = false;
					break;
				}
				System.out.println("Arreglo lleno");
				break;

			case 2:

				if (personas != null) {
					for (int i = 0; i < personas.size(); i++) {
						System.out.println(personas.get(i) + "\n");
					}
				}
				break;

			case 3:

				System.out.println("Ingresa el ID de la persona");
				id = leer.nextLine();
				for (int i = 0; i < personas.size(); i++) {
					if (personas.get(i).getId().equals(id)) {
						try {
							Persona aux = personas.get(i);
							auxIMC = movimientos.calcularIMC(aux) == 1 ? "Sobrepeso"
									: (movimientos.calcularIMC(aux) == 0 ? "Peso ideal" : "Por debajo del peso ideal");
							System.out.println(aux + ", Edad:" + movimientos.calcularEdad(aux) + " ,IMC:" + auxIMC
									+ ", Es mayor:" + movimientos.esMayorDeEdad(aux));
						} catch (Exception e) {
							System.out.println("Faltan datos para completar el proceso");
						}
						encontrada=true;
						break;
					}else {
						encontrada= false;
					}
				}
				if(!encontrada) {
					
					System.out.println("No se encontraron personas con el id:" + id);
					
				}
				break;

			case 4:

				termino = true;
				break;

			default:

				System.out.println("Opcion invalida");
				termino = false;
				break;

			}

		} while (!termino);
	}
}
