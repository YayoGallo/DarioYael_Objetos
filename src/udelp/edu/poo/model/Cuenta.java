package udelp.edu.poo.model;

public class Cuenta {
	
	private String titular;
	
	private Double cantidad;
	
	public  Cuenta(String titular, Double cantidad) {
		this.cantidad=cantidad;
		this.titular=titular;
	}
	
	public  Cuenta(String titular) {
		this.titular=titular;
		this.cantidad=0.0;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
	
}
