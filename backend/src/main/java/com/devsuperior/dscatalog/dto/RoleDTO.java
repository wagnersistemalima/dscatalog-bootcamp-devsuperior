package com.devsuperior.dscatalog.dto;

import java.io.Serializable;

import com.devsuperior.dscatalog.entities.Role;

// objeto simples para trafegar dados entre a aplicação e o controller
// nao vai ser monitorado

public class RoleDTO implements Serializable{
	
	// para transformar o objeto em bytes
	
	private static final long serialVersionUID = 1L;
	// atributos basico
	
	private Long id;
	private String authority;
	
	// construtor default
	
	public RoleDTO() {
		
	}
	
	// construtor com argumentos

	public RoleDTO(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}

	// construtor personalizado recebendo uma entidade
	
	public RoleDTO(Role role) {
		this.id = role.getId();
		this.authority = role.getAuthority();
	}
	
	// Getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
		
}
