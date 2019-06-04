package co.edu.uco.facturanet.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import lombok.Data;

@Data
public class FacturaDTO {
	
	private int codigo;
	private ClienteDTO cliente;
	private ClienteDTO empleado;
	private Date fecha;
	private TipoPagoDTO tipopago;
	private double valor;
	private List<DetalleFacturaDTO> listaProductos;
	
	public FacturaDTO() {
		setCliente(null);
		setEmpleado(null);
		setTipopago(null);
		setListaProductos(null);
	}
	
	public FacturaDTO(int codigo, ClienteDTO cliente, ClienteDTO empleado, Date fecha, TipoPagoDTO tipopago,
			double valor, List<DetalleFacturaDTO> listaProductos) {
		setCodigo(codigo);
		setCliente(cliente);
		setEmpleado(empleado);
		setFecha(fecha);
		setTipopago(tipopago);
		setValor(valor);
		setListaProductos(listaProductos);
	}
	
	public ClienteDTO getCliente() {
		return ObjectUtils.defaultIfNull(cliente, new ClienteDTO());
	}
	public ClienteDTO getEmpleado() {
		return ObjectUtils.defaultIfNull(empleado, new ClienteDTO());
	}
	public TipoPagoDTO getTipopago() {
		return ObjectUtils.defaultIfNull(tipopago, new TipoPagoDTO());
	}
	public Date getfecha() {
		return ObjectUtils.defaultIfNull(fecha, new Date());
	}
	public List<DetalleFacturaDTO> getListaProductos() {
		return ObjectUtils.defaultIfNull(listaProductos, new ArrayList<DetalleFacturaDTO>());
	}
	
	
}
