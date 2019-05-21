package co.edu.uco.facturanet.dominio;

import org.apache.commons.lang3.StringUtils;

import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;
import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Data
@Entity
@Table(name= "FAC_FACTURA_TBL", schema = "dbo")
public class FacturaDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private int codigo;
	
	@ManyToOne
	@JoinColumn
	private ClienteDominio cliente;
	
	@ManyToOne
	@JoinColumn
	private ClienteDominio empleado;

	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn
	private TipoPagoDominio tipoPago;
	
	@Column(name = "VALOR", nullable = false)
	private double valor;
		
	@ManyToOne
	@JoinColumn
	private List<DetalleFacturaDominio> listaProductos;
	
	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo del usuario no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}

	private void setCliente(ClienteDominio cliente) {
		this.cliente = cliente;
	}

	private void setEmpleado(ClienteDominio empleado) {
		this.empleado = empleado;
	}

	private void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private void setTipoPago(TipoPagoDominio tipoPago) {
		this.tipoPago = tipoPago;
	}

	private void setValor(double valor) {
		if (valor < 0 ) {
			throw FacturanetException.CREAR("El valor no puede ser menor a 0", CapaEnum.DOMINIO);
		}
		this.valor = valor;
	}

	private void setListaProductos(List<DetalleFacturaDominio> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	
	

}
