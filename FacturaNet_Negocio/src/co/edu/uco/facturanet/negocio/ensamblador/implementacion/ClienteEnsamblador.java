package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.CiudadDominio;
import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.TipoIdentificacionEnsamblador.obtenerTipoIdentificacionEnsamblador;

import java.util.List;

import static co.edu.uco.facturanet.negocio.ensamblador.implementacion.CiudadEnsamblador.obtenerCiudadEnsamblador;
import co.edu.uco.facturanet.dominio.ClienteDominio;
import co.edu.uco.facturanet.dominio.DepartamentoDominio;
import co.edu.uco.facturanet.dominio.PaisDominio;
import co.edu.uco.facturanet.dominio.TipoIdentificacionDominio;
import co.edu.uco.facturanet.dto.CiudadDTO;
import co.edu.uco.facturanet.dto.ClienteDTO;
import co.edu.uco.facturanet.dto.DepartamentoDTO;
import co.edu.uco.facturanet.dto.PaisDTO;
import co.edu.uco.facturanet.dto.TipoIdentificacionDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;

public class ClienteEnsamblador implements IEnsamblador<ClienteDTO, ClienteDominio> {
	
	private static final IEnsamblador<ClienteDTO, ClienteDominio> 
	INSTANCIA = new ClienteEnsamblador();
	
	private ClienteEnsamblador() {
		super();
	}
	
	public static IEnsamblador<ClienteDTO, ClienteDominio> obtenerClienteEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public ClienteDTO ensamblarDTO(ClienteDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Cliente el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		TipoIdentificacionDTO tipoidentificacion = obtenerTipoIdentificacionEnsamblador().ensamblarDTO(dominio.getTipoIdentificacion());
		CiudadDTO ciudad = obtenerCiudadEnsamblador().ensamblarDTO(dominio.getCiudadResidencia());
		return new ClienteDTO(dominio.getCodigo(),
				dominio.getIdentificacion(),
				tipoidentificacion,
				dominio.getNombre(),
				dominio.getTelefono(),
				dominio.getDireccion(),
				dominio.getCorreoElectronico(),
				ciudad);
	}

	@Override
	public ClienteDominio ensamblarDominio(ClienteDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de dominio de datos de Ciudad el objeto"
					+ " de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		TipoIdentificacionDominio tipoidentificacion = obtenerTipoIdentificacionEnsamblador().ensamblarDominio(dto.getTipoIdentificacion());
		CiudadDominio ciudad = obtenerCiudadEnsamblador().ensamblarDominio(dto.getCiudadResidencia());
		return new ClienteDominio(dto.getCodigo(),
				dto.getIdentificacion(),
				tipoidentificacion,
				dto.getNombre(),
				dto.getTelefono(),
				dto.getDireccion(),
				dto.getCorreoElectronico(),
				ciudad);
	}

	@Override
	public List<ClienteDominio> ensamblarListaDominios(List<ClienteDTO> listaDTOs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> ensamblarListaDTOs(List<ClienteDominio> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
