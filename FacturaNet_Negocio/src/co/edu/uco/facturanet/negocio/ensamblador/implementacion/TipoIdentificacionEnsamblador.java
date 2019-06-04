package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.TipoIdentificacionDominio;
import co.edu.uco.facturanet.dominio.TipoPagoDominio;
import co.edu.uco.facturanet.dto.TipoIdentificacionDTO;
import co.edu.uco.facturanet.dto.TipoPagoDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;

public class TipoIdentificacionEnsamblador implements IEnsamblador<TipoIdentificacionDTO, TipoIdentificacionDominio> {

	private static final IEnsamblador<TipoIdentificacionDTO, TipoIdentificacionDominio> 
	INSTANCIA = new TipoIdentificacionEnsamblador();
	
	private TipoIdentificacionEnsamblador() {
		super();
	}
	
	public static final IEnsamblador<TipoIdentificacionDTO, TipoIdentificacionDominio> obtenerTipoIdentificacionEnsamblador() {
		return INSTANCIA;
	}
	
	@Override
	public TipoIdentificacionDTO ensamblarDTO(TipoIdentificacionDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de tipo identificacion el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new TipoIdentificacionDTO(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public TipoIdentificacionDominio ensamblarDominio(TipoIdentificacionDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de dominio de tipo identificacion el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new TipoIdentificacionDominio(dto.getCodigo(), dto.getNombre());
		
	}
	
	

}
