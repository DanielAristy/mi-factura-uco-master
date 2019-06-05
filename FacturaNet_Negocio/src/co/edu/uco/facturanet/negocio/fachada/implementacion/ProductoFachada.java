package co.edu.uco.facturanet.negocio.fachada.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.facturanet.dominio.FacturaDominio;
import co.edu.uco.facturanet.dominio.ProductoDominio;
import co.edu.uco.facturanet.dto.FacturaDTO;
import co.edu.uco.facturanet.dto.ProductoDTO;
import co.edu.uco.facturanet.negocio.ensamblador.implementacion.FacturaEnsamblador;
import co.edu.uco.facturanet.negocio.ensamblador.implementacion.ProductoEnsamblador;
import co.edu.uco.facturanet.negocio.fachada.IFacturaFachada;
import co.edu.uco.facturanet.negocio.fachada.IProductoFachada;
import co.edu.uco.facturanet.negocio.negocio.IFacturaNegocio;
import co.edu.uco.facturanet.negocio.negocio.IProductoNegocio;

@Service("productoFachada")
@Transactional
public class ProductoFachada implements IProductoFachada {
	
	@Autowired
	private IProductoNegocio productoNegocio;

	@Override
	public void registrar(ProductoDTO producto) {
		
		ProductoDominio productoDominio = ProductoEnsamblador.obtenerProductoEnsamblador().ensamblarDominio(producto);

		productoNegocio.registrar(productoDominio);

	}

}
