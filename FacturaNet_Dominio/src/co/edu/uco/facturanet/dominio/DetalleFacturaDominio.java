package co.edu.uco.facturanet.dominio;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "FAC_DETALLE_FACTURA_TBL", schema = "dbo")
public class DetalleFacturaDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", nullable = false)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_PRODUCTO")
	private ProductoDominio producto;
	
	@ManyToOne
	@JoinColumn(name = "IN_CODIGO_FACTURA")
	private FacturaDominio factura;
	
	@Column(name = "NU_CANTIDAD", nullable = false)
	private double cantidad;
	
	public DetalleFacturaDominio() {
		setFactura(null);
		setProducto(null);
	}
	
	public DetalleFacturaDominio(int codigo, ProductoDominio producto, FacturaDominio factura, double cantidad) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.factura = factura;
		this.cantidad = cantidad;
	}
		
	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo del detalle no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}

	public void setProducto(ProductoDominio producto) {
		this.producto = ObjectUtils.defaultIfNull(producto, new ProductoDominio());
	}
	
	public void setFactura(FacturaDominio factura) {
		this.factura = ObjectUtils.defaultIfNull(factura, new FacturaDominio());
	}

	public void setCantidad(double cantidad) {
		if (cantidad <= 0 ) {
			throw FacturanetException.CREAR("La cantidad no puede ser menor o igual a 0", CapaEnum.DOMINIO);
		}
		this.cantidad = cantidad;
	}
	
	public double getValor() {
		return getProducto().getValor() * getCantidad();
	}
	
	public ProductoDominio getProducto() {
		return ObjectUtils.defaultIfNull(producto, new ProductoDominio());
	}
	
}
