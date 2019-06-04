package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class TipoPagoDTO {	
	private int codigo;
	private String nombre;
	
	public TipoPagoDTO() {
		
	}
	
	public TipoPagoDTO(int codigo, String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

}
