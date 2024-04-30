create table DOCTOR(
  DNI int not null,
  NAME varchar(20) not null,
  SURNAME varchar(20) not null,
  LICENSE varchar(20) not null,
  PRIMARY KEY ( DNI )
);
create table PATIENT(
  DNI int not null,
  NAME varchar(20) not null,
  SURNAME varchar(20) not null,
  ADDRESS varchar(50) not null,
  ENTRY_DATE TIMESTAMP not null,
  PRIMARY KEY ( DNI )
);
create table APPOINTMENT(
  PATIENT_DNI int not null,
  DOCTOR_DNI int not null,
  APPOINTMENT_DATE TIMESTAMP not null,
  PRIMARY KEY ( PATIENT_DNI, DOCTOR_DNI )
);