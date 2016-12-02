/*==============================================================*/
/* CREATE TABLES                					            */
/*==============================================================*/

DROP SCHEMA IF EXISTS ONUZWEBSITE;
CREATE SCHEMA ONUZWEBSITE;

/*==============================================================*/
/* CREATE TABLE : USER              					        */
/*==============================================================*/

CREATE TABLE ONUZWEBSITE.USER(
    USER_ID 		INT(10) NOT NULL AUTO_INCREMENT ,
    FIRSTNAME		VARCHAR(50) NOT NULL,
    LASTNAME		VARCHAR(50) NOT NULL,
    USER_NAME 		VARCHAR(50) NOT NULL,
    USER_PASSWORD 	VARCHAR(50) NOT NULL,
    ABOUTME 		VARCHAR(750) NOT NULL,
    
    PRIMARY KEY  (USER_ID)
    );
    
 /*==============================================================*/
/* CREATE SAMPLE DATA	    					                */
/*==============================================================*/
  
 INSERT INTO ONUZWEBSITE.USER (FIRSTNAME, LASTNAME, USER_NAME, USER_PASSWORD) VALUES ('Tamer', 'Vural', 'onuz', '123');
 
 INSERT INTO `ONUZWEBSITE`.`MSUBJECT` (`MSUBJECT_NAME`, `MSUBJECT_CONTENT`) VALUES ('first sub', 'bu ilk konum. ');
INSERT INTO `ONUZWEBSITE`.`MSUBJECT` (`MSUBJECT_NAME`, `MSUBJECT_CONTENT`) VALUES ('second sub', 'bu da ikinci konum.');

   