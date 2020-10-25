-- Cleanup
DROP DATABASE IF EXISTS petstoreDB;
CREATE DATABASE petstoreDB;
USE petstoreDB;

-- Create
CREATE TABLE T_CUSTOMER( id VARCHAR(10), PRIMARY KEY(id), firstname VARCHAR(50) NOT NULL, lastname VARCHAR(50) NOT NULL, telephone VARCHAR(10), street1 VARCHAR(50), street2 VARCHAR(50), city VARCHAR(25), state VARCHAR(25), zipcode VARCHAR(10), country VARCHAR(25)) ENGINE=INNODB;
CREATE TABLE T_CATEGORY( id VARCHAR(10), PRIMARY KEY(id), name VARCHAR(50) NOT NULL, description VARCHAR(255) NOT NULL) ENGINE=INNODB ;
CREATE TABLE T_PRODUCT( id VARCHAR(10), PRIMARY KEY(id), name VARCHAR(50) NOT NULL, description VARCHAR(255) NOT NULL, category_fk VARCHAR(10) NOT NULL, INDEX category_fk_ind (category_fk), FOREIGN KEY (category_fk) REFERENCES T_CATEGORY(id) ON DELETE CASCADE) ENGINE=INNODB;
CREATE TABLE T_ITEM( id VARCHAR(10), PRIMARY KEY(id), name VARCHAR(50) NOT NULL, unitCost DOUBLE NOT NULL, product_fk VARCHAR(10) NOT NULL, INDEX product_fk_ind (product_fk), FOREIGN KEY (product_fk) REFERENCES T_PRODUCT(id) ON DELETE CASCADE) ENGINE=INNODB;
