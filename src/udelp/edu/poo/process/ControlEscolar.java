package udelp.edu.poo.process;

import java.util.ArrayList;
import java.util.List;

import udelp.edu.poo.model.Carrera;
import udelp.edu.poo.model.Estudiante;
import udelp.edu.poo.model.Materia;
import udelp.edu.poo.model.MateriaAlumno;
import udelp.edu.poo.model.Profesor;

public class ControlEscolar {

	private List<Carrera>carreras;
	private List<Materia> materias;
	private List<Profesor> profesores;
	private List<Estudiante> estudiantes;
	
	public Carrera existeCarrera (String nombre) {

		if (carreras!=null) {
			for (int i = 0; i < carreras.size(); i++) {
				if (carreras.get(i).getNombre().equals(nombre)) {
					
					return carreras.get(i);
				}
			}
		}
		return null;
	}
	
	public void altaCarrera (Carrera carrera) {
		
		if (null!=carreras) {
			carreras.add(carrera);
		}else {
			carreras=new ArrayList<Carrera>();
			carreras.add(carrera);
		}
		
	}
	
	public void altaMateria (Materia materia) {
		materias.add(materia);
	}
	
	public void altaProfesor (Profesor profesor) {
		profesores.add(profesor);
	}
	
	public void altaEstudiante (Estudiante estudiante){
		estudiantes.add(estudiante);
	}
	
	public boolean asignarMateria (String idProfesor, String idMateria) {
		boolean respuesta=false;
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getId().equals(idMateria)) {
				for (int j = 0; j < profesores.size(); j++) {
					if (profesores.get(j).getId().equals(idProfesor)) {
						profesores.get(j).addMateria(materias.get(i));
						respuesta=true;
					}
				}
			}
		}
		return respuesta;
	}
	
	public boolean asignarCarrera (String idEstudiante, String nombre) {
		boolean respuesta=false;
		for (int i = 0; i < carreras.size(); i++) {
			if (carreras.get(i).getNombre().equals(nombre)) {
				for (int j = 0; j < estudiantes.size(); j++) {
					if (estudiantes.get(j).getId().equals(idEstudiante)) {
						estudiantes.get(j).setCarrera(carreras.get(i));
						materiasAlumno(estudiantes.get(j));
						respuesta=true;
					}
				}
			}
		}
		return respuesta;
	}
	
	public void materiasAlumno (Estudiante estudiante){
		
		List<MateriaAlumno> auxList= new ArrayList<MateriaAlumno>();
		Carrera aux=estudiante.getCarrera();
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getCarrera().equals(aux)) {
				auxList.add((MateriaAlumno) materias.get(i));
			}
		}
		estudiante.setMaterias(auxList);
		
	}
	
	public void calificarMateria (String idEstudiante, String idMateria, Double primerParcial, Double segundoParcial, Double proyecto, Double examenFinal) {
		
		for (int i = 0; i < estudiantes.size(); i++) {
			if (estudiantes.get(i).getId().equals(idEstudiante)) {
				List<MateriaAlumno> aux= estudiantes.get(i).getMaterias();
				for (int j = 0; j < aux.size(); j++) {
					if (aux.get(j).getId().equals(idMateria)) {
				
						aux.get(j).setPrimerParcial(primerParcial);
						aux.get(j).setSegundoParcial(segundoParcial);
						aux.get(j).setProyecto(proyecto);
						aux.get(j).setExamenFinal(examenFinal);
						
						
					}
				}
			}
		}
	}
	
	public void mostrarAlumno (String idEstudiante) {
		
		for (int i = 0; i < estudiantes.size(); i++) {
			if (estudiantes.get(i).getId().equals(idEstudiante)) {
				Estudiante aux=estudiantes.get(i);
				System.out.println("Id: "+aux.getId()+"\tNombre: "+aux.getNombre()+"\tCarrera: "+aux.getSemestre()+
						"\tGeneracion: "+aux.getGeneracion()+"\t");
			}
		}
	}
	
	public Double promedioMateriaEstudiante (String idEstudiante, String idMateria) {
		
		Double promedio = null;
		
		for (int i = 0; i < estudiantes.size(); i++) {
			if (estudiantes.get(i).getId().equals(idEstudiante)) {
				List<MateriaAlumno> aux= estudiantes.get(i).getMaterias();
				for (int j = 0; j < aux.size(); j++) {
					if (aux.get(j).getId().equals(idMateria)) {
						try {
							promedio=(aux.get(j).getPrimerParcial()+aux.get(j).getSegundoParcial()+aux.get(j).getProyecto()+aux.get(j).getExamenFinal())/4;
						}catch(Exception e){
							promedio=null;
						}
						
					}
				}
			}
		}
		
		return promedio;
		
	}
	
	public Double promedioEstudiante(String idEstudiante, Integer semestre) {
	    Double promedioTotal = 0.0;
	    int contadorMaterias = 0;

	    for (int i = 0; i < estudiantes.size(); i++) {
	        if (estudiantes.get(i).getId().equals(idEstudiante)) {
	            List<MateriaAlumno> materias = estudiantes.get(i).getMaterias();
	            for (int j = 0; j < materias.size(); j++) {
	                if (semestre==materias.get(j).getSemestre()) {
	                	try {
		                    MateriaAlumno materia = materias.get(j);
		                    Double promedioMateria = (materia.getPrimerParcial() + materia.getSegundoParcial() + materia.getProyecto() + materia.getExamenFinal()) / 4.0;
		                    promedioTotal += promedioMateria;
		                    contadorMaterias++;
		                } catch (Exception e) {
		                	System.out.println("Faltan datos para realizar la operacion");
		                }
	                }
	            }
	        }
	    }

	    if (contadorMaterias > 0) {
	        return promedioTotal / contadorMaterias;
	    } else {
	        return null; 
	    }
	}

	
	
	
	
}
