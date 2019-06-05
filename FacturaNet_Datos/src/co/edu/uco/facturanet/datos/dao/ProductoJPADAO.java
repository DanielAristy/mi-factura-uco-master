package co.edu.uco.facturanet.datos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.facturanet.dominio.ProductoDominio;

@Repository
public interface ProductoJPADAO extends JpaRepository<ProductoDominio, Integer> {
	
	

}
