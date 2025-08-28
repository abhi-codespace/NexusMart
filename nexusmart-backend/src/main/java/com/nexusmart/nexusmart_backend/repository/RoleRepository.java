package com.nexusmart.nexusmart_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexusmart.nexusmart_backend.entity.Role;

public interface RoleRepository  extends JpaRepository<Role,Long>{
    
}
