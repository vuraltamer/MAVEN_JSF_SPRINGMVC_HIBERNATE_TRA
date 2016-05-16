/*==============================================================*/
/* CREATE ONE TO ONE TABLE EXAMPLE                              */
/*==============================================================*/
DROP SCHEMA IF EXISTS LIBRARY;
CREATE SCHEMA LIBRARY;

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
CREATE TABLE LIBRARY.AUTHOR (
    AUTHOR_ID 					BIGINT(10) NOT NULL AUTO_INCREMENT,
    AUTHOR_NAME				VARCHAR(50) NULL DEFAULT NULL,
    AUTHOR_SURNAME				VARCHAR(50) NULL DEFAULT NULL,
    
	PRIMARY KEY (AUTHOR_ID)
);

/*==============================================================*/
/* Table: PERSON_DETAIL                                         */
/*==============================================================*/
CREATE TABLE LIBRARY.BOOK (
	BOOK_ID						BIGINT(20) NOT NULL AUTO_INCREMENT,
    BOOK_NAME 					VARCHAR(50),
	AUTHOR_ID					BIGINT(10),

	PRIMARY KEY (BOOK_ID),
    CONSTRAINT FKOTMSDRECORDTOPERSON FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (AUTHOR_ID)
);