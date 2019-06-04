package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
	private int codigo;
	private ProductoDTO producto;
	private FacturaDTO factura;
	private double cantidad;
	
	public DetalleFacturaDTO() {
		setProducto(null);
		setFactura(null);
	}
	
	public DetalleFacturaDTO(int codigo, ProductoDTO producto,FacturaDTO factura, double cantidad) {
		setCodigo(codigo);
		setProducto(producto);
		setFactura(factura);
		setCantidad(cantidad);
	
	}
	
	public ProductoDTO getProducto() {
		return ObjectUtils.defaultIfNull(producto, new ProductoDTO());
	}
	
	public FacturaDTO getFactura() {
		return ObjectUtils.defaultIfNull(factura, new FacturaDTO());
	}



}
