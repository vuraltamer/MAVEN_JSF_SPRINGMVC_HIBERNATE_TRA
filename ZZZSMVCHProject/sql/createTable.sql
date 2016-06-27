/*==============================================================*/
/* CREATE TABLE                					                */
/*==============================================================*/
DROP SCHEMA IF EXISTS LOGIN;
CREATE SCHEMA LOGIN;

create table LOGIN.USER(

    ID 				int(10) primary key NOT NULL AUTO_INCREMENT,
    USERNAME 		varchar(50),
    PASSWORD 		varchar(50)
    );