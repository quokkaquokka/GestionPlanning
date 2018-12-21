#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: RESPONSABLE
#------------------------------------------------------------

CREATE TABLE RESPONSABLE(
idResponsable Int NOT NULL ,
nomResp       Varchar (50) NOT NULL ,
prenomResp    Varchar (50) NOT NULL ,
telResp       Varchar NOT NULL ,
emailResp     Varchar (50) NOT NULL ,
matricule     Int NOT NULL
,CONSTRAINT RESPONSABLE_PK PRIMARY KEY (idResponsable)
,CONSTRAINT UTILISATEUR_PK FOREIGN KEY (matricule) REFERENCES UTILISATEUR(matricule)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: GROUPE
#------------------------------------------------------------

CREATE TABLE GROUPE(
idGroupe    Int NOT NULL ,
nom         Varchar (50) NOT NULL ,
promotion   Varchar (50) NOT NULL ,
type        Varchar (50) NOT NULL ,
nbEleves    Int NOT NULL
,CONSTRAINT GROUPE_PK PRIMARY KEY (idGroupe)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: UTILISATEUR
#------------------------------------------------------------

CREATE TABLE UTILISATEUR(
matricule       Int NOT NULL ,
nom             Varchar (50) NOT NULL ,
prenom          Varchar (50) NOT NULL ,
mdp             Varchar (50) NOT NULL ,
login           Varchar (50) NOT NULL ,
role            Varchar (50) NOT NULL ,
datenaissance   Datetime ,
villenaissance  Varchar (50) ,
paysnaissance   Varchar (50) ,
sexe            Char (1) ,
dateinscription Datetime ,
etabPrecedent   Varchar (50)  ,
teldomicile     Varchar (10)  ,
telmobile       Varchar (10)  ,
email           Varchar (50)  ,
photo           Varchar (50)  ,
rue             Varchar (100) ,
codePostal      Varchar (5)   ,
ville           Varchar (50) ,
idGroupe        Int
,CONSTRAINT UTILISATEUR_PK PRIMARY KEY (matricule)

,CONSTRAINT UTILISATEUR_GROUPE_FK FOREIGN KEY (idGroupe) REFERENCES GROUPE(idGroupe)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: SALLE
#------------------------------------------------------------

CREATE TABLE SALLE(
idSalle   Int NOT NULL ,
nom       Varchar (50) NOT NULL ,
nbPlaces  Int NOT NULL ,
typeSalle Varchar (50) NOT NULL
,CONSTRAINT SALLE_PK PRIMARY KEY (idSalle)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: COURS
#------------------------------------------------------------

CREATE TABLE COURS(
idCours    Int NOT NULL ,
nom        Varchar (50) NOT NULL ,
dateDebut  Datetime NOT NULL ,
dateFin    Datetime NOT NULL ,
idSalle    Int NOT NULL ,
matricule  Int NOT NULL ,
idGroupe   Int NOT NULL,
numSemaine Int NOT NULL
,CONSTRAINT COURS_PK PRIMARY KEY (idCours)

,CONSTRAINT COURS_SALLE_FK FOREIGN KEY (idSalle) REFERENCES SALLE(idSalle)
,CONSTRAINT COURS_UTILISATEUR0_FK FOREIGN KEY (matricule) REFERENCES UTILISATEUR(matricule)
)ENGINE=InnoDB;


