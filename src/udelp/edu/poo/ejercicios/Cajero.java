package udelp.edu.poo.ejercicios;

import udelp.edu.poo.model.Cuenta;
import udelp.edu.poo.process.IngresoRetiro;

public class Cajero {

	public static void main(String[] args) throws Exception {

		IngresoRetiro inRet = new IngresoRetiro();

		Cuenta c1 = new Cuenta();
		
		c1.setTitular("Luis Ochoa");
		System.out.println(c1);
		c1 = inRet.ingresar(c1, 10D);
		System.out.println(c1);

		c1 = new Cuenta("Alberto Gracia");

		System.out.println(c1);
		c1 = inRet.ingresar(c1, 10D);
		System.out.println(c1);
		c1 = inRet.retirar(c1, 5D);
		System.out.println(c1);

	}

}
