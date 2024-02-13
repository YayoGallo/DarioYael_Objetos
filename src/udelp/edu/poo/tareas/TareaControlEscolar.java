package udelp.edu.poo.tareas;

import java.util.Scanner;

import udelp.edu.poo.model.Carrera;
import udelp.edu.poo.process.ControlEscolar;
import udelp.edu.poo.process.Validaciones;

public class TareaControlEscolar {

	public static void main(String[] args) {
		
		ControlEscolar movimientos=new ControlEscolar();
		Validaciones valida=new Validaciones();
		Scanner leer=new Scanner(System.in);
		boolean repetir = false;
		byte opcion;
		String nombre,auxNombre;
		Integer semestre;
		
		do {
			System.out.println("Control escolar \nMenu\n1)Dar de alta carrera\n"
					+ "2)Dar de alta materia\n3)Dar de alta profesor\n4)Dar de alta alumno\n5)Asignar materia (Profesores)\n"
					+ "6)Asignar carrera a los alumnos\n7)Calificar materia\n8)Datos de alumno\n9)Obtener promedio por materia de alumno"
					+ "\n10)Obtener promedio por alumno\n11)Obtener promedio por semestre\n12)Obtener promedio por materia "
					+ "\n13)Obtener promedio por carrera\n14)Salir");
			opcion = valida.esByte(leer.nextLine());
			switch (opcion) {
			
			case 1:
				
				System.out.println("Ingresa el nombre de la carrera");
				nombre=leer.nextLine();
				if (null==movimientos.existeCarrera(nombre)) {
					Carrera carrera=new Carrera();
					carrera.setNombre(nombre);
					movimientos.altaCarrera(carrera);
					System.out.println("Alta exitosa");
				}else {
					System.out.println("Ya existe la carrera");
				}
				
				repetir=true;
				break;
			
			case 2:
				
				System.out.println("Ingresa el nombre de la materia");
				nombre=leer.nextLine();
				System.out.println("Ingresa la carrera");
				auxNombre=leer.nextLine();
				if (null!=movimientos.existeCarrera(auxNombre)) {
					System.out.println("Ingresa el semestre");
					semestre=valida.esInt(leer.nextLine());
					if(semestre>0&&semestre<8) {
						System.out.println("Ingresa el horario");
					}
				}
			
			}
		}while(repetir);
		
		
	}
}
