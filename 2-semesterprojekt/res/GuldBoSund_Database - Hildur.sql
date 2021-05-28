
-- Use the database dmab0920_STUDYNUMBER
use dmab0920_1086253;

create table Employee(
	id int IDENTITY(1,1)		not null,
	ssn	char(10) UNIQUE			not null,
	employeeNumber int			not null,
	fname varchar(50)			not null,
	lname varchar(50)			not null,
	phoneNumber char(8)	UNIQUE	not null,
	email varchar(50) UNIQUE	not null,
	primary key (id),
);

create table AssistiveDevice(
	id int IDENTITY(1,1)		not null,
	hmiNumber int UNIQUE		not null,
	name varchar(50)			not null,
	type varchar(50)			not null,
	primary key (id),
);

create table ZipCity(
	id int IDENTITY(1,1)		not null,
	postalCode char(4) UNIQUE	not null,
	city varchar(50)			not null,
	primary key (id),
);

create table Resident(
	id int IDENTITY(1,1)		not null,
	ssn	char(10) UNIQUE			not null,
	apartmentNumber int			not null,
	fname varchar(50)			not null,
	lname varchar(50)			not null,
	phoneNumber char(8)	UNIQUE	not null,
	email varchar(50) UNIQUE	not null,
	streetName varchar(50)		not null,
	houseNumber int				not null,
	FKZipCityId int				not null,
	primary key (id),
	foreign key (FKZipCityId) references ZipCity(id),
);

create table Municipality(
	id int IDENTITY(1,1)		not null,
	name varchar(50) UNIQUE		not null,
	region varchar(50)			not null,
	primary key (id),
);

create table Residency(
	id int IDENTITY(1,1)	not null,
	fromDate date			not null,
	toDate date,
	FKresidentId int		not null,
	FKmunicipalityId int	not null,
	primary key (id),
	foreign key (FKresidentId) references Resident(id),
	foreign key (FKmunicipalityId) references Municipality(id),
);

create table AssistiveDeviceInstance(
	id int IDENTITY(1,1)			not null,
	barcode varchar(50) UNIQUE		not null,
	registeredDate date				not null,
	note varchar(50),
	FKassistiveDeviceId int			not null,
	FKmunicipalityId int			not null,
	primary key (id),
	constraint FKassistiveDeviceId
	foreign key (FKassistiveDeviceId) references AssistiveDevice(id)
	ON DELETE CASCADE,
	foreign key (FKmunicipalityId) references Municipality(id),
);

create table Rental(
	id int IDENTITY(1,1)					not null,
	rentalNumber int UNIQUE					not null,
	startDate date							not null,
	endDate date,
	FKemployeeId int						not null,
	FKassistiveDeviceInstanceId int			not null,
	FKresidentId int						not null,
	primary key (id),
	foreign key (FKemployeeId) references Employee(id),
	foreign key (FKassistiveDeviceInstanceId) references AssistiveDeviceInstance(id),
	foreign key (FKresidentId) references Resident(id),
);


insert into Employee values (1304206842, 1, 'Dorte', 'Olesen', 50506982, 'Dorteolesen@yahoo.dk');

insert into AssistiveDevice values (102771, 'Kørestol', 'Personlig');
insert into AssistiveDevice values (101337, 'Krykker', 'Personlig');
insert into AssistiveDevice values (102273, 'Kran', 'Personale');
insert into AssistiveDevice values (35764, 'Iltapparat', 'Personlig');
insert into AssistiveDevice values (2239, 'Elevationsseng', 'Personale');

insert into ZipCity values (6870, 'Ølgod');
insert into ZipCity values (9000, 'Aalborg');
insert into ZipCity values (7442, 'Pårup');
insert into ZipCity values (6900, 'Skjern');
insert into ZipCity values (4800, 'Nykøbing-Falster');

insert into Resident values (1804646469, 13, 'Hening', 'Jensen', 71708706, 'HeningJensen@gmail.dk', 'Hobrovej', 4, 3);
insert into Resident values (2602003551, 8, 'Felix', 'Haahr', 67890401, 'Felix@gmail.dk', 'Mangovej', 23, 1);
insert into Resident values (1990327733, 2, 'Karl', 'Jonson', 55407201, 'Skumbananen@yahoo.dk', 'Liljegade', 7, 2);
insert into Resident values (3990322401, 26, 'Tais', 'Schmidt', 12130988, 'TaisSchmidt@yahoo.dk','Solbærvej', 32, 4);
insert into Resident values (4700540903, 10, 'Jonathan', 'Joestar', 42420612, 'Joestar@hotmail.com', 'Gammelhavn', 17, 5);
insert into Resident values (1337025315, 16, 'Giorno', 'Giovanna', 13376401, 'Goldenwind@gmail.com', 'Æblevej', 22, 3);

insert into Municipality values ('Varde', 'Syddanmark');
insert into Municipality values ('Aalborg', 'Nordjylland');
insert into Municipality values ('Ikast-Brande', 'Midtjylland ');
insert into Municipality values ('Ringkøbing-Skjern', 'Midtjylland');
insert into Municipality values ('Guldborgsund', 'Sjælland');

insert into Residency values ('1950-01-25', null, 1, 2);
insert into Residency values ('1966-05-13', null, 2, 3);
insert into Residency values ('1942-11-11', null, 3, 4);
insert into Residency values ('1968-08-05', null, 4, 1);
insert into Residency values ('1931-10-05', null, 5, 5);
insert into Residency values ('1999-06-07', null, 6, 2);

--Kørestole
insert into AssistiveDeviceInstance values ('143', '2001-01-25', null, 1, 1);
insert into AssistiveDeviceInstance values ('231', '2004-04-4', null, 1, 3);
insert into AssistiveDeviceInstance values ('78', '2019-07-29', null, 1, 4);
--Krykker
insert into AssistiveDeviceInstance values ('4202', '2014-05-18', null, 2, 5);
insert into AssistiveDeviceInstance values ('102', '2019-04-05', null, 2, 4);
insert into AssistiveDeviceInstance values ('13', '2019-06-21', null, 2, 3);
--Kran
insert into AssistiveDeviceInstance values ('1337', '2021-01-01', null, 3, 1);
--Iltapparat
insert into AssistiveDeviceInstance values ('713', '2020-05-19', null, 4, 2);
--Elevationsseng
insert into AssistiveDeviceInstance values ('59', '2020-05-18', null, 5, 2);