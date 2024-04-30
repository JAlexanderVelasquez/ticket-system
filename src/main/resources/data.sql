INSERT INTO doctor (dni,name,surname,license) VALUES ('12345','Jhon','Doe','abc123');
INSERT INTO doctor (dni,name,surname,license) VALUES ('12346','Du','Ke','abc432');
INSERT INTO doctor (dni,name,surname,license) VALUES ('12347','Tim','Lee','abc531');
INSERT INTO doctor (dni,name,surname,license) VALUES ('12348','Dan','Dom','abc475');

INSERT INTO patient (dni,name,surname,address,entry_date) VALUES ('98765','Kai','Vim','street 22','2015-03-11 08:00:00');
INSERT INTO patient (dni,name,surname,address,entry_date) VALUES ('98764','Sim','Call','street 46','2018-07-23 10:00:00');

INSERT INTO appointment (patient_dni,doctor_dni,appointment_date) VALUES ('98765','12345','2023-03-11 15:30:00');
INSERT INTO appointment (patient_dni,doctor_dni,appointment_date) VALUES ('98764','12345','2023-03-13 09:30:00');
INSERT INTO appointment (patient_dni,doctor_dni,appointment_date) VALUES ('98764','12346','2023-03-16 10:00:00');
