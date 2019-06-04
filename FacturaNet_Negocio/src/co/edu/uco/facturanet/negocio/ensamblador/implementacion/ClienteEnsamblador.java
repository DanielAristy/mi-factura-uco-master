package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.CiudadDominio;
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
	
	private static final IEnsamblador<ClienteDTO, ClienteDominio> obtenerClienteEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public ClienteDTO ensamblarDTO(ClienteDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Cliente el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		return new ClienteDTO(dominio.getCodigo(),dominio.getIdentificacion(),
				new TipoIdentificacionDTO(dominio.getTipoIdentificacion().getCodigo(),dominio.getTipoIdentificacion().getNombre()),
				dominio.getNombre(), dominio.getTelefono(), dominio.getDireccion(),dominio.getCorreoElectronico(),
				new CiudadDTO(dominio.getCiudadResidencia().getCodigo(),dominio.getCiudadResidencia().getNombre(), 
						new DepartamentoDTO(dominio.getCiudadResidencia().getDepartamento().getCodigo(),dominio.getCiudadResidencia().getDepartamento().getNombre(),
								new PaisDTO(dominio.getCiudadResidencia().getDepartamento().getPais().getCodigo(),dominio.getCiudadResidencia().getDepartamento().getPais().getNombre()))));
	}

	@Override
	public ClienteDominio ensamblarDominio(ClienteDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Ciudad el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		
		return new ClienteDominio(dto.getCodigo(),dto.getIdentificacion(),
				new TipoIdentificacionDominio(dto.getTipoIdentificacion().getCodigo(),dto.getTipoIdentificacion().getNombre()),
				dto.getNombre(), dto.getTelefono(), dto.getDireccion(),dto.getCorreoElectronico(),
				new CiudadDominio(dto.getCiudadResidencia().getCodigo(),dto.getCiudadResidencia().getNombre(), 
						new DepartamentoDominio(dto.getCiudadResidencia().getDepartamento().getCodigo(),dto.getCiudadResidencia().getDepartamento().getNombre(),
								new PaisDominio(dto.getCiudadResidencia().getDepartamento().getPais().getCodigo(),dto.getCiudadResidencia().getDepartamento().getPais().getNombre()))));
	}
		

}
