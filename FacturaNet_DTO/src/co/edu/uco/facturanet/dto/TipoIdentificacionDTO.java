package co.edu.uco.facturanet.dto;

import lombok.Data;

@Data
public class TipoIdentificacionDTO {
	private int codigo;
	private String nombre;
	
	public TipoIdentificacionDTO() {
		
	}
	
	public TipoIdentificacionDTO(int codigo, String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}

}
