-- cree la base de donne
create database product_management_db;

-- se connecter au database
\c product_management_db
-- cree l'User
create user "product_manager_user" with password '123456';

-- Privileges sur la base de donne
GRANT connect on database product_management_db to product_manager_user;

-- Privileges sur le schema public
grant usage on schema public to product_manager_user;

-- permettre la creation des tables
grant create on schema public to product_manager_user;

-- donner les droit CRUD sur tous les tables
grant select , insert , update , delete on all tables in schema public to product_manager_user;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE product_category TO product_manager_user;


select * from product;

SELECT current_database();





