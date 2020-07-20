package com.api.vuttr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.vuttr.entity.UsersEntity;

@Repository
@Transactional()
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	@Transactional(readOnly = true)
	UsersEntity findByUserNameOrEmailIgnoreCase(String userName, String email);

	@Transactional(readOnly = true)
	UsersEntity findByUserNameIgnoreCase(String userName);
}
