CREATE TABLE IF NOT EXISTS users (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  user_name varchar(100) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_users (email,user_name)
);