package com.devsuperior.dscatalog.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.services.ProductService;

@RestController
@RequestMapping(value = "/products") 
public class ProductResource {
	// controladores Rest
	
	// injeção de dependencia para a camada de serviço
	
	@Autowired
	private ProductService service;
	
	// metodo para buscar todos os produtos paginado/ resposta 200 ok
	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			) { 
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<ProductDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	// metodo para buscar produto por id / resposta 200 ok 
	@GetMapping(value = "/{id}")                         
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {  
		ProductDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	// metodo para inserir uma novo produto / resposta 201 created
	@PostMapping                          
	public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) { 
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	// metodo para atualizar um produto /  resposta 200 ok
	@PutMapping(value = "/{id}")                           
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) { 
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	// metodo para deletar um produto / resposta 204 No content
	@DeleteMapping(value = "/{id}")                           
	public ResponseEntity<ProductDTO> delete(@PathVariable Long id) { 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
