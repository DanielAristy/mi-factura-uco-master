package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import java.util.ArrayList;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.DetalleFacturaEnsamblador.obtenerDetalleFacturaEnsamblador;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.ClienteEnsamblador.obtenerClienteEnsamblador;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.TipoPagoEnsamblador.obtenerTipoPagoEnsamblador;
import java.util.List;

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

public class FacturaEnsamblador implements IEnsamblador<FacturaDTO, FacturaDominio> {
	
	private static final IEnsamblador<FacturaDTO, FacturaDominio> 
	INSTANCIA = new FacturaEnsamblador();
	
	private FacturaEnsamblador() {
		super();
	}
	
	public static IEnsamblador<FacturaDTO, FacturaDominio> obtenerFacturaEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public FacturaDTO ensamblarDTO(FacturaDominio dominio) {
			if (dominio == null) {
				throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Factura el objeto"
						+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
			}
			return new FacturaDTO(dominio.getCodigo(),
					obtenerClienteEnsamblador().ensamblarDTO(dominio.getCliente()), 
					obtenerClienteEnsamblador().ensamblarDTO(dominio.getEmpleado()),
					dominio.getFecha(), 
					obtenerTipoPagoEnsamblador().ensamblarDTO(dominio.getTipoPago()),
					obtenerDetalleFacturaEnsamblador().ensamblarListaDTOs(dominio.getListaProductos()),
					dominio.getValor());
	}

	@Override
	public FacturaDominio ensamblarDominio(FacturaDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de dominio de datos de Factura el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new FacturaDominio(dto.getCodigo(),
				obtenerClienteEnsamblador().ensamblarDominio(dto.getCliente()), 
				obtenerClienteEnsamblador().ensamblarDominio(dto.getEmpleado()),
				dto.getFecha(), 
				obtenerTipoPagoEnsamblador().ensamblarDominio(dto.getTipoPago()),
				obtenerDetalleFacturaEnsamblador().ensamblarListaDominios(dto.getListaProductos()));
	}

	@Override
	public List<FacturaDominio> ensamblarListaDominios(List<FacturaDTO> listaDTOs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaDTO> ensamblarListaDTOs(List<FacturaDominio> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}

}
