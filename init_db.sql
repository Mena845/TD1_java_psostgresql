-- 1 - creation du database
create database product_management_db ;

-- 2 - creation de l'user
create user "product_manager_user" with password '123456';

-- 3 - Donner les privileges sur la base de donnees
GRANT connect on database product_management_db to product_manager_user;

--  4 - Donner les privileges sur le schema public
grant usage on schema public to product_manager_user;

-- 5 - Permettre la creation des tables
alter default privileges in schema public grant create on tables to product_manager_user;

--  6 - Donner les droits CRUD sur toutes les tables dans le schema public
grant  select , insert , update , delete on all tables in schema public to product_manager_user;

-- 7 - Donner les droits CRUD sur les futurs tables du schema
alter default privileges in schema public grant select  , insert , update , delete on tables to product_manager_user;