package com.api.vuttr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vuttr.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	UsersEntity findByUserNameOrEmailIgnoreCase(String userName, String email);

	UsersEntity findByUserNameIgnoreCase(String userName);
}
