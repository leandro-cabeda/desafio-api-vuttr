CREATE TABLE IF NOT EXISTS roles (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  description varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_roles (description)
);