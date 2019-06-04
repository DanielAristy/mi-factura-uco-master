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
import javax.persistence.Table;

@Data
@Entity
@Table(name= "FAC_PRODUCTO_TBL", schema = "dbo")
public class ProductoDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", nullable = false)
	private int codigo;
	
	@Column(name = "NV_NOMBRE", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "NU_VALOR", nullable = false)
	private double valor;
	
	public ProductoDominio() {
		
	}
	
	public ProductoDominio(int codigo, String nombre, double valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public void setCodigo(int codigo) {
		
		if (codigo < 0) {
				throw FacturanetException.CREAR("El codigo de un producto no puede ser menor que 0", CapaEnum.DOMINIO);
			}
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		String nombreTmp = StringUtils.trimToEmpty(nombre);
		if (nombreTmp.length() > 0 ) {
			if (nombreTmp.length() > 50 ) {
				throw FacturanetException.CREAR("El nombre del producto no puede tener mas de 50 caracteres", CapaEnum.DOMINIO);
			}
			if (nombreTmp.matches("^[a-zA-Z0-9Ò—·¡È…ÌÕÛ”˙⁄ ]+$")) {
				throw FacturanetException.CREAR("El nombre del producto ingresado no es valido", CapaEnum.DOMINIO);
			}
		}
		this.nombre = nombreTmp;
	}
	public void setValor(double valor) {
		if (valor < 0 ) {
			throw FacturanetException.CREAR("El valor no puede ser menor a 0", CapaEnum.DOMINIO);
		}
		this.valor = valor;
	}


}
