package co.edu.uco.facturanet.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import co.edu.uco.facturanet.transversal.enumeracion.CapaEnum;
import co.edu.uco.facturanet.transversal.excepcion.FacturanetException;
import lombok.Data;

@Data
@Entity
@Table(name = "FAC_DEPARTAMENTO_TBL", schema = "dbo")
public class DepartamentoDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", nullable = false)
	private int codigo;
	
	@Column(name = "NV_NOMBRE", nullable = false, length = 500)
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name = "IN_CODIGO_PAIS")
	private PaisDominio pais;
	
	public DepartamentoDominio() {
		setNombre(null);
		setPais(null);
	}
	
	public DepartamentoDominio(int codigo, String nombre, PaisDominio pais) {
		setCodigo(codigo);
		setNombre(nombre);
		setPais(pais);
	}

	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo de un departamento no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		String nombreTmp = StringUtils.trimToEmpty(nombre);
		if (nombreTmp.length() > 0 ) {
			if (nombreTmp.length() > 500 ) {
				throw FacturanetException.CREAR("El nombre del departamento no puede tener mas de 500 caracteres", CapaEnum.DOMINIO);
			}
			if (!nombreTmp.matches("^[a-zA-ZÒ—·¡È…ÌÕÛ”˙⁄ ]+$")) {
				throw FacturanetException.CREAR("El nombre del departamento ingresado no es valido", CapaEnum.DOMINIO);
			}
		}
		this.nombre = nombreTmp;
	}
	public void setPais(PaisDominio pais) {
		this.pais = ObjectUtils.defaultIfNull(pais, new PaisDominio());
	}
	
	
	

}
