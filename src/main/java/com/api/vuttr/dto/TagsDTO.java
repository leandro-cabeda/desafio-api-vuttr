package com.api.vuttr.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

import io.swagger.annotations.*;
import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class that represents the model of the tags")
public class TagsDTO implements Serializable{
	private static final long serialVersionUID = 3247622434138265867L;

	@ApiModelProperty(notes = "Tag Id", name = "id", required = false, example = "1", position = 0)
	private Long id;
	
	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
	@ApiModelProperty(notes = "Tag name", name = "name", required = true, example = "Node", position = 1)
	private String name;
	
	@NotNull(message = "Tool cannot be null")
	@NotEmpty(message = "Tool cannot be empty")
	private ToolsDTO tool;
}
