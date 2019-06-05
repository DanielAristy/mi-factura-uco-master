package co.edu.uco.facturanet.negocio.negocio.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.facturanet.datos.dao.IFacturaJPADAO;
import co.edu.uco.facturanet.dominio.FacturaDominio;
import co.edu.uco.facturanet.negocio.negocio.IFacturaNegocio;

@Service("facturaNegocio")
public class FacturaNegocio implements IFacturaNegocio {
	
	@Autowired
	private IFacturaJPADAO facturaDao;

	@Override
	public void registrar(FacturaDominio factura) {
		facturaDao.save(factura);
		
	}

	

}
