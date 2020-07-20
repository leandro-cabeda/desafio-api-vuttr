package com.api.vuttr.dto;

import java.io.Serializable;
import java.util.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.*;

import io.swagger.annotations.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class that represents the users")
public class UsersDTO implements Serializable {
	private static final long serialVersionUID = -7979421758862621978L;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(notes = "User Id", name = "id", required = false, example = "1")
	private Long id;

	@ApiModelProperty(notes = "User email", name = "email", required = true, example = "admin@hotmail.com")
	@NotNull(message = "Email cannot be null")
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email")
	private String email;

	@NotNull(message = "Username cannot be null")
	@NotEmpty(message = "Username cannot be empty")
	@ApiModelProperty(notes = "User username", name = "userName", required = true, example = "admin")
	private String userName;

	@NotNull(message = "Password cannot be null")
	@NotEmpty(message = "Password cannot be empty")
	@ApiModelProperty(notes = "User password", name = "password", required = true, example = "123@45")
	@JsonIgnore
	private String password;

	@ApiModelProperty(notes = "List of user roles", name = "roles", required = false, example = "ADMIN, USER")
	private List<RolesDTO> roles;

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (RolesDTO role : this.roles) {
			roles.add(role.getDescription());
		}
		return roles;
	}
}
