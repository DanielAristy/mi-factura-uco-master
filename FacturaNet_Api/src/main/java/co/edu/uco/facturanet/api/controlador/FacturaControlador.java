package co.edu.uco.facturanet.api.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.facturanet.api.respuesta.RespuestaApi;
import co.edu.uco.facturanet.dto.ClienteDTO;
import co.edu.uco.facturanet.dto.DetalleFacturaDTO;
import co.edu.uco.facturanet.dto.FacturaDTO;
import co.edu.uco.facturanet.dto.ProductoDTO;
import co.edu.uco.facturanet.dto.TipoPagoDTO;
import co.edu.uco.facturanet.negocio.fachada.IFacturaFachada;
import co.edu.uco.facturanet.negocio.fachada.implementacion.FacturaFachada;

@RestController
@RequestMapping("/api/factura")
public class FacturaControlador {
	
	@Autowired
	private IFacturaFachada facturaFachada;
	
	@GetMapping("/dummy")
	@ResponseBody
	public FacturaDTO crearDummy() {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setCodigo(11);
		
		ClienteDTO empleado = new ClienteDTO();
		empleado.setCodigo(12);
		
		TipoPagoDTO  tipoPago = new TipoPagoDTO();
		tipoPago.setCodigo(5);
		
		List<DetalleFacturaDTO> listaproductos = new ArrayList<DetalleFacturaDTO>();
		
		ProductoDTO producto1 = new ProductoDTO();
		producto1.setCodigo(9);
		
		DetalleFacturaDTO detalle1 = new DetalleFacturaDTO();
		detalle1.setCantidad(75);
		detalle1.setProducto(producto1);
		
		listaproductos.add(detalle1);
		
		ProductoDTO producto2 = new ProductoDTO();
		producto2.setCodigo(10);
		
		DetalleFacturaDTO detalle2 = new DetalleFacturaDTO();
		detalle2.setCantidad(50);
		detalle2.setProducto(producto2);
		
		listaproductos.add(detalle2);
		
		FacturaDTO factura = new FacturaDTO();
		factura.setCliente(cliente);
		factura.setEmpleado(empleado);
		factura.setTipoPago(tipoPago);
		factura.setListaProductos(listaproductos);
		
		
		return factura;
	}
	
	@PostMapping
	public RespuestaApi<FacturaDTO> crear(@RequestBody FacturaDTO factura) {
		
		facturaFachada.registrar(factura);
		
		RespuestaApi<FacturaDTO> respuesta = new RespuestaApi<FacturaDTO>();
		respuesta.setEstado("EXITO");
		List<String> mensajes = new ArrayList<String>();
		mensajes.add("FACTURA REGISTRADA EXITOSAMENTE");
		respuesta.setMensajes(mensajes);
		respuesta.setDatos(new ArrayList<FacturaDTO>());
		respuesta.getDatos().add(factura);
		return respuesta;
	}


}
