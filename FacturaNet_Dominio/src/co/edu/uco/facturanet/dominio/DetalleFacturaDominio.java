package co.edu.uco.facturanet.dominio;

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

//@Data
@Entity
@Table(name= "FAC_DETALLEFACTURA_TBL", schema = "dbo")
public class DetalleFacturaDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private int codigo;
	
	@ManyToOne
	@JoinColumn
	private ProductoDominio producto;
	
	@Column(name = "CANTIDAD", nullable = false)
	private double cantidad;
	
	@Column(name = "VALOR", nullable = false)
	private double valor;
	
	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo del detalle no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}

	private void setProducto(ProductoDominio producto) {
		this.producto = producto;
	}

	private void setCantidad(double cantidad) {
		if (cantidad <= 0 ) {
			throw FacturanetException.CREAR("La cantidad no puede ser menor o igual a 0", CapaEnum.DOMINIO);
		}
		this.cantidad = cantidad;
	}

	private void setValor(double valor) {
		if (valor < 0 ) {
			throw FacturanetException.CREAR("El valor no puede ser menor a 0", CapaEnum.DOMINIO);
		}
		this.valor = valor;
	}
	
	
	
	

}
