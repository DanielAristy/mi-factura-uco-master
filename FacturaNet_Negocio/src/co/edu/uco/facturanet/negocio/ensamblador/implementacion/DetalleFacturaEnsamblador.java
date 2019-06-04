package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import java.util.ArrayList;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.ClienteEnsamblador.obtenerClienteEnsamblador;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.TipoPagoEnsamblador.obtenerTipoPagoEnsamblador;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.ProductoEnsamblador.obtenerProductoEnsamblador;
import java.util.List;

import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.FacturaEnsamblador.obtenerFacturaEnsamblador;

import co.edu.uco.facturanet.dominio.CiudadDominio;
import co.edu.uco.facturanet.dominio.ClienteDominio;
import co.edu.uco.facturanet.dominio.DepartamentoDominio;
import co.edu.uco.facturanet.dominio.DetalleFacturaDominio;
import co.edu.uco.facturanet.dominio.FacturaDominio;
import co.edu.uco.facturanet.dominio.PaisDominio;
import co.edu.uco.facturanet.dominio.ProductoDominio;
import co.edu.uco.facturanet.dominio.TipoIdentificacionDominio;
import co.edu.uco.facturanet.dominio.TipoPagoDominio;
import co.edu.uco.facturanet.dto.CiudadDTO;
import co.edu.uco.facturanet.dto.ClienteDTO;
import co.edu.uco.facturanet.dto.DepartamentoDTO;
import co.edu.uco.facturanet.dto.DetalleFacturaDTO;
import co.edu.uco.facturanet.dto.FacturaDTO;
import co.edu.uco.facturanet.dto.PaisDTO;
import co.edu.uco.facturanet.dto.ProductoDTO;
import co.edu.uco.facturanet.dto.TipoIdentificacionDTO;
import co.edu.uco.facturanet.dto.TipoPagoDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;

public class DetalleFacturaEnsamblador implements IEnsamblador<DetalleFacturaDTO, DetalleFacturaDominio> {
	
	private static final IEnsamblador<DetalleFacturaDTO, DetalleFacturaDominio> 
	INSTANCIA = new DetalleFacturaEnsamblador();
	
	private DetalleFacturaEnsamblador() {
		super();
	}
	
	private static final IEnsamblador<DetalleFacturaDTO, DetalleFacturaDominio> obtenerDetalleFacturaEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public DetalleFacturaDTO ensamblarDTO(DetalleFacturaDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Detalle Factura el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		return new DetalleFacturaDTO(dominio.getCodigo(),
				ProductoEnsamblador.obtenerProductoEnsamblador().ensamblarDTO(dominio.getProducto()),
				FacturaEnsamblador.obtenerFacturaEnsamblador().ensamblarDTO(dominio.getFactura()),
				dominio.getCantidad());
	}

	@Override
	public DetalleFacturaDominio ensamblarDominio(DetalleFacturaDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de dominio de datos de Detalle Factura el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
			
		return new DetalleFacturaDominio(dto.getCodigo(),
				ProductoEnsamblador.obtenerProductoEnsamblador().ensamblarDominio(dto.getProducto()),
				FacturaEnsamblador.obtenerFacturaEnsamblador().ensamblarDominio(dto.getFactura()),
				dto.getCantidad());
	}

}
