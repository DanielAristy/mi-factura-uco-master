package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
	private int codigo;
	private ProductoDTO producto;
	private double cantidad;
	private double valor;
	
	public DetalleFacturaDTO() {
		setProducto(null);
	}
	
	public DetalleFacturaDTO(int codigo, ProductoDTO producto, double cantidad, double valor) {
		setCodigo(codigo);
		setProducto(producto);
		setCantidad(cantidad);
		setValor(valor);
	
	}
	
	public ProductoDTO getProducto() {
		return ObjectUtils.defaultIfNull(producto, new ProductoDTO());
	}



}
