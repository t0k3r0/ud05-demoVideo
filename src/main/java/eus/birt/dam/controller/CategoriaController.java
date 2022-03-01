package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.birt.dam.domain.Categoria;
import eus.birt.dam.repository.CategoriaRepository;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("/categorias")
	public String getCategorias(Model model) {

		model.addAttribute("categorias", categoriaRepository.findAll());

		return "categorias/list";
	}

	@GetMapping("/categorias/new")
	public String initCreationForm(Model model) {
		// formularios
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "categorias/categoriaForm";
	}

	@PostMapping("categorias/new/submit")
	public String submitCreationForm(@ModelAttribute Categoria categoria) {

		categoriaRepository.save(categoria);
		return "redirect:/categorias";

	}

	@GetMapping("categorias/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("categoria", categoriaRepository.findById(id));
		return "categorias/categoriaForm";
	}

	@GetMapping("categorias/delete/{id}")
	public String initDelete(@PathVariable("id") int id) {

		categoriaRepository.deleteById(id);
		return "redirect:/categorias";

	}
}
