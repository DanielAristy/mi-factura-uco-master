package co.edu.uco.facturanet.dto;

import java.util.ArrayList;
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
	private TipoPagoDTO tipoPago;
	private double valor;
	private List<DetalleFacturaDTO> listaProductos;

	public FacturaDTO() {
		super();
	}

	public FacturaDTO(int codigo, ClienteDTO cliente, ClienteDTO empleado, Date fecha, TipoPagoDTO tipopago,
			double valor) {
		setCodigo(codigo);
		setCliente(cliente);
		setEmpleado(empleado);
		setFecha(fecha);
		setTipoPago(tipopago);
		setValor(valor);
	}

	public FacturaDTO(int codigo, ClienteDTO cliente, ClienteDTO empleado, Date fecha, TipoPagoDTO tipopago,
			List<DetalleFacturaDTO> listaProductos, double valor) {
		setCodigo(codigo);
		setCliente(cliente);
		setEmpleado(empleado);
		setFecha(fecha);
		setTipoPago(tipopago);
		setValor(valor);
		setListaProductos(listaProductos);
	}

	public ClienteDTO getCliente() {
		return ObjectUtils.defaultIfNull(cliente, new ClienteDTO());
	}

	public ClienteDTO getEmpleado() {
		return ObjectUtils.defaultIfNull(empleado, new ClienteDTO());
	}

	public TipoPagoDTO getTipoPago() {
		return ObjectUtils.defaultIfNull(tipoPago, new TipoPagoDTO());
	}

	public Date getFecha() {
		return ObjectUtils.defaultIfNull(fecha, new Date());
	}

	public List<DetalleFacturaDTO> getListaProductos() {
		return ObjectUtils.defaultIfNull(listaProductos, new ArrayList<DetalleFacturaDTO>());
	}

}
