package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.CiudadDominio;
import co.edu.uco.facturanet.dominio.DepartamentoDominio;
import co.edu.uco.facturanet.dominio.PaisDominio;
import co.edu.uco.facturanet.dto.CiudadDTO;
import co.edu.uco.facturanet.dto.DepartamentoDTO;
import co.edu.uco.facturanet.dto.PaisDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;

public class CiudadEnsamblador implements IEnsamblador<CiudadDTO, CiudadDominio> {
	
	private static final IEnsamblador<CiudadDTO, CiudadDominio> 
	INSTANCIA = new CiudadEnsamblador();
	
	private CiudadEnsamblador() {
		super();
	}
	
	private static final IEnsamblador<CiudadDTO, CiudadDominio> obtenerCiudadEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public CiudadDTO ensamblarDTO(CiudadDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Ciuadad el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		return new CiudadDTO(dominio.getCodigo(), dominio.getNombre(), 
				new DepartamentoDTO(dominio.getDepartamento().getCodigo(),dominio.getDepartamento().getNombre(),
						new PaisDTO(dominio.getDepartamento().getPais().getCodigo(),dominio.getDepartamento().getPais().getNombre())));
	}

	@Override
	public CiudadDominio ensamblarDominio(CiudadDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Ciudad el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		return new CiudadDominio(dto.getCodigo(), dto.getNombre(), 
				new DepartamentoDominio(dto.getDepartamento().getCodigo(),dto.getDepartamento().getNombre(),
						new PaisDominio(dto.getDepartamento().getPais().getCodigo(),dto.getDepartamento().getPais().getNombre())));
	}

}
