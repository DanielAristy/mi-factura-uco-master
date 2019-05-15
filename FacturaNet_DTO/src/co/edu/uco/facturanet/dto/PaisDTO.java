package co.edu.uco.facturanet.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


//@Data
public class PaisDTO {
	@Getter
	@Setter
	private int codigo;
	@Setter
	private String nombre;

	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

}
