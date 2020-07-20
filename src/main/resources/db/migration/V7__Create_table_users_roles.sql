CREATE TABLE IF NOT EXISTS users_roles (
  id_user bigint(20) unsigned NOT NULL,
  id_role bigint(20) unsigned NOT NULL,
  PRIMARY KEY (id_user,id_role),
  KEY fk_usersRoles_rolesKey (id_role),
  CONSTRAINT fk_usersRoles_users FOREIGN KEY (id_user) REFERENCES users(id),
  CONSTRAINT fk_usersRoles_roles FOREIGN KEY (id_role) REFERENCES roles(id)
);