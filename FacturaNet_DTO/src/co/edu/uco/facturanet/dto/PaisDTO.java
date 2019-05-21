package co.edu.uco.facturanet.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


@Data
public class PaisDTO {
	private int codigo;
	private String nombre;

	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

}
