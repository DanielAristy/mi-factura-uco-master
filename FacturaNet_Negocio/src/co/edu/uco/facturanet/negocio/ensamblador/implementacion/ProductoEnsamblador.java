package co.edu.uco.facturanet.negocio.ensamblador.implementacion;

import co.edu.uco.facturanet.dominio.ProductoDominio;
import co.edu.uco.facturanet.dominio.TipoIdentificacionDominio;
import co.edu.uco.facturanet.dto.ProductoDTO;
import co.edu.uco.facturanet.dto.TipoIdentificacionDTO;
import co.edu.uco.facturanet.negocio.ensamblador.IEnsamblador;
import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;

public class ProductoEnsamblador implements IEnsamblador<ProductoDTO, ProductoDominio>{
	
	private static final IEnsamblador<ProductoDTO, ProductoDominio> 
	INSTANCIA = new ProductoEnsamblador();
	
	private ProductoEnsamblador() {
		super();
	}
	
	private static final IEnsamblador<ProductoDTO, ProductoDominio> obtenerProductoEnsamblador() {
		return INSTANCIA;
	}
	
	@Override
	public ProductoDTO ensamblarDTO(ProductoDominio dominio) {
		if (dominio == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Producto el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new ProductoDTO(dominio.getCodigo(), dominio.getNombre(), dominio.getValor());
	}

	@Override
	public ProductoDominio ensamblarDominio(ProductoDTO dto) {
		if (dto == null) {
			throw FacturanetException.CREAR("Para ensamblar un objeto de transferencia de datos de Producto el objeto"
					+ " de dominio de datos no puede ser nulo", CapaEnum.NEGOCIO);
		}
		return new ProductoDominio(dto.getCodigo(), dto.getNombre(), dto.getValor());
	}

}
