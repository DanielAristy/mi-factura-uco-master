package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class CiudadDTO {
	private int codigo;
	private String nombre;

	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}
}
