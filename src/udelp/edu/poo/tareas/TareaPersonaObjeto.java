package udelp.edu.poo.tareas;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import udelp.edu.poo.ejercicios.Persona;
import udelp.edu.poo.model.MovimientosPersona;

public class TareaPersonaObjeto {

	public static void main(String[] args) throws Exception {
		boolean termino = false;
		byte opcion;
		Scanner leer = new Scanner(System.in);
		List<Persona> personas = new LinkedList<Persona>();
		String nombre = "", fechaNacimiento = "";
		char sexo = 0;
		double peso, altura;
		MovimientosPersona movimientos = new MovimientosPersona();

		do {

			System.out.println(
					"Menu Personas\n1)Agregar persona\n2)Ver personas\n3)Ver edad de personas\n4)Ver quien es mayor de edad\n5)Ver IMC\n6)Salir\nElige una opcion");
			opcion = Byte.parseByte(leer.nextLine());

			switch (opcion) {

			case 1:

				if (null == personas || personas.size() < 10) {

					System.out.println(
							"1)Agregar sin datos\n2)Agregar con nombre, fecha de nacimiento y sexo\n3)Agregar con todos los datos\nCualquier otro)Cancelar\nElige una opcion");
					opcion = Byte.parseByte(leer.nextLine());

					switch (opcion) {

					case 1:

						Persona persona = new Persona();
						personas.add(persona);

						break;

					case 2:
						System.out.println("Ingresa el nombre");
						nombre = leer.nextLine();
						System.out.println("Ingresa la fecha de nacimiento con el formato YYYY-MM-DD");
						fechaNacimiento = leer.nextLine();
						System.out.println("Ingresa el sexo 1)H/Otro)M");
						opcion = Byte.parseByte(leer.nextLine());
						sexo = opcion == 1 ? 'H' : 'M';
						Persona persona1 = new Persona(nombre, fechaNacimiento, sexo);
						personas.add(persona1);
						break;

					case 3:

						System.out.println("Ingresa el nombre");
						nombre = leer.nextLine();
						System.out.println("Ingresa la fecha de nacimiento con el formato YYYY-MM-DD");
						fechaNacimiento = leer.nextLine();
						System.out.println("Ingresa el sexo 1)H/Otro)M");
						opcion = Byte.parseByte(leer.nextLine());
						sexo = opcion == 1 ? 'H' : 'M';
						System.out.println("Ingresa el peso");
						peso = Double.parseDouble(leer.nextLine());
						System.out.println("Ingresa la estatura");
						altura = Double.parseDouble(leer.nextLine());
						Persona persona2 = new Persona(nombre, fechaNacimiento, sexo, peso, altura);
						personas.add(persona2);
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
						try {
							System.out.println(personas.get(i) + "\n");
						} catch (Exception e) {
							System.out.println("Error al mostrar persona: " + e.getMessage());
						}
					}
				}
				break;

			case 3:
				if (null != personas) {
					for (int i = 0; i < personas.size(); i++) {
						try {
							System.out.println(movimientos.calcularEdad(personas.get(i)) + "\n");
						} catch (Exception e) {
							System.out.println("Error al calcular edad: " + e.getMessage());
						}
					}
				}
				break;

			case 4:
				if (null != personas) {
					for (int i = 0; i < personas.size(); i++) {
						try {
							System.out.println(movimientos.esMayorDeEdad(personas.get(i)) + "\n");
						} catch (Exception e) {
							System.out.println("Error al verificar si es mayor de edad: " + e.getMessage());
						}
					}
				}
				break;

			case 5:
				if (null != personas) {
					for (int i = 0; i < personas.size(); i++) {
						try {
							System.out.println(movimientos.calcularIMC(personas.get(i)) + "\n");
						} catch (Exception e) {
							System.out.println("Error al calcular IMC: " + e.getMessage());
						}
					}
				}
				break;

			case 6:

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
