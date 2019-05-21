package co.edu.uco.facturanet.api.respuesta;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaApi<T> {

	private List<T> datos;
	private List<String> mensajes;
	private String estado;
}
