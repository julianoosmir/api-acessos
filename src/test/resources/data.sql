

INSERT INTO role(id,name) VALUES(1,'ADMIN'),(62,'CLIENTE'),(63,'PLAYER'),(59,'USER');

INSERT INTO user(id,ativo,email,nome,senha,username) VALUES(2,1,'teste@teste.com','juliano','$2a$10$2eVrW0Hu04B2yyQt2/gIk.s1D2asFcjJE3nMzn8Rw/9i5blgsx6wG','julianoosmir');

DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
                            user_id bigint NOT NULL,
                            roles_id bigint NOT NULL,
                            foreign key (roles_id) references role(id),
                            foreign key(user_id) references user(id)
);

INSERT INTO user_roles(user_id,roles_id) VALUES(2,1);