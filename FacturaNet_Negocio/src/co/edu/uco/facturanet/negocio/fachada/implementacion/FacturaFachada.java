package co.edu.uco.facturanet.negocio.fachada.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.facturanet.dominio.FacturaDominio;
import co.edu.uco.facturanet.dto.FacturaDTO;
import co.edu.uco.facturanet.negocio.ensamblador.implementacion.FacturaEnsamblador;
import co.edu.uco.facturanet.negocio.fachada.IFacturaFachada;
import co.edu.uco.facturanet.negocio.negocio.IFacturaNegocio;

@Service("facturaFachada")
@Transactional
public class FacturaFachada implements IFacturaFachada {
	
	@Autowired
	private IFacturaNegocio facturaNegocio;

	@Override
	public void registrar(FacturaDTO factura) {
		
		FacturaDominio facturaDominio = FacturaEnsamblador.obtenerFacturaEnsamblador().ensamblarDominio(factura);

		facturaNegocio.registrar(facturaDominio);

	}

}
