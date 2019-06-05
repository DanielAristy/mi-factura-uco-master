package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class TipoIdentificacionDTO {
	private int codigo;
	private String nombre;
	
	public TipoIdentificacionDTO() {
		super();
	}
	
	public TipoIdentificacionDTO(int codigo, String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

}
