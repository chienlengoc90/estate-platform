package com.estate.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estate.core.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code);
}
