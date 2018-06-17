--psql -U postgres:	access root account postgres
CREATE USER estate WITH PASSWORD '123456';
CREATE DATABASE estate OWNER estate ENCODING = 'UTF8';
--psql -U estate -d estate (pass: 123456)
CREATE SCHEMA estate;