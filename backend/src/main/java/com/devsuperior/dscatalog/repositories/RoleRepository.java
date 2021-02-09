package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Role;

// camada de acesso a dados role

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
