package co.edu.uco.facturanet.transversal.excepcion;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import lombok.Getter;

@Getter
public class FacturanetException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Throwable excepcionRaiz;
	private String mensaje;
	private CapaEnum capa;
	
	
	private FacturanetException(Throwable excepcionRaiz, String mensaje, CapaEnum capa) {
		setMensaje(mensaje);
		setExcepcionRaiz(excepcionRaiz);
		setCapa(capa);
	}
	
	public static FacturanetException CREAR (Throwable excepcionRaiz, String mensaje, CapaEnum capa) {
		return new FacturanetException(excepcionRaiz, mensaje, capa);
	}
	
	public static FacturanetException CREAR (String mensaje) {
		return new FacturanetException(null, mensaje, null);
	}
	public static FacturanetException CREAR (String mensaje, CapaEnum capa) {
		return new FacturanetException(null, mensaje, capa);
	}
	public static FacturanetException CREAR (Throwable excepcionRaiz, String mensaje) {
		return new FacturanetException(excepcionRaiz, mensaje, null);
	}
	
	private void setExcepcionRaiz(Throwable excepcionRaiz) {
		this.excepcionRaiz = ObjectUtils.defaultIfNull(excepcionRaiz, new Exception(mensaje));
	}


	private void setMensaje(String mensaje) {
		this.mensaje = StringUtils.defaultString(mensaje);
	}


	private void setCapa(CapaEnum capa) {
		this.capa = ObjectUtils.defaultIfNull(capa, CapaEnum.TRANSVERSAL);
	}
	
}
