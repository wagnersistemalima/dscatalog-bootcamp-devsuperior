package com.devsuperior.dscatalog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	
	// SerialIzable para o objeto ser transformado em bytes
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt; // atributo para armezenar o instante que o registro foi criado pela primeira vez
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateddAt; // atributo para armezenar o instante que o registro foi atualizado
	
	// associação bi direcional / uma categoria contem varios produtos / um para muitos
	
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	
	// construtor default
	
	public Category() {
		
	}
	
	// construtor com argumento

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Getters $ setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdateddAt() {
		return updateddAt;
	}
	
	
	public Set<Product> getProducts() {
		return products;
	}

	//metodo auxiliar para sempre que for salvar uma categoria, o metodo armazana no createdAt o instante atual
	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();	
	}
	
	// metodo auxiliar para sempre que for atualizar, o metodo armazena no updatedAt o instante atual
	@PreUpdate
	public void preUpdate() {
		updateddAt = Instant.now();
	}
	
	// HashCode & equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	 

}
