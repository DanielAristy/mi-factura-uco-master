package co.edu.uco.facturanet.transversal.excepcion;

public class FacturanetException extends RuntimeException {

	private Throwable excepcionRaiz;
	private String mensaje;
	private CapaEnum capa;
}
