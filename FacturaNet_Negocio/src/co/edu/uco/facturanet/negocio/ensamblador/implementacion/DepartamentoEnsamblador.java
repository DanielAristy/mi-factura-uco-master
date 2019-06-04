package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.DepartamentoDominio;
import co.edu.uco.facturanet.dominio.PaisDominio;
import co.edu.uco.facturanet.dto.DepartamentoDTO;
import co.edu.uco.facturanet.dto.PaisDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;

public class DepartamentoEnsamblador implements IEnsamblador<DepartamentoDTO, DepartamentoDominio> {
	
	private static final IEnsamblador<DepartamentoDTO, DepartamentoDominio> 
	INSTANCIA = new DepartamentoEnsamblador();
	
	private DepartamentoEnsamblador() {
		super();
	}
	
	private static final IEnsamblador<DepartamentoDTO, DepartamentoDominio> obtenerDepartamentoEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public DepartamentoDTO ensamblarDTO(DepartamentoDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Departamento el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		return new DepartamentoDTO(dominio.getCodigo(), dominio.getNombre(), 
				new PaisDTO(dominio.getPais().getCodigo(),dominio.getPais().getNombre()));
	}

	@Override
	public DepartamentoDominio ensamblarDominio(DepartamentoDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Departamento el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new DepartamentoDominio(dto.getCodigo(), dto.getNombre(), 
				new PaisDominio(dto.getPais().getCodigo(),dto.getPais().getNombre()));
	}


}
