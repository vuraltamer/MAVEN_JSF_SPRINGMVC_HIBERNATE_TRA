/*==============================================================*/
/* CREATE SCHEMA AV					                            */
/*==============================================================*/
DROP SCHEMA IF EXISTS AV;
CREATE SCHEMA AV;

/*==============================================================*/
/* Table: KATEGORI                                                */
/*==============================================================*/
CREATE TABLE AV.KATEGORI (
    KATEGORI_ID 				BIGINT(10) NOT NULL AUTO_INCREMENT,
    KATEGORI_AD					VARCHAR(50) NULL DEFAULT NULL,
    
	PRIMARY KEY (KATEGORI_ID)
);

/*==============================================================*/
/* Table: URUN                                         */
/*==============================================================*/
CREATE TABLE AV.URUN (
	URUN_ID						BIGINT(20) NOT NULL AUTO_INCREMENT,
    URUN_AD 					VARCHAR(50),
    URUN_FIYAT		 			VARCHAR(50),
    URUN_MARKA 					VARCHAR(50),
	URUN_STOK					INT,
	KATEGORI_ID					BIGINT(10),

	PRIMARY KEY (URUN_ID),
    CONSTRAINT FKOTM_KATEGORI_URUN FOREIGN KEY (KATEGORI_ID) REFERENCES KATEGORI (KATEGORI_ID)
);

/*==============================================================*/
/* Table: USER                                                */
/*==============================================================*/
CREATE TABLE AV.USERS (
    USER_ID 				BIGINT(10) NOT NULL AUTO_INCREMENT,
    USER_AD					VARCHAR(50) NULL DEFAULT NULL,
    USER_SOYAD				VARCHAR(50) NULL DEFAULT NULL,
    USERNAME				VARCHAR(50) NULL DEFAULT NULL,
    PAROLA					VARCHAR(50) NULL DEFAULT NULL,
    
	PRIMARY KEY (USER_ID)
);

/*==============================================================*/
/* Table: SIPARIS                                                */
/*==============================================================*/
CREATE TABLE AV.SIPARIS (
    SIPARIS_ID 				BIGINT(10) NOT NULL AUTO_INCREMENT,
	
	URUN_ID BIGINT(20),
	USER_ID BIGINT(20),
    
	PRIMARY KEY (SIPARIS_ID),
	CONSTRAINT FKOTM_USER_SIPARIS FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID)
);

/*==============================================================*/
/* Table: ADRES                                                */
/*==============================================================*/
CREATE TABLE AV.ADRES (
    ADRES_ID 				BIGINT(10) NOT NULL AUTO_INCREMENT,
    ADRES					VARCHAR(100) NULL DEFAULT NULL,
	
	USER_ID BIGINT(20),
    
	PRIMARY KEY (SIPARIS_ID),
	CONSTRAINT FKOTM_USER_ADRES FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID),
    CONSTRAINT FKOTO_ADRES_SIPARIS FOREIGN KEY (PERSON_ID) REFERENCES PERSON (PERSON_ID)
);


/*==============================================================*/
/* INSERT SAMPLE DATA                                           */
/*==============================================================*/

INSERT INTO AV.KATEGORI (KATEGORI_AD) VALUES ('giyim');
INSERT INTO AV.KATEGORI (KATEGORI_AD) VALUES ('telefon');
INSERT INTO AV.KATEGORI (KATEGORI_AD) VALUES ('kitap');
INSERT INTO AV.KATEGORI (KATEGORI_AD) VALUES ('bilgisayar');

INSERT INTO AV.URUN (`URUN_AD`, `URUN_FIYAT`, `URUN_STOK`, `KATEGORI_ID`) VALUES ('CCC Kitap', '25', '15', (SELECT KATEGORI_ID FROM AV.KATEGORI WHERE KATEGORI_AD='kitap'));


