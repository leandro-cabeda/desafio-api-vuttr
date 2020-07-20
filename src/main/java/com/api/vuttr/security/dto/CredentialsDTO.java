package com.api.vuttr.security.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

import io.swagger.annotations.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing the user's credentials to authenticate to the system")
public class CredentialsDTO implements Serializable {
	private static final long serialVersionUID = -6605652716353887238L;

	@NotEmpty(message = "Username cannot be empty")
	@NotNull(message = "Username cannot be null")
	@ApiModelProperty(notes = "User username", name = "username", required = true, example = "admin")
	private String username;

	@NotEmpty(message = "Password cannot be empty")
	@NotNull(message = "Password cannot be null")
	@ApiModelProperty(notes = "User password", name = "password", required = true, example = "123@45")
	private String password;
}
