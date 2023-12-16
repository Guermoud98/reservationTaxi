USE reservationTaxi;

-- Client table

CREATE TABLE client (

 idClient int IDENTITY(1,1) PRIMARY KEY,
 nom VARCHAR(10),
 prenom VARCHAR(10),
 telephone VARCHAR(10),
 email VARCHAR(40)

);

DROP TABLE client;

--Taxi
CREATE TABLE taxi (

 matricule VARCHAR(10) PRIMARY KEY,
 modele VARCHAR(10),
 status VARCHAR(10)

);
DROP TABLE taxi;
--Conducteur

CREATE TABLE conducteur (

 idConducteur int IDENTITY(1,1) PRIMARY KEY ,
 nom VARCHAR(10),
 prenom VARCHAR(10),
 telephone VARCHAR(10),
 email VARCHAR(40),
 matricule VARCHAR(10) FOREIGN KEY REFERENCES taxi(matricule)

);
DROP TABLE conducteur;

--Reservation

CREATE TABLE reservation (

 idReservation int IDENTITY(1,1) PRIMARY KEY,
 lieuSource VARCHAR(15),
 lieuDestination VARCHAR(15),
 typePaiement VARCHAR(15),
 tarif FLOAT,
 date DATE,
 heure TIME,
 idClient INT FOREIGN KEY REFERENCES client(idClient),
 idConduteur INT FOREIGN KEY REFERENCES conducteur(idConducteur),
 matricule  VARCHAR(10) FOREIGN KEY REFERENCES taxi(matricule)

);
SELECT * FROM reservation;
DROP TABLE reservation;