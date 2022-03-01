package eus.birt.dam.bootstrap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Categoria;
import eus.birt.dam.domain.Producto;
import eus.birt.dam.repository.CategoriaRepository;
import eus.birt.dam.repository.ProductoRepository;


@Component
public class BootStrapData implements CommandLineRunner {


	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	@Override
	public void run(String... arg0) throws Exception {

		Producto producto1 = new Producto("Iphone 13 Pro", "146,7x71,5x7,65 mm 204 gramos", "1000 €");
		Producto producto2 = new Producto("Iphone 12", "137,7x61,5x5,55 mm 187 gramos", "890 €");
		Producto producto3 = new Producto("P30 lite", "107,2x61,4x5,63 mm 188 gramos", "120 €");
		Producto producto4 = new Producto("P30 Pro", "107,2x61,4x5,63 mm 188 gramos", "75 €");
		Categoria categoria1 = new Categoria("Apple");
		Categoria categoria2 = new Categoria("Huawei");

		producto1.setCategoria(categoria1);
		producto2.setCategoria(categoria1);
		producto3.setCategoria(categoria2);
		producto4.setCategoria(categoria2);
		categoria1.getProductos().add(producto1);
		categoria1.getProductos().add(producto2);
		categoria2.getProductos().add(producto3);
		categoria2.getProductos().add(producto4);

		categoriaRepository.save(categoria1);
		categoriaRepository.save(categoria2);
		productoRepository.save(producto1);
		productoRepository.save(producto2);

	}
}
