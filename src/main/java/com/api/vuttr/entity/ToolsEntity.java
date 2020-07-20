package com.api.vuttr.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tools")
public class ToolsEntity implements Serializable {
	private static final long serialVersionUID = -8041040602080993567L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String title;

	@Column(unique = true, nullable = false)
	private String link;

	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "tool", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<TagsEntity> tagsObject;
	
	@Transient
	private List<String> tags = new ArrayList<>();
}
