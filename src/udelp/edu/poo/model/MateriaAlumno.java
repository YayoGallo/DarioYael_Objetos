package udelp.edu.poo.model;

public class MateriaAlumno extends Materia {

	private Double primerParcial;
	private Double segundoParcial;
	private Double proyecto;
	private Double examenFinal;

	public MateriaAlumno(String nombre, Integer semestre, Carrera carrera, String horario) {
		super(nombre, semestre, carrera, horario);
	}

	public Double getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(Double primerParcial) {
		this.primerParcial = primerParcial;
	}

	public Double getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(Double segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public Double getProyecto() {
		return proyecto;
	}

	public void setProyecto(Double proyecto) {
		this.proyecto = proyecto;
	}

	public Double getExamenFinal() {
		return examenFinal;
	}

	public void setExamenFinal(Double examenFinal) {
		this.examenFinal = examenFinal;
	}

	

}
