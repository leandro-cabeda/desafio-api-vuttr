package com.api.vuttr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vuttr.entity.RolesEntity;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {

}
