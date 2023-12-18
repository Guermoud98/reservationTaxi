USE reservationTaxi;

-- Client table

CREATE TABLE client (

 idClient int IDENTITY(1,1) PRIMARY KEY,
 nom VARCHAR(10),
 prenom VARCHAR(10),
 telephone VARCHAR(10),
 email VARCHAR(40)

);
SELECT * FROM client;
DROP TABLE client;
DELETE FROM client WHERE idClient = 2;

--Taxi
CREATE TABLE taxi (

 matricule VARCHAR(10) PRIMARY KEY,
 modele VARCHAR(10),
 status VARCHAR(10)

);
SELECT * FROM taxi;
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
SELECT * FROM conducteur;
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
 idConducteur INT FOREIGN KEY REFERENCES conducteur(idConducteur),
 matricule  VARCHAR(10) FOREIGN KEY REFERENCES taxi(matricule)

);
SELECT * FROM reservation;
DROP TABLE reservation;




--- insertion ---
-- Insertion dans la table client
INSERT INTO client (nom, prenom, telephone, email) VALUES ('NomClient', 'PrenomCl', '123456789', 'client@example.com');

-- Insertion dans la table taxi
INSERT INTO taxi (matricule, modele, status) VALUES ('ABC123', 'ModeleTaxi', 'Disponible');

-- Insertion dans la table conducteur
INSERT INTO conducteur (nom, prenom, telephone, email, matricule) VALUES ('NomConduc', 'PrenomCond', '987654321', 'conducteur@example.com', 'ABC123');

-- Insertion dans la table reservation
INSERT INTO reservation (lieuSource, lieuDestination, typePaiement, tarif, date, heure, idClient, idConducteur, matricule)
VALUES ('Mhamid', 'Gueliz', 'CarteBancaire', 50.0, '2023-01-01', '12:00:00', 1, 1, 'ABC123');
