package com.nexusmart.nexusmart_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexusmart.nexusmart_backend.entity.Role;
import com.nexusmart.nexusmart_backend.entity.RoleType;

public interface RoleRepository  extends JpaRepository<Role,Long>{
     Optional<Role> findByName(RoleType name);
}
