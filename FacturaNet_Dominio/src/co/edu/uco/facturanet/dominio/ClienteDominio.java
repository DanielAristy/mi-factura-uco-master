package co.edu.uco.facturanet.dominio;

import org.apache.commons.lang3.StringUtils;

import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "FAC_CLIENTE_TBL", schema = "dbo")
public class ClienteDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private int codigo;
	
	@Column(name = "IDENTIFICACION", nullable = false)
	private String identificacion;
	
	@ManyToOne
	@JoinColumn
	private TipoIdentificacionDominio tipoIdentificacion;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "TELEFONO", nullable = false)
	private String telefono;
	
	@Column(name = "DIRECCION", nullable = false)
	private String direccion;
	
	@Column(name = "CORREOELECTRONICO", nullable = false)
	private String correoElectronico;
	
	@ManyToOne
	@JoinColumn
	private CiudadDominio ciudadResidencia;
	
	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo del usuario no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		String nombreTmp = StringUtils.trimToEmpty(nombre);
		if (nombreTmp.length() > 0 ) {
			if (nombreTmp.length() > 50 ) {
				throw FacturanetException.CREAR("El nombre del usuario no puede tener mas de 50 caracteres", CapaEnum.DOMINIO);
			}
			if (nombreTmp.matches("^[a-zA-ZÒ—·¡È…ÌÕÛ”˙⁄ ]+$")) {
				throw FacturanetException.CREAR("El nombre del usuario ingresado no es valido", CapaEnum.DOMINIO);
			}
		}
		this.nombre = nombreTmp;
		
	}
	private void setIdentificacion(String identificacion) {
		String identificacionTmp = StringUtils.trimToEmpty(identificacion);
		if (identificacionTmp.length() > 0 ) {
			if (identificacionTmp.length() > 50 ) {
				throw FacturanetException.CREAR("La identificacion no puede tener mas de 50 caracteres", CapaEnum.DOMINIO);
			}
			if (identificacionTmp.matches("^[a-zA-ZÒ—·¡È…ÌÕÛ”˙⁄ ]+$")) {
				throw FacturanetException.CREAR("la identificacion ingresado no es valida", CapaEnum.DOMINIO);
			}
		}
		this.identificacion = identificacionTmp;
	}
	private void setTipoIdentificacion(TipoIdentificacionDominio tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	private void setTelefono(String telefono) {
		String telefonoTmp = StringUtils.trimToEmpty(telefono);
		if (telefonoTmp.length() > 0 ) {
			if (telefonoTmp.length() > 50 ) {
				throw FacturanetException.CREAR("El telefono no puede tener mas de 50 caracteres", CapaEnum.DOMINIO);
			}
			if (telefonoTmp.matches("^[a-zA-Z0-9Ò— ]+$")) {
				throw FacturanetException.CREAR("El telefono ingresado no es valido", CapaEnum.DOMINIO);
			}
		}
		this.telefono = telefonoTmp;
	}
	
	private void setDireccion(String direccion) {
		String direccionTmp = StringUtils.trimToEmpty(direccion);
		if (direccionTmp.length() > 0 ) {
			if (direccionTmp.length() > 50 ) {
				throw FacturanetException.CREAR("la direccion no puede tener mas de 50 caracteres", CapaEnum.DOMINIO);
			}
			if (direccionTmp.matches("^[a-zA-Z0-9Ò—·¡È…ÌÕÛ”˙⁄ ]+$")) {
				throw FacturanetException.CREAR("La direccion que a ingresado no es valida", CapaEnum.DOMINIO);
			}
		}
		this.direccion = direccionTmp;
	}
	
	private void setCorreoElectronico(String correoElectronico) {
		String correoTmp = StringUtils.trimToEmpty(correoElectronico);
		if (correoTmp.length() > 0 ) {
			if (correoTmp.length() > 50 ) {
				throw FacturanetException.CREAR("El correo electronico no puede tener mas de 50 caracteres", CapaEnum.DOMINIO);
			}
			if (correoTmp.matches("^[a-zA-Z0-9Ò—·¡È…ÌÕÛ”˙⁄ ]+$")) {
				throw FacturanetException.CREAR("La direccion de correo electronico que a ingresado no es valida", CapaEnum.DOMINIO);
			}
		}
		this.correoElectronico = correoElectronico;
	}
	
	private void setCiudadResidencia(CiudadDominio ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	
	
	

}
