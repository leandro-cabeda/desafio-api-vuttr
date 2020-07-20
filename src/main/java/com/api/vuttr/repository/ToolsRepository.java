package com.api.vuttr.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.vuttr.entity.ToolsEntity;
import java.util.*;

@Repository
@Transactional()
public interface ToolsRepository extends JpaRepository<ToolsEntity, Long> {

	@Transactional(readOnly = true)
	List<ToolsEntity> findAll();

	@Transactional(readOnly = true)
	@Query(value = "select t from ToolsEntity t join t.tagsObject tags where tags.name=?1")
	List<ToolsEntity> findAllToolsByTag(String tagName);
	
	@Transactional(readOnly = true)
	ToolsEntity findByTitleOrLinkIgnoreCase(String title, String link);
}
