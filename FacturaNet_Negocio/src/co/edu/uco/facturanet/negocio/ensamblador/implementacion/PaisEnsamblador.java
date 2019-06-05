package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import java.util.List;

import co.edu.uco.facturanet.dominio.PaisDominio;
import co.edu.uco.facturanet.dominio.ProductoDominio;
import co.edu.uco.facturanet.dto.PaisDTO;
import co.edu.uco.facturanet.dto.ProductoDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;


public class PaisEnsamblador implements IEnsamblador<PaisDTO, PaisDominio>{
	
	private static final IEnsamblador<PaisDTO, PaisDominio> 
	INSTANCIA = new PaisEnsamblador();
	
	private PaisEnsamblador() {
		super();
	}
	
	public static IEnsamblador<PaisDTO, PaisDominio> obtenerPaisEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public PaisDTO ensamblarDTO(PaisDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Pais el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new PaisDTO(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public PaisDominio ensamblarDominio(PaisDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de dominio  de Pais el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new PaisDominio(dto.getCodigo(), dto.getNombre());
	}

	@Override
	public List<PaisDominio> ensamblarListaDominios(List<PaisDTO> listaDTOs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> ensamblarListaDTOs(List<PaisDominio> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}

}
