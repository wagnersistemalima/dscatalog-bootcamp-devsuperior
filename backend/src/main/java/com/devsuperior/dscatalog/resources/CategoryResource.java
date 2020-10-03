package com.devsuperior.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") 
public class CategoryResource {
	// controladores Rest
	
	@Autowired
	private CategoryService service;
	
	// encapsular uma resposta http/ metodo para buscar todas as categorias
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {       
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// encapsular uma resposta http/ buscar uma categoria por id / 
	@GetMapping(value = "/{id}")                         
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {  
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	// encapsular uma resposta http/  inserir uma nova categoria / responder no cabeçario da resposta o recurso
	@PostMapping                          
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) { 
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	// encapsular uma resposta http/ atualizar um recurso /  responder no cabeçario da resposta o recurso
	@PutMapping(value = "/{id}")                           
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) { 
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
