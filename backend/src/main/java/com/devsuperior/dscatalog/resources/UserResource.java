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

import com.devsuperior.dscatalog.dto.UserDTO;
import com.devsuperior.dscatalog.dto.UserInsertDTO;
import com.devsuperior.dscatalog.dto.UserUpdateDTO;
import com.devsuperior.dscatalog.services.UserService;

@RestController
@RequestMapping(value = "/users") 
public class UserResource {
	// controladores Rest
	
	// injeção de dependencia para a camada de serviço
	
	@Autowired
	private UserService service;
	
	// metodo para buscar todos os usuarios paginado/ resposta 200 ok
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "firstName") String orderBy
			) { 
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<UserDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	// metodo para buscar usuario por id / resposta 200 ok 
	@GetMapping(value = "/{id}")                         
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {  
		UserDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	// metodo para inserir uma novo usuario / resposta 201 created
	@PostMapping                          
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) { 
		UserDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	// metodo para atualizar um usuario /  resposta 200 ok
	@PutMapping(value = "/{id}")                           
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) { 
		UserDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}
	
	// metodo para deletar um produto / resposta 204 No content
	@DeleteMapping(value = "/{id}")                           
	public ResponseEntity<UserDTO> delete(@PathVariable Long id) { 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
