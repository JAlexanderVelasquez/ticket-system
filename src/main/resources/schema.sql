create table DOCTOR(
  DNI varchar(20) not null,
  NAME varchar(20) not null,
  SURNAME varchar(20) not null,
  LICENSE varchar(20) not null,
  PRIMARY KEY ( DNI )
);
create table PATIENT(
  DNI varchar(20) not null,
  NAME varchar(20) not null,
  SURNAME varchar(20) not null,
  ADDRESS varchar(50) not null,
  ENTRY_DATE date not null,
  PRIMARY KEY ( DNI )
);