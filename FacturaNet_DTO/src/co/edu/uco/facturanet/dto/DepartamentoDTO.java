package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;


@Data
public class DepartamentoDTO {
	private int codigo;
	private String nombre;
	private PaisDTO pais;
	
	public DepartamentoDTO() {
		super();
	}
	
	public DepartamentoDTO(int codigo, String nombre, PaisDTO pais) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setPais(pais);
		
	}
	
	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}
	
	public PaisDTO getPais() {
		return ObjectUtils.defaultIfNull(pais, new PaisDTO());
	}

}
