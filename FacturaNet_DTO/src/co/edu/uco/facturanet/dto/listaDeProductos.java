package co.edu.uco.facturanet.dto;

import java.util.ArrayList;
import java.util.List;

public class listaDeProductos {
	
	public List<ProductoDTO> getListaDeProductos() {
		
		List<ProductoDTO> listaProductos = new ArrayList<>();
		
		listaProductos.add(new ProductoDTO(1,"PC",2000000));
		listaProductos.add(new ProductoDTO(2,"Auto",15000000));
		listaProductos.add(new ProductoDTO(3,"Bicicleta",500000));
		listaProductos.add(new ProductoDTO(4,"TV",1500000));
		listaProductos.add(new ProductoDTO(5,"Cama",1000000));
		
		return listaProductos;
	}

}
