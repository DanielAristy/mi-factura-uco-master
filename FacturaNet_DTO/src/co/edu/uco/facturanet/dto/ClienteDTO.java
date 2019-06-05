package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class ClienteDTO {
	private int codigo;
	private String identificacion;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String nombre;
	private String telefono;
	private String direccion;
	private String correoElectronico;
	private CiudadDTO ciudadResidencia;
	
	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(int codigo, String identificacion, TipoIdentificacionDTO tipoIdentificacion, String nombre,
			String telefono, String direccion, String correoElectronico, CiudadDTO ciudadResidencia) {
		setCodigo(codigo);
		setIdentificacion(identificacion);
		setTipoIdentificacion(tipoIdentificacion);
		setNombre(nombre);
		setTelefono(telefono);
		setDireccion(direccion);
		setCorreoElectronico(correoElectronico);
		setCiudadResidencia(ciudadResidencia);
	}	
	
	public String getIdentificacion() {
		return StringUtils.defaultString(identificacion);
	}
	
	public TipoIdentificacionDTO getTipoIdentificacion() {
		return ObjectUtils.defaultIfNull(tipoIdentificacion, new TipoIdentificacionDTO());
	}

	public String getNombre() {
		return StringUtils.defaultString(nombre);
	}

	public String getTelefono() {
		return StringUtils.defaultString(telefono);
	}

	public String getDireccion() {
		return StringUtils.defaultString(direccion);
	}

	public String getCorreoElectronico() {
		return StringUtils.defaultString(correoElectronico);
	}

	public CiudadDTO getCiudadResidencia() {
		return ObjectUtils.defaultIfNull(ciudadResidencia, new CiudadDTO());
	}

	
}
