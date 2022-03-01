package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.birt.dam.domain.Producto;
import eus.birt.dam.repository.ProductoRepository;


@Controller
public class ProductoController {

  @Autowired private ProductoRepository productoRepository;

  @GetMapping("/productos")
  public String getProductos(Model model) {

    model.addAttribute("productos", productoRepository.findAll());

    return "productos/list";
  }
  @GetMapping("/productos/new")
	public String initCreationForm(Model model) {
		// formularios
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "productos/productoForm";
	}
  


	@PostMapping("productos/new/submit")
	public String submitCreationForm(@ModelAttribute Producto producto) {
		
		productoRepository.save(producto);
		return "redirect:/productos";
		
	}
	
	@GetMapping("productos/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("producto", productoRepository.findById(id));
		return "productos/productoForm";
	}
	
	@GetMapping ("productos/delete/{id}")
	public String initDelete(@PathVariable("id") int id) {
		
		productoRepository.deleteById(id);
		return "redirect:/productos";

	}
}
