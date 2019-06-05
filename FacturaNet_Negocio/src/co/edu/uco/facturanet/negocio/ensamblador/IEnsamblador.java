package co.edu.uco.facturanet.negocio.ensamblador;

import java.util.List;

public interface IEnsamblador<A, B> {
	A ensamblarDTO(B dominio);
	B ensamblarDominio(A dto);
	
	List<B> ensamblarListaDominios(List<A> listaDTOs);

	List<A> ensamblarListaDTOs(List<B> listaDominios);

}
