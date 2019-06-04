package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.TipoPagoDominio;
import co.edu.uco.facturanet.dto.TipoPagoDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;


public class TipoPagoEnsamblador implements IEnsamblador<TipoPagoDTO, TipoPagoDominio> {
	
	private static final IEnsamblador<TipoPagoDTO, TipoPagoDominio> INSTANCIA = new TipoPagoEnsamblador();

	private TipoPagoEnsamblador() {
		super();
	}
	
	public static IEnsamblador<TipoPagoDTO, TipoPagoDominio> obtenerTipoPagoEnsamblador() {
		return INSTANCIA;
	}
	
	@Override
	public TipoPagoDominio ensamblarDominio(TipoPagoDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un dominio de tipo pago el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new TipoPagoDominio(dto.getCodigo(), dto.getNombre());
	}

	@Override
	public TipoPagoDTO ensamblarDTO(TipoPagoDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de tipo pago el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new TipoPagoDTO(dominio.getCodigo(), dominio.getNombre());
	}
}
