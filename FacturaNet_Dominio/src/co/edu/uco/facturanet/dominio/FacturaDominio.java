package co.edu.uco.facturanet.dominio;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;
import lombok.Data;

import java.util.ArrayList;
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

@Data
@Entity
@Table(name= "FAC_FACTURA_TBL", schema = "dbo")
public class FacturaDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", nullable = false)
	private int codigo;
	
	@ManyToOne
	@JoinColumn
	private ClienteDominio cliente;
	
	@ManyToOne
	@JoinColumn
	private ClienteDominio empleado;

	@Column(name = "DT_FECHA", nullable = false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn
	private TipoPagoDominio tipoPago;
	
	@ManyToOne
	@JoinColumn
	private List<DetalleFacturaDominio> listaProductos;
	
	public FacturaDominio() {
		setCliente(null);
		setEmpleado(null);
		setFecha(null);
		setTipoPago(null);
	}
	
	public FacturaDominio(int codigo, ClienteDominio cliente, ClienteDominio empleado, Date fecha,
			TipoPagoDominio tipoPago, List<DetalleFacturaDominio> listaProductos) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.empleado = empleado;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
		this.listaProductos = listaProductos;
	}
	
	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo del usuario no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}

	public void setCliente(ClienteDominio cliente) {
		this.cliente = ObjectUtils.defaultIfNull(cliente, new ClienteDominio());
	}

	public void setEmpleado(ClienteDominio empleado) {
		this.empleado = ObjectUtils.defaultIfNull(empleado, new ClienteDominio());
	}

	public void setFecha(Date fecha) {
		this.fecha = ObjectUtils.defaultIfNull(fecha, new Date());
	}

	public void setTipoPago(TipoPagoDominio tipoPago) {
		this.tipoPago = ObjectUtils.defaultIfNull(tipoPago, new TipoPagoDominio());
	}

	public void setListaProductos(List<DetalleFacturaDominio> listaProductos) {
		this.listaProductos = ObjectUtils.defaultIfNull(listaProductos, new ArrayList<DetalleFacturaDominio>());
	}
	
	public List<DetalleFacturaDominio> getListaProductos() {
		return ObjectUtils.defaultIfNull(listaProductos, new ArrayList<DetalleFacturaDominio>());
	}
	
	public double getValor() {
		double valor = 0;
		for (DetalleFacturaDominio detallefacturadominio : getListaProductos()) {
			valor = valor + detallefacturadominio.getValor();
		}
		return valor;
	}
	
	

}
