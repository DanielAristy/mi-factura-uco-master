package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class ProductoDTO {
	
	private int codigo;
	private String nombre;
	private double valor;
	
	public ProductoDTO() {
		
	}

	
	public ProductoDTO(int codigo, String nombre, double valor) {
		setCodigo(codigo);
		setNombre(nombre);
		setValor(valor);
	}

	
	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

}
