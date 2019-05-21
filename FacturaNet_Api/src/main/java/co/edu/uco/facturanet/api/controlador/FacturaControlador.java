package co.edu.uco.facturanet.api.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.facturanet.api.respuesta.RespuestaApi;
import co.edu.uco.facturanet.dto.FacturaDTO;

@RestController
@RequestMapping("/api/factura")
public class FacturaControlador {
	
	@PostMapping
	public RespuestaApi<FacturaDTO> crear(@RequestBody FacturaDTO factura) {
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
