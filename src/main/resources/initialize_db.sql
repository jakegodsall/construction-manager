DROP DATABASE IF EXISTS construction_db;
DROP USER IF EXISTS `construction_user`@`localhost`;
CREATE DATABASE construction_db;
CREATE USER `construction_user`@`localhost` IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON construction_db.* TO `construction_user`@`localhost`;
FLUSH PRIVILEGES;