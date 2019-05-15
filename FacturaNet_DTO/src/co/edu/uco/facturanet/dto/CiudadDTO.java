package co.edu.uco.facturanet.dto;

public class CiudadDTO {
	private int codigo;
	private String nombre;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		if (nombre == null) {
			setNombre("");
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
