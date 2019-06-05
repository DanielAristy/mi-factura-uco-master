package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
	private int codigo;
	private ProductoDTO producto;
	private FacturaDTO factura;
	private double cantidad;
	private double valor;
	
	public DetalleFacturaDTO() {
		super();
	}
	
	public DetalleFacturaDTO(int codigo, ProductoDTO producto,FacturaDTO factura, double cantidad,double valor) {
		setCodigo(codigo);
		setFactura(factura);
		setProducto(producto);
		setCantidad(cantidad);
		setValor(valor);
	
	}
	
	public ProductoDTO getProducto() {
		return ObjectUtils.defaultIfNull(producto, new ProductoDTO());
	}
	
	public FacturaDTO getFactura() {
		return ObjectUtils.defaultIfNull(factura, new FacturaDTO());
	}
	
}
