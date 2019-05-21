package co.edu.uco.facturanet.dto;

import org.apache.commons.lang3.ObjectUtils;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
	private int codigo;
	private ProductoDTO producto;
	private double cantidad;
	private double valor;
	
	public ProductoDTO getProducto() {
		return ObjectUtils.defaultIfNull(producto, new ProductoDTO());
	}

}
