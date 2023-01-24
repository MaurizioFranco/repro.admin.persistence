
drop database IF EXISTS  academyfs07_dev;
create database academyfs07_dev;
CREATE USER 'acfs07_dev'@'%' IDENTIFIED BY 'acfs07_dev';
GRANT ALL PRIVILEGES ON academyfs07_dev.* TO 'acfs07_dev'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

drop database IF EXISTS  academyfs07_test;
create database academyfs07_test;
CREATE USER 'acfs07_test'@'%' IDENTIFIED BY 'acfs07_test';
GRANT ALL PRIVILEGES ON academyfs07_dev.* TO 'acfs07_test'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
