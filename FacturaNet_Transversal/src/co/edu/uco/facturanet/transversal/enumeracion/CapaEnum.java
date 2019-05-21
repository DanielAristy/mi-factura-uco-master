package co.edu.uco.facturanet.transversal.enumeracion;

public enum CapaEnum {

	DATOS ("DATOS", "Capa de Datos de la aplicación"),
	DOMINIO ("DOMINIO", "Capa de Dominio de la aplicación"), 
	NEGOCIO ("NEGOCIO", "Capa de Negocio de la aplicación"), 
	FACHADA ("FACHADA", "Capa de Fachada de la aplicación"), 
	API ("API", "Capa Api de la aplicación"), 
	DTO ("DTO", "Capa DTO de la aplicación"), 
	TRANSVERSAL ("TRANSVERSAL", "Capa Transversal de la aplicación"), 
	BACKEND ("BACKEND", "Capa BACKEND de la aplicación");
	
	private String codigo;
	private String descripcion;
	
	private CapaEnum(String codigo, String descripcion) {
		setCodigo(codigo);
		setDescripcion(descripcion);
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
