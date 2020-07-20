package com.api.vuttr.helper.tools;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.api.vuttr.dto.ToolsDTO;
import com.api.vuttr.entity.ToolsEntity;

import java.util.*;
import static java.util.stream.Collectors.*;

@Component
public class ToolsHelper {

	private final ModelMapper modelMapper;

	public ToolsHelper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public ToolsDTO toModel(ToolsEntity toolsEntity) {
		return modelMapper.map(toolsEntity, ToolsDTO.class);
	}
	
	public ToolsEntity toEntity(ToolsDTO toolsDTO) {
		return modelMapper.map(toolsDTO, ToolsEntity.class);
	}
	
	public List<ToolsDTO> toModel(List<ToolsEntity> toolsEntities){
		return toolsEntities.stream().map(this::toModel).collect(toList());
	}
}
