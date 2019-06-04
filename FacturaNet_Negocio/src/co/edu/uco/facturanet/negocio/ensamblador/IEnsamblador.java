package co.edu.uco.facturanet.negocio.ensamblador;

public interface IEnsamblador<A, B> {
	A ensamblarDTO(B dominio);
	B ensamblarDominio(A dto);
}
