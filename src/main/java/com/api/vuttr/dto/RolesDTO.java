package com.api.vuttr.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.*;
import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class that represents the roles")
public class RolesDTO implements Serializable {
	private static final long serialVersionUID = 619986737719931545L;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(notes = "Role Id", name = "id", required = false, example = "1")
	private Long id;

	@ApiModelProperty(notes = "Role description", name = "description", required = true, example = "ADMIN")
	@NotNull(message = "Description cannot be null")
	@NotEmpty(message = "Description cannot be empty")
	private String description;
}
