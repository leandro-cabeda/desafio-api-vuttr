package com.api.vuttr.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.api.vuttr.entity.ToolsEntity;
import java.util.*;

@Repository
public interface ToolsRepository extends JpaRepository<ToolsEntity, Long> {

	List<ToolsEntity> findAll();

	@Query(value = "select t from ToolsEntity t join t.tagsObject tags where tags.name=?1")
	List<ToolsEntity> findAllToolsByTag(String tagName);
	
	ToolsEntity findByTitleOrLinkIgnoreCase(String title, String link);
}
