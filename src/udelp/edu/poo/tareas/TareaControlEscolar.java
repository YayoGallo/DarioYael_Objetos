package udelp.edu.poo.tareas;

import java.util.Scanner;

import udelp.edu.poo.model.Carrera;
import udelp.edu.poo.model.Estudiante;
import udelp.edu.poo.model.Materia;
import udelp.edu.poo.model.Persona;
import udelp.edu.poo.model.Profesor;
import udelp.edu.poo.process.ControlEscolar;
import udelp.edu.poo.process.Validaciones;

public class TareaControlEscolar {

	public static void main(String[] args) {

		ControlEscolar movimientos = new ControlEscolar();
		Validaciones valida = new Validaciones();
		Scanner leer = new Scanner(System.in);
		boolean repetir = false;
		byte opcion;
		String nombre, auxNombre, horario, fechaNacimiento, fechaIngreso, id, id2;
		Integer semestre;
		Carrera carreraAux;
		Character sexo;
		Double primero, segundo, examen, proyecto, promedio;

		do {
			System.out.println("Control escolar \nMenu\n1)Dar de alta carrera\n"
					+ "2)Dar de alta materia\n3)Dar de alta profesor\n4)Dar de alta alumno\n5)Asignar materia (Profesores)\n"
					+ "6)Asignar carrera a los alumnos\n7)Calificar materia\n8)Datos de alumno\n9)Obtener promedio por materia de alumno"
					+ "\n10)Obtener promedio por alumno\n11)Obtener promedio por semestre\n12)Obtener promedio por materia "
					+ "\n13)Obtener promedio por carrera\n14)Mostrar datos ingresados\n15)Salir");
			opcion = valida.esByte(leer.nextLine());
			switch (opcion) {

			case 1:

				System.out.println("Ingresa el nombre de la carrera");
				nombre = leer.nextLine();
				if (null == movimientos.existeCarrera(nombre)) {
					Carrera carrera = new Carrera();
					carrera.setNombre(nombre);
					movimientos.altaCarrera(carrera);
					System.out.println("Alta exitosa");
				} else {
					System.out.println("Ya existe la carrera");
				}

				repetir = true;
				break;

			case 2:

				System.out.println("Ingresa el nombre de la materia");
				nombre = leer.nextLine();
				System.out.println("Ingresa la carrera");
				auxNombre = leer.nextLine();
				carreraAux = movimientos.existeCarrera(auxNombre);
				if (null != carreraAux) {
					System.out.println("Ingresa el semestre");
					semestre = valida.esInt(leer.nextLine());
					if (semestre > 0 && semestre < 9) {
						System.out.println("Ingresa el horario (Ejemplo: 12:00-13:00)");
						horario = valida.validarHorario(leer.nextLine());
						if (horario != null) {
							Materia materia = new Materia(nombre, semestre, carreraAux, horario);
							movimientos.altaMateria(materia);
							System.out.println("Materia dada de alta");
							repetir = true;
							break;
						}
					}
				}
				System.out.println("Error en los datos ingresados");
				repetir = true;
				break;

			case 3:

				try {
					System.out.println("Ingresa el nombre");
					nombre = leer.nextLine();
					System.out.println("Ingresa la fecha de nacimiento con el formato DD-MM-YYYY");
					fechaNacimiento = leer.nextLine();
					if (valida.validarFecha(fechaNacimiento)) {
						System.out.println("Ingresa la fecha de ingreso con el formato DD-MM-YYYY");
						fechaIngreso = leer.nextLine();
						if (valida.validarFecha(fechaIngreso)) {
							System.out.println("Ingresa el sexo 1)H/Otro)M");
							opcion = valida.esByte(leer.nextLine());
							sexo = opcion == 1 ? 'H' : 'M';
							Profesor profe = new Profesor(nombre, fechaNacimiento, sexo, fechaIngreso);
							movimientos.altaProfesor(profe);
							System.out.println("Ingresado con exito");
						} else {
							System.out.println("Dato invalido, intentalo de nuevo");
						}
					} else {
						System.out.println("Dato invalido, intentalo de nuevo");
					}
				} catch (Exception e) {
					System.out.println("Dato invalido, intentalo de nuevo");
				}
				repetir = true;
				break;

			case 4:

				try {
					System.out.println("Ingresa el nombre");
					nombre = leer.nextLine();
					System.out.println("Ingresa la fecha de nacimiento con el formato DD-MM-YYYY");
					fechaNacimiento = leer.nextLine();
					if (valida.validarFecha(fechaNacimiento)) {
						System.out.println("Ingresa el sexo 1)H/Otro)M");
						opcion = valida.esByte(leer.nextLine());
						sexo = opcion == 1 ? 'H' : 'M';
						Estudiante estudiante = new Estudiante(nombre, fechaNacimiento, sexo);
						movimientos.altaEstudiante(estudiante);
						System.out.println("Ingresado con exito");
					} else {
						System.out.println("Dato invalido, intentalo de nuevo");
					}
				} catch (Exception e) {
					System.out.println("Dato invalido, intentalo de nuevo");
				}
				repetir = true;
				break;

			case 5:

				System.out.println("Ingresa el id del profesor");
				id = leer.nextLine();
				System.out.println("Ingresa el id de la materia");
				id2 = leer.nextLine();
				if (movimientos.asignarMateria(id, id2)) {
					System.out.println("Asignado con exito");
					repetir = true;
					break;
				}
				System.out.println("Sin coincidencias");
				repetir = true;
				break;

			case 6:

				System.out.println("Ingresa el id del alumno");
				id = leer.nextLine();
				System.out.println("Ingresa el nombre de la carrera");
				nombre = leer.nextLine();
				if (movimientos.asignarCarrera(id, nombre)) {
					System.out.println("Asignado con exito");
					repetir = true;
					break;
				}
				System.out.println("Sin coincidencias");
				repetir = true;
				break;

			case 7:
				System.out.println("Ingresa el id del estudiante");
				id = leer.nextLine();
				Estudiante estudianteAux = movimientos.existeEstiudiante(id);
				if (null != estudianteAux) {

					System.out.println("Ingresa el id de la materia");
					id2 = leer.nextLine();
					System.out.println("Ingresa la calificacion de primer parcial (Si se ingresa alguna letra sera 0)");
					primero = valida.esDecimal(leer.nextLine());
					System.out.println("Ingresa la calificacion de segundo parcial");
					segundo = valida.esDecimal(leer.nextLine());
					System.out.println("Ingresa del examen final");
					examen = valida.esDecimal(leer.nextLine());
					System.out.println("Ingresa del proyecto");
					proyecto = valida.esDecimal(leer.nextLine());

					if (movimientos.calificarMateria(estudianteAux, id2, primero, segundo, proyecto, examen)) {

						System.out.println("Guardado con exito");
						repetir = true;
						break;

					}

				}

				System.out.println("No hay coincidencias");
				repetir = true;
				break;

			case 8:

				System.out.println("Ingresa el id del estudiante");
				id = leer.nextLine();
				movimientos.mostrarAlumno(id);
				repetir = true;
				break;

			case 9:

				System.out.println("Ingresa el id del estudiante");
				id = leer.nextLine();
				Estudiante estudianteAux2 = movimientos.existeEstiudiante(id);
				if (null != estudianteAux2) {

					System.out.println("Ingresa el id de la materia");
					id2 = leer.nextLine();
					promedio = movimientos.promedioMateriaEstudiante(estudianteAux2, id2);
					if (null != promedio) {
						System.out.println("Promedio: " + promedio);
						repetir = true;
						break;
					}

				}
				System.out.println("Sin coincidencias");
				repetir = true;
				break;

			case 10:

				System.out.println("Ingresa el id del estudiante");
				id = leer.nextLine();
				Estudiante estudianteAux3 = movimientos.existeEstiudiante(id);
				if (null != estudianteAux3) {

					System.out.println("Ingresa el semestre");
					semestre = valida.esInt(leer.nextLine());
					promedio = movimientos.promedioEstudiante(estudianteAux3, semestre);
					if (null != promedio) {
						System.out.println("Promedio: " + promedio);
						repetir = true;
						break;
					}

				}
				
				System.out.println("Faltan datos");
				repetir = true;
				break;
				
			case 11:
				
				System.out.println("Ingresa el semestre");
				semestre = valida.esInt(leer.nextLine());
				System.out.println("Ingresa el nombre de la carrera");
				nombre=leer.nextLine();
				promedio = movimientos.promedioSemestre(semestre, nombre);
				if (null != promedio) {
					System.out.println("Promedio: " + promedio);
					repetir = true;
					break;
				}
				
				System.out.println("Faltan datos");
				repetir = true;
				break;
				
			case 12:
				
				System.out.println("Ingresa el id de la materia");
				id= leer.nextLine();
				System.out.println("Ingresa el nombre de la carrera");
				nombre=leer.nextLine();
				promedio = movimientos.promedioMateria(nombre, id);
				if (null != promedio) {
					System.out.println("Promedio: " + promedio);
					repetir = true;
					break;
				}
				
				System.out.println("Faltan datos");
				repetir = true;
				break;
				
			case 13:
				
				System.out.println("Ingresa el nombre de la carrera");
				nombre=leer.nextLine();
				promedio = movimientos.promedioCarrera(nombre);
				if (null != promedio) {
					System.out.println("Promedio: " + promedio);
					repetir = true;
					break;
				}
				
				System.out.println("Faltan datos");
				repetir = true;
				break;

			case 14:

				System.out.println("-----------------Carreras-----------------");
				movimientos.imprimirCarreras();
				System.out.println("-----------------Estudiantes-----------------");
				movimientos.imprimirEstudiantes();
				System.out.println("-----------------Materias-----------------");
				movimientos.imprimirMaterias();
				System.out.println("-----------------Profesores-----------------");
				movimientos.imprimirProfesores();

				break;

			case 15:

				System.out.println("Adios");
				repetir = false;
				break;

			default:
				
				System.out.println("Opcion invalida");
				repetir = true;
				break;

			}
		} while (repetir);

	}
}
