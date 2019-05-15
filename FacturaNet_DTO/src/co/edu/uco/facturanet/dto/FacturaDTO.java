package co.edu.uco.facturanet.dto;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.ObjectUtils;
import lombok.Data;

@Data
public class FacturaDTO {
	
	private int codigo;
	private ClienteDTO cliente;
	private ClienteDTO empleado;
	private Date fecha;
	private TipoIdentificacionDTO tipopago;
	private double valor;
	
	
	public ClienteDTO getCliente() {
		return ObjectUtils.defaultIfNull(cliente, new ClienteDTO());
	}
	public ClienteDTO getEmpleado() {
		return ObjectUtils.defaultIfNull(empleado, new ClienteDTO());
	}
	public TipoIdentificacionDTO getTipopago() {
		return ObjectUtils.defaultIfNull(tipopago, new TipoIdentificacionDTO());
	}
	public Date getfecha() {
		return ObjectUtils.defaultIfNull(fecha, new Date());
	}
	
}
