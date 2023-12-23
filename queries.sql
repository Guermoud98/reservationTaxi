USE reservationTaxi;

-- Client table

CREATE TABLE client (

 idClient int IDENTITY(1,1) PRIMARY KEY,
 nom VARCHAR(10),
 prenom VARCHAR(10),
 telephone VARCHAR(10),
 email VARCHAR(40),
 password VARCHAR(15)

);
SELECT * FROM client;
DROP TABLE client;
DELETE FROM client WHERE idClient = 11;
DELETE FROM client WHERE idClient = 15;

--Taxi
CREATE TABLE taxi (

 matricule VARCHAR(10) PRIMARY KEY,
 modele VARCHAR(10),
 status VARCHAR(10)

);
SELECT * FROM taxi;
DROP TABLE taxi;
UPDATE taxi set status = 'Occupe' WHERE matricule= 'ABC123';
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
ALTER TABLE conducteur ADD password VARCHAR(15);

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
INSERT INTO client (nom, prenom, telephone, email, password) VALUES ('Guer', 'Maria', '123456789', 'maria.guer@gmail.com', 'M123@');

-- Insertion dans la table taxi
INSERT INTO taxi (matricule, modele, status) VALUES ('ABC123', 'Dacia', 'Disponible');
INSERT INTO taxi (matricule, modele, status) VALUES ('XYZ789', 'Toyota', 'Occupe');
INSERT INTO taxi (matricule, modele, status) VALUES ('DEF456', 'Honda', 'Disponible');
INSERT INTO taxi (matricule, modele, status) VALUES ('GHI789', 'Ford', 'Disponible');
INSERT INTO taxi (matricule, modele, status) VALUES ('JKL012', 'Nissan', 'Disponible');
INSERT INTO taxi (matricule, modele, status) VALUES ('MNO345', 'Chevrolet', 'Disponible');
INSERT INTO taxi (matricule, modele, status) VALUES ('PQR678', 'Volkswagen', 'Disponible');
INSERT INTO taxi (matricule, modele, status) VALUES ('STU901', 'Hyundai', 'Disponible');





-- Insertion dans la table conducteur
INSERT INTO conducteur (nom, prenom, telephone, email, matricule) VALUES ('Ahmadi', 'Ahmad', '987654321', 'ahmad.ah@gmail.com', 'ABC123');
INSERT INTO conducteur (nom, prenom, telephone, email, matricule) VALUES ('Youness', 'Sabir', '0856743523', 'youness.sa@gmail.com', 'XYZ789');

-- Insertion dans la table reservation
INSERT INTO reservation (lieuSource, lieuDestination, typePaiement, tarif, date, heure, idClient, idConducteur, matricule)
VALUES ('Mhamid', 'Gueliz', 'CarteBancaire', 50.0, '2023-01-01', '12:00:00', 1, 1, 'ABC123');
