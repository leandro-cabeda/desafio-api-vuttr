package com.api.vuttr.dto;

import java.io.Serializable;
import java.util.*;

import javax.validation.constraints.*;

import io.swagger.annotations.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class that represents the model of the tools")
public class ToolsDTO implements Serializable {
	private static final long serialVersionUID = 7464128111403246540L;

	@ApiModelProperty(notes = "Tool Id", name = "id", required = false, example = "1", position = 0)
	private Long id;

	@NotNull(message = "Title cannot be null")
	@NotEmpty(message = "Title cannot be empty")
	@ApiModelProperty(notes = "Tool title", name = "title", required = true, example = "Notion", position = 1)
	private String title;

	@NotNull(message = "Link cannot be null")
	@NotEmpty(message = "Link cannot be empty")
	@ApiModelProperty(notes = "Tool link", name = "link", required = true, example = "https://notion.so", position = 2)
	private String link;

	@NotNull(message = "Description cannot be null")
	@NotEmpty(message = "Description cannot be empty")
	@ApiModelProperty(notes = "Tool description", name = "description", required = true, example = "All in one tool to organize teams and ideas.", position = 3)
	private String description;

	@NotNull(message = "Tags cannot be null")
	@NotEmpty(message = "Tags cannot be empty")
	@ApiModelProperty(notes = "List of tool tags", name = "tags", required = true, example = "Node, Json, Web", position = 4)
	private List<String> tags = new ArrayList<>();
}
