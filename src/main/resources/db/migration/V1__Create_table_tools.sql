CREATE TABLE IF NOT EXISTS tools (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(100) NOT NULL,
  link varchar(255) NOT NULL,
  description text NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_tools (title,link)
);