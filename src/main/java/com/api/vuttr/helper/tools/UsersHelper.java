package com.api.vuttr.helper.tools;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.api.vuttr.dto.UsersDTO;
import com.api.vuttr.entity.UsersEntity;

@Component
public class UsersHelper {

	private final ModelMapper modelMapper;

	public UsersHelper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public UsersDTO toModel(UsersEntity usersEntity) {
		return modelMapper.map(usersEntity, UsersDTO.class);
	}

	public UsersEntity toEntity(UsersDTO usersDTO) {
		return modelMapper.map(usersDTO, UsersEntity.class);
	}
}
