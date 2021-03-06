package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.DepartamentoDominio;
import co.edu.uco.facturanet.dominio.PaisDominio;
import co.edu.uco.facturanet.dto.DepartamentoDTO;
import co.edu.uco.facturanet.dto.PaisDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.PaisEnsamblador.obtenerPaisEnsamblador;

import java.util.List;

public class DepartamentoEnsamblador implements IEnsamblador<DepartamentoDTO, DepartamentoDominio> {
	
	public static final IEnsamblador<DepartamentoDTO, DepartamentoDominio> 
	INSTANCIA = new DepartamentoEnsamblador();
	
	private DepartamentoEnsamblador() {
		super();
	}
	
	public static IEnsamblador<DepartamentoDTO, DepartamentoDominio> obtenerDepartamentoEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public DepartamentoDTO ensamblarDTO(DepartamentoDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Departamento el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		PaisDTO pais = obtenerPaisEnsamblador().ensamblarDTO(dominio.getPais());
		return new DepartamentoDTO(dominio.getCodigo(), 
				dominio.getNombre(),  
				pais);
	}

	@Override
	public DepartamentoDominio ensamblarDominio(DepartamentoDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Departamento el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		PaisDominio pais = obtenerPaisEnsamblador().ensamblarDominio(dto.getPais());
		return new DepartamentoDominio(dto.getCodigo(), 
				dto.getNombre(), 
				pais);
	}

	@Override
	public List<DepartamentoDominio> ensamblarListaDominios(List<DepartamentoDTO> listaDTOs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDTO> ensamblarListaDTOs(List<DepartamentoDominio> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}


}
