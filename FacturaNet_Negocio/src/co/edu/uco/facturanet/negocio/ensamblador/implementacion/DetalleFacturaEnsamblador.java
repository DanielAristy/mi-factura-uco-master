package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import java.util.ArrayList;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.ClienteEnsamblador.obtenerClienteEnsamblador;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.TipoPagoEnsamblador.obtenerTipoPagoEnsamblador;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.ProductoEnsamblador.obtenerProductoEnsamblador;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

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
	
	public static IEnsamblador<DetalleFacturaDTO, DetalleFacturaDominio> obtenerDetalleFacturaEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public DetalleFacturaDTO ensamblarDTO(DetalleFacturaDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Detalle Factura el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		ProductoDTO producto = ProductoEnsamblador.obtenerProductoEnsamblador().ensamblarDTO(dominio.getProducto());
		FacturaDTO factura = FacturaEnsamblador.obtenerFacturaEnsamblador().ensamblarDTO(dominio.getFactura());
		return new DetalleFacturaDTO(dominio.getCodigo(),
				producto,
				factura,
				dominio.getCantidad(),
				dominio.getValor());
	}

	@Override
	public DetalleFacturaDominio ensamblarDominio(DetalleFacturaDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de dominio de datos de Detalle Factura el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		ProductoDominio producto = ProductoEnsamblador.obtenerProductoEnsamblador().ensamblarDominio(dto.getProducto());
		FacturaDominio factura = FacturaEnsamblador.obtenerFacturaEnsamblador().ensamblarDominio(dto.getFactura());
		return new DetalleFacturaDominio(dto.getCodigo(),
				producto,
				factura,
				dto.getCantidad());
	}

	@Override
	public List<DetalleFacturaDominio> ensamblarListaDominios(List<DetalleFacturaDTO> listaDTOs) {
		List<DetalleFacturaDTO> listaDTOsLocal = ObjectUtils.defaultIfNull(listaDTOs, new ArrayList<DetalleFacturaDTO>());
		List<DetalleFacturaDominio> listaDominiosRetorno = new ArrayList<DetalleFacturaDominio>();

		for (DetalleFacturaDTO detalleFacturaDTO : listaDTOsLocal) {
			listaDominiosRetorno.add(ensamblarDominio(detalleFacturaDTO));
		}

		return listaDominiosRetorno;

	}

	@Override
	public List<DetalleFacturaDTO> ensamblarListaDTOs(List<DetalleFacturaDominio> listaDominios) {
		List<DetalleFacturaDominio> listaDominiosLocal = ObjectUtils.defaultIfNull(listaDominios, new ArrayList<DetalleFacturaDominio>());
		List<DetalleFacturaDTO> listaDTOsRetorno = new ArrayList<DetalleFacturaDTO>();

		for (DetalleFacturaDominio detalleFacturaDominio : listaDominiosLocal) {
			listaDTOsRetorno.add(ensamblarDTO(detalleFacturaDominio));
		}

		return listaDTOsRetorno;

	}

}
