package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.StringUtils;


public class ProductoDTO {
	
	private int codigo;
	private String nombre;
	private double valor;
	
	public ProductoDTO(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

}
