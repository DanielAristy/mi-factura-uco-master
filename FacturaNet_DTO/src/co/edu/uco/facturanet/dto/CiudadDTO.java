package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class CiudadDTO {
	private int codigo;
	private String nombre;
	private DepartamentoDTO departamento;
	
	public CiudadDTO() {
		setDepartamento(null);
	}
	
	public CiudadDTO(int codigo, String nombre, DepartamentoDTO departamento) {
		setCodigo(codigo);
		setNombre(nombre);
		setDepartamento(departamento);
		
	}

	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}
	
	public DepartamentoDTO setDepartamento() {
		return ObjectUtils.defaultIfNull(departamento, new DepartamentoDTO());
	}
	
}
