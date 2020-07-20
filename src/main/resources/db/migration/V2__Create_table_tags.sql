CREATE TABLE IF NOT EXISTS tags (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  tool_id bigint(20) unsigned NOT NULL,
  PRIMARY KEY (id),
  KEY fk_tags_toolsTags (tool_id),
  CONSTRAINT fk_tags_tools FOREIGN KEY (tool_id) REFERENCES tools(id)
);