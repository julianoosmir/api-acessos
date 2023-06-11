/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
-- CREATE DATABASE /*!32312 IF NOT EXISTS*/ acessoapi /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE acessoapi;

DROP TABLE IF EXISTS forca;
CREATE TABLE `forca` (
  `id` bigint NOT NULL,
  `dica` varchar(255) DEFAULT NULL,
  `palavra` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS hibernate_sequence;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS role;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS user;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `ativo` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS user_roles;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO forca(id,dica,palavra) VALUES(52,'veiculo moderno','carro'),(53,'veiculo antigo','carroça'),(54,'veiculo moderno','evtol');

INSERT INTO hibernate_sequence(next_val) VALUES(66);

INSERT INTO role(id,name) VALUES(1,'ADMIN'),(62,'CLIENTE'),(63,'PLAYER'),(59,'USER');

INSERT INTO user(id,ativo,email,nome,senha,username) VALUES(2,1,'teste@teste.com','juliano','$2a$10$2eVrW0Hu04B2yyQt2/gIk.s1D2asFcjJE3nMzn8Rw/9i5blgsx6wG','julianoosmir'),(64,1,'jogador@email.com','jogador 3','$2a$10$h4Q.b45vj22Z8MlziDI18.IGGDsdP5F/aJdKTQ42Wc4GUPjVmUQu2','player 3');
INSERT INTO user_roles(user_id,roles_id) VALUES(2,1),(4,3),(6,5),(8,7),(10,9),(12,11),(14,13),(18,17),(64,63);