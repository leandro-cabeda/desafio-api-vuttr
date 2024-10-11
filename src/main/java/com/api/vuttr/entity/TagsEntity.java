package com.api.vuttr.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class TagsEntity implements Serializable {
	private static final long serialVersionUID = 7761119331759720880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "tool_id", nullable = false)
	private ToolsEntity tool;

	public TagsEntity(String name, ToolsEntity tool) {
		this.name = name;
		this.tool = tool;
	}
	
}
