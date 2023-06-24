/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */ acessoapi /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE acessoapi;

DROP TABLE IF EXISTS forca;
CREATE TABLE `forca`
(
    `id`      bigint NOT NULL,
    `dica`    varchar(255) DEFAULT NULL,
    `palavra` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS hibernate_sequence;
CREATE TABLE `hibernate_sequence`
(
    `next_val` bigint DEFAULT NULL
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS role;
CREATE TABLE `role`
(
    `id`   bigint NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS user;
create table user
(
    id       bigint       not null
        primary key,
    ativo    bit          null,
    email    varchar(255) null,
    nome     varchar(255) null,
    senha    varchar(255) null,
    username varchar(255) null,
    role_id  bigint       not null
);

create index FKn82ha3ccdebhokx3a8fgdqeyy
    on user (role_id);

INSERT INTO forca(id, dica, palavra)
VALUES (52, 'veiculo moderno', 'carro'),
       (53, 'veiculo antigo', 'carroça'),
       (54, 'veiculo moderno', 'evtol');

INSERT INTO hibernate_sequence(next_val)
VALUES (66);

INSERT INTO role(id, name)
VALUES (1, 'ADMIN'),
       (62, 'CLIENTE'),
       (63, 'PLAYER'),
       (59, 'USER');

INSERT INTO user(id, ativo, email, nome, senha, username,role_id)
VALUES (2, 1, 'teste@teste.com', 'juliano', '$2a$10$2eVrW0Hu04B2yyQt2/gIk.s1D2asFcjJE3nMzn8Rw/9i5blgsx6wG',
        'julianoosmir',1);
