package co.edu.uco.facturanet.negocio.negocio.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.facturanet.datos.dao.FacturaJPADAO;
import co.edu.uco.facturanet.datos.dao.ProductoJPADAO;
import co.edu.uco.facturanet.dominio.FacturaDominio;
import co.edu.uco.facturanet.dominio.ProductoDominio;
import co.edu.uco.facturanet.negocio.negocio.IFacturaNegocio;
import co.edu.uco.facturanet.negocio.negocio.IProductoNegocio;

@Service("productoNegocio")
public class ProductoNegocio implements IProductoNegocio{
	
	@Autowired
	private ProductoJPADAO productoDao;

	@Override
	public void registrar(ProductoDominio producto) {
		productoDao.save(producto);
		
	}

	

}
